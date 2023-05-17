package com.example.QuantumSort.controllers;

import com.example.QuantumSort.models.ApplicationUser;
import com.example.QuantumSort.models.Listing;
import com.example.QuantumSort.repos.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    private ListingRepository listingRepository;


    @GetMapping("/")
    public List<Listing> getAllListings() {
        return listingRepository.findAll();
    }

    @GetMapping("/{id}")
    public String getListing(@PathVariable Long id, Model model) {
        Listing listing = listingRepository.findById(id).orElse(null);
        model.addAttribute("listings", listing);
        return "listing";
    }

    @GetMapping("/show")
    public String showListings(Model model) {
        List<Listing> listings = listingRepository.findAll();
        model.addAttribute("listings", new Listing());
        return "listings";
    }

    @PostMapping("/{id}")
    public ResponseEntity<Listing> updateListing(@PathVariable Long id, @RequestBody Listing updatedListing, @AuthenticationPrincipal ApplicationUser user) {
        if (user.isAgent()) {
            return listingRepository.findById(id)
                    .map(listing -> {
                        listing.setAddress(updatedListing.getAddress());
                        listing.setBedrooms(updatedListing.getBedrooms());
                        listing.setBathrooms(updatedListing.getBathrooms());
                        listing.setSquareFeet(updatedListing.getSquareFeet());
                        listing.setYearBuilt(updatedListing.getYearBuilt());
                        listing.setZipCode(updatedListing.getZipCode());
                        listing.setGarage(updatedListing.getGarage());
                        listing.setListPrice(updatedListing.getListPrice());
                        listing.setHasPool(updatedListing.isHasPool());
                        listing.setActive(updatedListing.isActive());
                        Listing updatedListingResult = listingRepository.save(listing);
                        return ResponseEntity.ok(updatedListingResult);
                    }).orElseGet(() -> ResponseEntity.notFound().build());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
