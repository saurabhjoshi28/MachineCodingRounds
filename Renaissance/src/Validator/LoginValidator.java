package Validator;

import Data.InMemoryDatabase;
import model.User;

import java.util.Map;
import java.util.Optional;

public class LoginValidator {

    private InMemoryDatabase db;

    public LoginValidator(InMemoryDatabase db) {
        this.db = db;
    }

    public Optional<User> validate(String userName, String passWord) {
        if (userName == null || userName.isEmpty() || passWord == null || passWord.isEmpty()) {
            System.out.println("❌ Username or password cannot be empty.");
            return Optional.empty();
        }

        Optional<User> maybeUser = db.findUserByUsername(userName);

        if (maybeUser.isEmpty()) {
            System.out.println("🆕 User not found. Registering new user...");
            User newUser = new User(userName, passWord);
            db.addUser(newUser);
            System.out.println("✅ User registered successfully! Welcome, " + newUser.getUserName() + ".");
            return Optional.of(newUser);
        }
        User user = maybeUser.get();
        if (!user.getPassWord().equals(passWord)) {
            System.out.println("❌ Incorrect password.");
            return Optional.empty();
        }

        System.out.println("✅ Login successful! Welcome, " + user.getUserName() + ".");
        return Optional.of(user);
    }
}
