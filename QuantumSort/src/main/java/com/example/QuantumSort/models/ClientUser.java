package com.example.QuantumSort.models;
import jakarta.persistence.*;
@Entity
@Table(name = "application_clients")
@DiscriminatorValue("client")
public class ClientUser extends ApplicationUser {

    public ClientUser() {
        super();
    }

    public ClientUser(String userName, String password, String firstName, String lastName) {
        super(userName, password, firstName, lastName);
    }
}