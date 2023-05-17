package com.example.QuantumSort.repos;

import com.example.QuantumSort.models.ApplicationUser;
import com.example.QuantumSort.models.ClientUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ApplicationUser, Long> {
     ClientUser findByUserName(String username);


}
