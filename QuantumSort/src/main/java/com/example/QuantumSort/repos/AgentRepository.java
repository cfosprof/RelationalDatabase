package com.example.QuantumSort.repos;

import com.example.QuantumSort.models.AgentUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<AgentUser, Long> {

    AgentUser findByUsername(String username);

}
