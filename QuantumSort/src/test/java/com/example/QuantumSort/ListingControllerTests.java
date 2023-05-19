package com.example.QuantumSort;

import com.example.QuantumSort.controllers.ListingController;
import com.example.QuantumSort.models.ApplicationUser;
import com.example.QuantumSort.models.Listing;
import com.example.QuantumSort.repos.ListingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ListingControllerTests {
    @Mock
    private ListingRepository listingRepository;

    @Mock
    private Model model;

    @Mock
    private ApplicationUser user;

    @InjectMocks
    private ListingController listingController;

    @Test
    public void testGetAllListings() {
        Listing listing1 = new Listing();
        Listing listing2 = new Listing();
        when(listingRepository.findAll()).thenReturn(Arrays.asList(listing1, listing2));

        List<Listing> listings = listingController.getAllListings();

        verify(listingRepository, times(1)).findAll();
        assertEquals(2, listings.size());
    }

    @Test
    public void testGetListing() {
        Long id = 1L;
        Listing listing = new Listing();
        listing.setId(id);
        when(listingRepository.findById(id)).thenReturn(Optional.of(listing));

        String viewName = listingController.getListing(id, model);

        verify(listingRepository, times(1)).findById(id);
        assertEquals("listing", viewName);
    }

    @Test
    public void testCreateListing() {
        Listing newListing = new Listing();
        newListing.setTitle("New listing");
        when(user.isAgent()).thenReturn(true);
        when(listingRepository.save(newListing)).thenReturn(newListing);

        String viewName = listingController.createListing(newListing, user);

        verify(listingRepository, times(1)).save(newListing);
        assertEquals("redirect:/listings/show", viewName);
    }

    @Test
    public void testDeleteListing() {
        Long id = 1L;
        when(user.isAgent()).thenReturn(true);
        doNothing().when(listingRepository).deleteById(id);

        String viewName = listingController.deleteListing(id, user);

        verify(listingRepository, times(1)).deleteById(id);
        assertEquals("redirect:/listings/show", viewName);
    }
}
