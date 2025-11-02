package service;

import Data.InMemoryDatabase;
import model.Module;

import java.util.List;

public class ModuleService {
    private final InMemoryDatabase db;

    public ModuleService(InMemoryDatabase db) {
        this.db = db;
    }

    public List<Module> getModules(boolean isSubscribed) {
        return isSubscribed ? db.getSubscribedModules() : db.getFreeModules();
    }

    public void showModules(boolean isSubscribed) {
        System.out.println("\n📚 Available Modules:");
        List<Module> modules = getModules(isSubscribed);
        modules.forEach(m -> System.out.println(m.getModuleInfo()));
    }
}
