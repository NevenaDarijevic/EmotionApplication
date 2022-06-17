package com.example.emotionapp;

public class User {
    public String username;
    public String password;
    public String ime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public User(String username, String password, String ime) {
        this.password = password;
        this.username = username;
        this.ime = ime;
    }
    public User() {
    }
}
