package fr.lusuva.lusuvair.controllers;

import static fr.lusuva.lusuvair.utils.ControllerUtils.checkErrors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusuva.lusuvair.dtos.auth.JwtAuthenticationResponse;
import fr.lusuva.lusuvair.dtos.auth.UserLoginDto;
import fr.lusuva.lusuvair.dtos.auth.UserRegisterDto;
import fr.lusuva.lusuvair.services.UserAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
            @ApiResponse(responseCode = "200", description = "User successfully created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JwtAuthenticationResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content) })
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDto userRegisterDto,
            BindingResult bindingResult) {
        checkErrors(bindingResult);

        JwtAuthenticationResponse token = userAccountService.register(userRegisterDto);

        return ResponseEntity.ok(token);
    }

    /**
     * POST Route to log an user
     * 
     * @param userLoginDto UserLoginDto
     * @return Status OK if register, or status 400 if not valid
     */
    @Operation(summary = "Log an User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully logged in", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JwtAuthenticationResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content) })
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDto userLoginDto, BindingResult bindingResult) {
        checkErrors(bindingResult);

        JwtAuthenticationResponse token = userAccountService.login(userLoginDto);

        return ResponseEntity.ok(token);
    }
}
