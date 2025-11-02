package model;

public class Module {
    private String moduleName;
    private String content;

    public Module(String moduleName, String content) {
        this.moduleName = moduleName;
        this.content = content;
    }

    public String getModuleInfo(){
        return "Module name: " + moduleName + ", content: " + content;
    }
}
