package com.addin.publicchat.models;


public class Message {
    private String message;
    private String uid;
    private Long createdAt;
    private String fullName;

    public Message() {
    }

    public Message(String message, String uid, Long createdAt, String name) {
        this.message = message;
        this.uid = uid;
        this.createdAt = createdAt;
        this.fullName = name;
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

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
