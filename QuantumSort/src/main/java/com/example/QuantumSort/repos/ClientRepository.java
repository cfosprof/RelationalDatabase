package com.example.QuantumSort.repos;

import com.example.QuantumSort.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ApplicationUser, Long> {
ApplicationUser findByUsername(String username);
}
