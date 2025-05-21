package fr.lusuva.lusuvair.controllers;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import fr.lusuva.lusuvair.services.UserDetailsServiceImpl;

/**
 * Class managing all expected Exception in Controllers
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    /**
     * Exception Handler for IllegalArgument
     * 
     * @param illegalArgumentException exception
     * @return Bad Requestion response entity
     */
    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException illegalArgumentException) {
    	logger.error(illegalArgumentException.getMessage());
        return ResponseEntity.badRequest().body(illegalArgumentException.getMessage());
    }

    /**
     * Exception Handler for NoSuchElement
     * 
     * @param noSuchElementException exception
     * @return Not found response entity
     */
    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<String> noSuchElementExceptionHandler(NoSuchElementException noSuchElementException) {
    	logger.error(noSuchElementException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(noSuchElementException.getMessage());
    }
    
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException ex) {
    	logger.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }

    /**
     * Exception Handler for AuthenticationServiceException
     * 
     * @param authenticationServiceException exception
     * @return Unauthoried response entity
     */
    @ExceptionHandler(AuthenticationServiceException.class)
    private ResponseEntity<String> authenticationServiceException(AuthenticationServiceException authenticationServiceException) {
    	logger.error(authenticationServiceException.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authenticationServiceException.getMessage());
    }
}
