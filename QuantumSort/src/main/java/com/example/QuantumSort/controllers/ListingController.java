package com.example.QuantumSort.controllers;
package com.example.QuantumSort.repos;

import com.example.QuantumSort.models.ApplicationUser;
import com.example.QuantumSort.models.Listing;
import com.example.QuantumSort.repos.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@Controller

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

    @GetMapping("/{id}/details")
    public String viewListing(@PathVariable("id") Long id, Model model) {
        Optional<Listing> listing = listingRepository.findById(id);
        if (listing.isPresent()) {
            model.addAttribute("listing", listing.get());
            return "listingDetails";
        } else {
            return "error";
        }
    }

    @GetMapping("/show")
    public String showListings(Model model) {
        List<Listing> listings = listingRepository.findAll();
        model.addAttribute("listings", listings);
        return "listings";
    }


    @GetMapping("/listingDetails/{id}")
    public String showListingDetails(@PathVariable("id") Long id, Model model) {
        Listing listing = listingRepository.findById(id).orElse(null);
        model.addAttribute("listing", listing);
        return "listingDetails";
    }

    @PostMapping("/new")
    public String createListing(@ModelAttribute Listing newListing, @AuthenticationPrincipal ApplicationUser user) {
        if (user.isAgent()) {
            listingRepository.save(newListing);
            return "redirect:/listings/show";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/search")
    public String searchForm() {
        return "search";
    }

    @GetMapping("/searchResults")
    public String search(@RequestParam String query, Model model) {
        List<Listing> listings = listingRepository.search(query);
        model.addAttribute("listings", listings);
        return "searchResults";
    }

      @DeleteMapping("/delete/{id}")
    public String deleteListing(@PathVariable("id") Long id, @AuthenticationPrincipal ApplicationUser user) {
        if (user.isAgent()) {
            listingRepository.deleteById(id);
            return "redirect:/listings/show";
        } else {
            return "redirect:/login";
        }
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
