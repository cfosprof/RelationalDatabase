package com.example.QuantumSort.repos;

import com.example.QuantumSort.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
     ApplicationUser findByUserName(String userName);
}