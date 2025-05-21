package fr.lusuva.lusuvair.service;

import fr.lusuva.lusuvair.dtos.auth.JwtAuthenticationResponse;
import fr.lusuva.lusuvair.dtos.auth.UserLoginDto;
import fr.lusuva.lusuvair.dtos.auth.UserRegisterDto;
import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.UserAccountRepository;
import fr.lusuva.lusuvair.services.JwtService;
import fr.lusuva.lusuvair.services.UserAccountService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserAccountServiceTest {

    @InjectMocks
    private UserAccountService userAccountService;

    @Mock
    private UserAccountRepository userAccountRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister_Success() {
        UserRegisterDto dto = new UserRegisterDto("Val", "Lerou", "val@test.com", "password");

        when(userAccountRepository.findAllByEmail("val@test.com")).thenReturn(Collections.emptyList());
        when(passwordEncoder.encode("password")).thenReturn("hashedPassword");
        when(userAccountRepository.save(any(UserAccount.class)))
                .thenAnswer(i -> i.getArgument(0));
        when(jwtService.generateToken("val@test.com")).thenReturn("token123");

        JwtAuthenticationResponse response = userAccountService.register(dto);

        assertNotNull(response);
        assertEquals("token123", response.getToken());
        assertEquals(List.of("ROLE_USER"), response.getRole());
    }

    @Test
    public void testRegister_EmailAlreadyUsed() {
        UserRegisterDto dto = new UserRegisterDto("val", "lerou", "val@test.com", "password");

        when(userAccountRepository.findAllByEmail("val@test.com"))
                .thenReturn(List.of(new UserAccount()));

        assertThrows(IllegalArgumentException.class, () -> userAccountService.register(dto));
    }

    @Test
    public void testLogin_Success() {
        UserLoginDto dto = new UserLoginDto("val@test.com", "password");
        UserAccount user = new UserAccount("val", "lerou", "val@test.com", "encodedPass", "ROLE_USER");

        when(userAccountRepository.findByEmail("val@test.com")).thenReturn(user);
        when(jwtService.generateToken("val@test.com")).thenReturn("jwtToken");

        JwtAuthenticationResponse response = userAccountService.login(dto);

        assertNotNull(response);
        assertEquals("jwtToken", response.getToken());
        assertEquals(List.of("ROLE_USER"), response.getRole());
    }

    @Test
    public void testLogin_UserNotFound() {
        UserLoginDto dto = new UserLoginDto("notfound@test.com", "password");

        when(userAccountRepository.findByEmail("notfound@test.com")).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () -> userAccountService.login(dto));
    }

    @Test
    public void testLogin_UserSuspended() {
        UserLoginDto dto = new UserLoginDto("suspended@test.com", "password");
        UserAccount user = new UserAccount("val", "lerou", "suspended@test.com", "encodedPass", "ROLE_USER");
        user.setSuspendedTillDate(LocalDateTime.now().plusDays(1));

        when(userAccountRepository.findByEmail("suspended@test.com")).thenReturn(user);

        assertThrows(Exception.class, () -> userAccountService.login(dto));
    }

    @Test
    public void testSuspend_Success() {
        UserAccount user = new UserAccount("val", "lerou", "val@test.com", "pass", "ROLE_USER");
        user.setId(1);

        when(userAccountRepository.findById(1)).thenReturn(Optional.of(user));

        UserAccount suspendedUser = userAccountService.suspend(1, 5);

        assertNotNull(suspendedUser.getSuspendedTillDate());
        verify(userAccountRepository).save(user);
    }

    @Test
    public void testSuspend_UserNotFound() {
        when(userAccountRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> userAccountService.suspend(999, 5));
    }

    @Test
    public void testUnsuspend_Success() {
        UserAccount user = new UserAccount("val", "lerou", "val@test.com", "pass", "ROLE_USER");
        user.setId(1);

        when(userAccountRepository.findById(1)).thenReturn(Optional.of(user));

        UserAccount unsuspendedUser = userAccountService.unsuspend(1);

        assertTrue(unsuspendedUser.getSuspendedTillDate().isBefore(LocalDateTime.now()));
        verify(userAccountRepository).save(user);
    }

}
