package com.example.QuantumSort.repos;

import com.example.QuantumSort.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ListingRepository extends JpaRepository<Listing, Long> {

    @Query("SELECT l FROM Listing l WHERE l.id = ?1 OR l.city LIKE %?1%")
    List<Listing> search(String query);

    Optional<Listing> findById(Long id);
}