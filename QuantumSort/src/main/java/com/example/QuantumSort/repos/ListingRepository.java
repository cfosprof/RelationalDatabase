package com.example.QuantumSort.repos;

import com.example.QuantumSort.models.ApplicationUser;
import com.example.QuantumSort.models.ClientUser;
import com.example.QuantumSort.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ListingRepository extends JpaRepository<Listing, Long> {

    @Query("SELECT l FROM Listing l WHERE LOWER(l.city) = LOWER(:query)")
    List<Listing> search(@Param("query") String query);

    Optional<Listing> findById(Long id);
}
