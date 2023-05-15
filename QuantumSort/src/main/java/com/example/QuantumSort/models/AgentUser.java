package com.example.QuantumSort.models;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class AgentUser extends ApplicationUser{
        private String email;

//        @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
//        private List<Listing> listingList;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

