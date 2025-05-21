package fr.lusuva.lusuvair.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Base64;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import fr.lusuva.lusuvair.services.JwtService;

class JwtServiceTest {

    private JwtService jwtService;

    private final String secretKey = Base64.getEncoder().encodeToString("secret-key-for-testing-1234567890".getBytes());

    @BeforeEach
    void setUp() {
        jwtService = new JwtService();

        // Inject manually the secret key (simulating @Value)
        try {
            var field = JwtService.class.getDeclaredField("jwtSigningKey");
            field.setAccessible(true);
            field.set(jwtService, secretKey);
        } catch (Exception e) {
            throw new RuntimeException("Could not set jwtSigningKey for test", e);
        }
    }

    @Test
    void testGenerateTokenAndExtractUsername() {
        String username = "testuser";
        String token = jwtService.generateToken(username);

        assertNotNull(token);
        String extractedUsername = jwtService.extractUsername(token);
        assertEquals(username, extractedUsername);
    }

    @Test
    void testValidateToken_Success() {
        UserDetails userDetails = new User("testuser", "password", new java.util.ArrayList<>());
        String token = jwtService.generateToken(userDetails.getUsername());

        assertTrue(jwtService.validateToken(token, userDetails));
    }

    @Test
    void testValidateToken_FailWithDifferentUser() {
        UserDetails realUser = new User("testuser", "password", new java.util.ArrayList<>());
        UserDetails fakeUser = new User("otheruser", "password", new java.util.ArrayList<>());

        String token = jwtService.generateToken(realUser.getUsername());

        assertFalse(jwtService.validateToken(token, fakeUser));
    }
}
