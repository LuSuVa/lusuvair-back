package fr.lusuva.lusuvair.controllers;

import static fr.lusuva.lusuvair.utils.ControllerUtils.checkErrors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusuva.lusuvair.dtos.forum.ForumPostDto;
import fr.lusuva.lusuvair.entities.Forum;
import fr.lusuva.lusuvair.services.ForumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

/**
 * ForumController
 */
@RestController
@RequestMapping("/forums")
public class ForumController {

    /**
     * Autowired ForumService
     */
    @Autowired
    private ForumService forumService;

    /**
     * Post a forum if the user is an administrator
     * 
     * @param forumPostDto  Dto expected
     * @param userDetails   Authenticated user
     * @param bindingResult Error from validation
     * @return 200 with JSON Message body, 404 if validation failed
     */
    @Operation(summary = "Create a message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message successfully created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Forum.class)) }),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content) })
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> post(@Valid @RequestBody ForumPostDto forumPostDto,
            BindingResult bindingResult) {
        checkErrors(bindingResult);

        Forum forum = forumService.create(forumPostDto);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(forum);
    }
}
