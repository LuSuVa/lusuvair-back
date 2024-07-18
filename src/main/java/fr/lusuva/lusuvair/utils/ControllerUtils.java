package fr.lusuva.lusuvair.utils;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import fr.lusuva.lusuvair.entities.UserAccount;
import fr.lusuva.lusuvair.repositories.UserAccountRepository;

@Component
public class ControllerUtils {
    
    @Autowired
    private UserAccountRepository userAccountRepository;

    public UserAccount getUserAccount(UserDetails userDetails){
        UserAccount userAccount = userAccountRepository.findByEmail(userDetails.getUsername());

        if(userAccount == null){
            throw new NoSuchElementException("User doesn't exist");
        }

        return userAccount;
    }

    /**
     * Check Errors from Validation Error
     * 
     * @param result
     * @throws IllegalArgumentException
     */
    public static void checkErrors(BindingResult result) throws IllegalArgumentException {
        if (result.hasErrors()) {
            throw new IllegalArgumentException(result.getAllErrors().stream().map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("\n")));
        }
    }
}
