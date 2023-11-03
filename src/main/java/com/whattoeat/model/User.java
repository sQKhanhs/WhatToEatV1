package com.whattoeat.model;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private boolean login;

    public User(){
    }

    public User(String email) {
        super();
        this.email = email;
    }

    public User(String username, boolean login) {
        super();
        this.username = username;
        this.login = login;
    }
    public User(String email, String username) {
        super();
        this.username = username;
        this.email = email;
    }

    public User(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String username, String email, String password) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
