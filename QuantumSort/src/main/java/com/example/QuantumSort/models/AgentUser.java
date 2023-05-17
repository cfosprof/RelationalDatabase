package com.example.QuantumSort.models;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class AgentUser extends ApplicationUser{
        private String email;

    public AgentUser(String userName, String password, String firstName, String lastName) {
        super(userName, password, firstName, lastName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

