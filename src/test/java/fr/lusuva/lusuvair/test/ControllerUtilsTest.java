package fr.lusuva.lusuvair.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.UserAccountRepository;
import fr.lusuva.lusuvair.utils.ControllerUtils;

public class ControllerUtilsTest {

	@Mock
    private UserAccountRepository userAccountRepository;

    @InjectMocks
    private ControllerUtils controllerUtils;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testGetUserAccountValidUser() {
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("usertest@example.com");

        UserAccount userAccount = new UserAccount();
        when(userAccountRepository.findByEmail("usertest@example.com")).thenReturn(userAccount);

        UserAccount result = controllerUtils.getUserAccount(userDetails);

        assertEquals(userAccount, result);
    }
    
    @Test
    public void testGetUserAccountUserNotFound() {
        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("usertest@example.com");
        when(userAccountRepository.findByEmail("usertest@example.com")).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> {
            controllerUtils.getUserAccount(userDetails);
        });
    }
    
    @Test
    public void testCheckErrorsWithErrors() {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);
        when(result.getAllErrors()).thenReturn(List.of(new ObjectError("field", "Invalid value")));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ControllerUtils.checkErrors(result);
        });

        assertTrue(exception.getMessage().contains("Invalid value"));
    }

    @Test
    public void testCheckErrorsNoErrors() {
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);

        assertDoesNotThrow(() -> {
            ControllerUtils.checkErrors(result);
        });
    }
    
}
