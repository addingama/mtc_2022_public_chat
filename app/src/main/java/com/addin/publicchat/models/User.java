package com.addin.publicchat.models;

public class User {
    private String name;
    private String email;
    private String random;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.random = "Apaaja";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }
}
