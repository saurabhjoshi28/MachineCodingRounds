package Data;

import model.User;
import model.Module;

import java.util.*;

public class InMemoryDatabase {
    private Map<String, User> users = new HashMap<>();
    private List<Module> freeModules = new ArrayList<>();
    private List<Module> subscribedModules = new ArrayList<>();

    public InMemoryDatabase() {
        seedUsers();
        seedModules();
    }
    private void seedUsers(){
        users.put("Saurabh", new User("Saurabh", "123"));
        users.put("guest", new User("guest", "guest"));
        users.put("admin", new User("admin", "admin"));
    }

    private void seedModules(){
        freeModules.add(new Module("Intro to Renaissance", "Basics of platform"));
        freeModules.add(new Module("Getting Started", "Free trial overview"));

        subscribedModules.add(new Module("Advanced Calculus", "Full course content"));
        subscribedModules.add(new Module("Machine Learning 101", "Hands-on course"));
        subscribedModules.add(new Module("Philosophy of Education", "In-depth course"));
    }

    public Optional<User> findUserByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }

    public List<Module> getFreeModules() {
        return Collections.unmodifiableList(freeModules);
    }

    public List<Module> getSubscribedModules() {
        return Collections.unmodifiableList(subscribedModules);
    }

    // Utilities for testing / adding new users if needed
    public void addUser(User user) {
        users.put(user.getUserName(), user);
    }
}
