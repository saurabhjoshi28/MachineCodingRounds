import Data.InMemoryDatabase;
import Validator.LoginValidator;
import model.User;
import service.AuthService;
import service.ModuleService;
import service.SubscriptionService;

import java.util.Optional;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InMemoryDatabase db = new InMemoryDatabase();
        LoginValidator validator = new LoginValidator(db);
        SubscriptionService subscriptionService = new SubscriptionService();
        AuthService authService = new AuthService(validator, subscriptionService);
        ModuleService moduleService = new ModuleService(db);

        // Simple console login demo
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Password: ");
            String password = scanner.nextLine().trim();

            Optional<User> maybeUser = authService.login(username, password);
            if (maybeUser.isPresent()) {
                boolean isSubscribed = authService.isSubscribed(username);
                moduleService.showModules(isSubscribed);
            } else {
                System.out.println("Login failed.");
            }
        }
    }
}