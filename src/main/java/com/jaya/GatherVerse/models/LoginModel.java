package com.jaya.GatherVerse.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginModel {

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 15, message = "Username must be of range 3-15")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 15, message = "Password must be of range 8-15")
    private String password;

    @NotBlank(message = "Role is required")
    private String role; // New field for role

    public LoginModel() {
        super();
    }

    public LoginModel(String username, String password, String role) {
        super();
        this.username = username;
        this.password = password;
        this.role = role; // Initialize role
    }

    @Override
    public String toString() {
        return "LoginModel [username= " + username + ", password= " + password + ", role= " + role + "]"; // Include role in toString
    }

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

    public String getRole() { // Getter for role
        return role;
    }

    public void setRole(String role) { // Setter for role
        this.role = role;
    }
}
