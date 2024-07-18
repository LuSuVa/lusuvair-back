package fr.lusuva.lusuvair.controllers;

import static fr.lusuva.lusuvair.utils.ControllerUtils.checkErrors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusuva.lusuvair.dtos.message.MessagePostDto;
import fr.lusuva.lusuvair.entities.Message;
import fr.lusuva.lusuvair.services.MessageService;
import fr.lusuva.lusuvair.utils.ControllerUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private ControllerUtils controllerUtils;

    @Autowired
    private MessageService messageService;


    @Operation(summary = "Create a message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message successfully created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Message.class)) }),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content) })
    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody MessagePostDto messagePostDto,
            @AuthenticationPrincipal UserDetails userDetails, BindingResult bindingResult) {
        checkErrors(bindingResult);

        Message message = messageService.create(messagePostDto, controllerUtils.getUserAccount(userDetails));

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(message);
    }
}
