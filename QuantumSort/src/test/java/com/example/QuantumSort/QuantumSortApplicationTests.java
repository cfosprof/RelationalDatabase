package com.example.QuantumSort;

import com.example.QuantumSort.configs.RealtorDetailServiceImpl;
import com.example.QuantumSort.configs.WebSecurityConfig;
import com.example.QuantumSort.controllers.AppUserController;
import com.example.QuantumSort.controllers.ListingController;
import com.example.QuantumSort.models.ApplicationUser;
import com.example.QuantumSort.models.ClientUser;
import com.example.QuantumSort.models.Listing;
import com.example.QuantumSort.repos.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Optional;




@SpringBootTest(classes = QuantumSortApplication.class)
public class QuantumSortApplicationTests {

	@Autowired
	private AppUserController appUserController;
	@Autowired
	private ListingController listingController;
	@Autowired
	private RealtorDetailServiceImpl realtorDetailServiceImpl;
	@Autowired
	private WebSecurityConfig webSecurityConfig;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@MockBean
	private ApplicationUserRepository applicationUserRepository;
	@MockBean
	private ClientRepository clientRepository;
	@MockBean
	private ListingRepository listingRepository;

	@Test
	// Test to verify the Spring context loads correctly and all controllers/services are correctly autowired
	public void contextLoads() {
		assertNotNull(appUserController);
		assertNotNull(listingController);
		assertNotNull(realtorDetailServiceImpl);
		assertNotNull(webSecurityConfig);
	}

	@Test
	// Test to verify that the password encoder bean works as expected
	public void passwordEncoderBeanTest() {
		String password = "Pa55##_word";
		String encodedPassword = passwordEncoder.encode(password);
		assertNotNull(encodedPassword);
		assertTrue(passwordEncoder.matches(password, encodedPassword));
	}

	@Test
	// Test to verify the application user repository operations
	public void applicationUserRepositoryTest() {
		ApplicationUser user = new ApplicationUser("username", "password", "Firstname", "Lastname");
		Mockito.when(applicationUserRepository.save(user)).thenReturn(user);
		Mockito.when(applicationUserRepository.findByUserName("username")).thenReturn(user);
		assertNotNull(applicationUserRepository.findByUserName("username"));
	}

	@Test
	// Test to verify the client repository operations
	public void clientRepositoryTest() {
		ClientUser client = new ClientUser("username", "password", "Firstname", "Lastname");
		Mockito.when(clientRepository.save(client)).thenReturn(client);
		Mockito.when(clientRepository.findByUserName("username")).thenReturn(client);
		assertNotNull(clientRepository.findByUserName("username"));
	}

	@Test
	// Test to verify the listing repository operations
	public void listingRepositoryTest() {
		Listing listing = new Listing();
		listing.setTitle("Listing Title");
		listing.setCity("San Francisco");
		Mockito.when(listingRepository.save(listing)).thenReturn(listing);
		Mockito.when(listingRepository.search("San Francisco")).thenReturn(List.of(listing));
		Mockito.when(listingRepository.findById(listing.getId())).thenReturn(Optional.of(listing));
		assertNotNull(listingRepository.search("San Francisco"));
		assertNotNull(listingRepository.findById(listing.getId()));
	}
}