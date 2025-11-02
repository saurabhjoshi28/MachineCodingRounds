package service;

public class SubscriptionService {
    public boolean isSubscribed(String userName){
        if (userName == null) return false;
        return userName.equalsIgnoreCase("saurabh") || userName.equalsIgnoreCase("admin");
    }
}
