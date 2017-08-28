package org.launchcode.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Wilson Chan on 8/23/2017.
 */
public class User {

    @NotNull
    @Size(min = 5, max = 15, message = "Usernames must be 5 to 15 characters in length")
    private String username;

    private final int userId;
    private static int nextId = 1;

    @Email(message = "Please enter a valid email address")
    private String email;

    @NotNull
    @Size(min = 6, message = "Password must be a minimum of 6 characters in length")
    private String password;

    public User(String username, String email, String password){
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        userId = nextId;
        nextId++;
    }

    public int getUserId() {
        return userId;
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