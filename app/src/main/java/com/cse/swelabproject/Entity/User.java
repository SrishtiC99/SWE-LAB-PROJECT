package com.cse.swelabproject.Entity;

import androidx.room.Entity;

@Entity(tableName = "user_table")
public class User {
    private String userId;
    private String name;
    private String emailId;
    private String password;
    private boolean isAdmin;

    public User(String name, String emailId, String password, boolean isAdmin) {
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
