package fr.lusuva.lusuvair.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusuva.lusuvair.dtos.UserRegisterDto;
import fr.lusuva.lusuvair.services.UserAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

/**
 * User Account Rest Controller
 */
@RestController
@RequestMapping("/user")
public class UserAccountController {

    /**
     * User Account Service
     */
    @Autowired
    private UserAccountService userAccountService;

    /**
     * POST Route to register an user
     * 
     * @param userRegisterDto
     * @return Status OK if register, or status 400 if not valid
     */
    @Operation(summary = "Register an User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content) })
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDto userRegisterDto, BindingResult bindingResult) {
        userAccountService.register(userRegisterDto);

        // TODO : Add JWT
        return ResponseEntity.ok("User created");
    }

    /**
     * Check Errors from Validation Error
     * 
     * @param result
     * @throws IllegalArgumentException
     */
    protected void checkErrors(BindingResult result) throws IllegalArgumentException {
        if (result.hasErrors()) {
            throw new IllegalArgumentException(result.getAllErrors().stream().map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining("\n")));
        }
    }

    /**
     * Exception Handler for IllegalArgument
     * 
     * @param illegalArgumentException exception
     * @return Bad Requestion response entity
     */
    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException illegalArgumentException) {
        return ResponseEntity.badRequest().body(illegalArgumentException.getMessage());
    }
}
