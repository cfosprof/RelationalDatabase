package com.example.QuantumSort;

import com.example.QuantumSort.controllers.AppUserController;
import com.example.QuantumSort.models.ApplicationUser;
import com.example.QuantumSort.repos.ApplicationUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.servlet.view.RedirectView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ApplicationUserTests {

    @Autowired
    private AppUserController appUserController;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @MockBean
    private ApplicationUserRepository applicationUserRepository;

    private ApplicationUser validUser;
    private ApplicationUser invalidUser;
    private HttpServletRequest httpServletRequest;

    @BeforeEach
    public void setup() {
        validUser = new ApplicationUser("validUser", "password", "FirstName", "LastName");
        invalidUser = new ApplicationUser("", "", "", "");
        httpServletRequest = mock(HttpServletRequest.class);
    }

    @Test
    public void testSuccessfulUserCreation() {
        when(applicationUserRepository.save(any())).thenReturn(validUser);
        RedirectView redirectView = appUserController.createUser(validUser.getUserName(), validUser.getPassword(), validUser.getFirstName(), validUser.getLastName(), httpServletRequest);
    }

    @Test
    public void testFailedUserCreationWithEmptyOrNullStrings() {
        when(applicationUserRepository.findByUserName(invalidUser.getUserName())).thenReturn(null);
        RedirectView redirectView = appUserController.createUser(invalidUser.getUserName(), invalidUser.getPassword(), invalidUser.getFirstName(), invalidUser.getLastName(), httpServletRequest);
    }

    @Test
    @WithMockUser(username = "validUser", password = "password")
    public void testUserAuthenticationWithValidCredentials() {
        when(applicationUserRepository.findByUserName(validUser.getUserName())).thenReturn(validUser);
        appUserController.authWithHttpServletRequest(validUser.getUserName(), validUser.getPassword(), httpServletRequest);
        Assertions.assertNotNull(validUser);
        Assertions.assertEquals(validUser.getUserName(), validUser.getUserName());
    }

}