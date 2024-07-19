package fr.lusuva.lusuvair.controllers;

import static fr.lusuva.lusuvair.utils.ControllerUtils.checkErrors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusuva.lusuvair.dtos.forum.ForumPostDto;
import fr.lusuva.lusuvair.dtos.forum.ForumResponseDto;
import fr.lusuva.lusuvair.dtos.section.SectionResponseDto;
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
     * Get all forums
     * 
     * @return 200 with JSON List of Message body
     */
    @Operation(summary = "Get all forums")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get all", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ForumResponseDto[].class)) }) })
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(forumService.getAll().stream().map(ForumResponseDto::new).toList());
    }

    /**
     * Get a forum by id
     * 
     * @param id Path variable expected to be an id
     * @return 200 with JSON Message body, 404 if not found
     */
    @Operation(summary = "Get a forum by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get the forum correspondig to the id", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ForumResponseDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Forum not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(new ForumResponseDto(forumService.getById(id)));
    }

    /**
     * Get a forum by id
     * 
     * @param id Path variable expected to be an id
     * @return 200 with JSON Message body, 404 if not found
     */
    @Operation(summary = "Get all sections of a forum by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get the forum correspondig to the id", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = SectionResponseDto[].class)) }),
            @ApiResponse(responseCode = "404", description = "Forum not found", content = @Content) })
    @GetMapping("/{id}/sections")
    public ResponseEntity<?> getAllSectionsByForumId(@PathVariable int id) {
        return ResponseEntity.ok(forumService.getById(id).getSections().stream().map(SectionResponseDto::new).toList());
    }

    /**
     * Post a forum if the user is an administrator
     * 
     * @param forumPostDto  Dto expected
     * @param bindingResult Error from validation
     * @return 200 with JSON Forum body, 400 if validation failed
     */
    @Operation(summary = "Create a forum")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Forum successfully created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ForumResponseDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content) })
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> post(@Valid @RequestBody ForumPostDto forumPostDto,
            BindingResult bindingResult) {
        checkErrors(bindingResult);

        Forum forum = forumService.create(forumPostDto);

        return ResponseEntity.ok(new ForumResponseDto(forum));
    }

    /**
     * Update a forum by id
     * 
     * @param id            Path variable expected to be an id
     * @param forumPostDto  Dto expected
     * @param bindingResult Error from validation
     * @return 200 with JSON Forum body, 400 if validation failed, 404 if not found
     */
    @Operation(summary = "Update a forum")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Forum successfully updated", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ForumResponseDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content),
            @ApiResponse(responseCode = "404", description = "Forum not found", content = @Content) })
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateById(@PathVariable int id, @Valid @RequestBody ForumPostDto forumPostDto,
            BindingResult bindingResult) {
        checkErrors(bindingResult);

        Forum forum = forumService.updateById(id, forumPostDto);

        return ResponseEntity.ok(new ForumResponseDto(forum));
    }

    /**
     * Delete a forum by id
     * The user must be an administrator
     * 
     * @param id Path variable expected to be an id
     * @return 200, 404 if not found
     */
    @SuppressWarnings("rawtypes")
    @Operation(summary = "Delete a forum")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Forum successfully deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Forum not found", content = @Content) })
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteById(@PathVariable int id) {
        forumService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
