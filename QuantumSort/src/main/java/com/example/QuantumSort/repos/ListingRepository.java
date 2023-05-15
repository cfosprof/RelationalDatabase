package com.example.QuantumSort.repos;

import com.example.QuantumSort.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingRepository extends JpaRepository<Listing, Long> {

    Listing findById(String id);
}
