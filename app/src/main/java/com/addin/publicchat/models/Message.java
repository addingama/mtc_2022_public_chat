package com.addin.publicchat.models;

public class Message {
    private String message;
    private String uid;
    private Double createdAt;

    public Message(String message, String uid, Double createdAt) {
        this.message = message;
        this.uid = uid;
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Double getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Double createdAt) {
        this.createdAt = createdAt;
    }
}
