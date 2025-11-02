package service;

import Validator.LoginValidator;
import model.User;

import java.util.Optional;

public class AuthService {
    private final LoginValidator validator;
    private final SubscriptionService subscriptionService;

    public AuthService(LoginValidator validator, SubscriptionService subscriptionService) {
        this.validator = validator;
        this.subscriptionService = subscriptionService;
    }

    /**
     * Attempts login and returns Optional<User> if success.
     * Caller can then query subscription status using subscriptionService.
     */
    public Optional<User> login(String username, String password) {
        return validator.validate(username, password);
    }

    public boolean isSubscribed(String username) {
        return subscriptionService.isSubscribed(username);
    }
}
