package model;

public class User {
    private String userName;
    private String passWord;

    public User(String userName, String passWord) {
        this.passWord = passWord;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
