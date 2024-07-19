package fr.lusuva.lusuvair.controllers;

import static fr.lusuva.lusuvair.utils.ControllerUtils.checkErrors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusuva.lusuvair.dtos.section.SectionPostDto;
import fr.lusuva.lusuvair.dtos.section.SectionPutDto;
import fr.lusuva.lusuvair.entities.Section;
import fr.lusuva.lusuvair.services.SectionService;
import fr.lusuva.lusuvair.utils.ControllerUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

/**
 * Section Controller
 */
@RestController
@RequestMapping("/sections")
public class SectionController {

    /**
     * Autowired ControllerUtils
     */
    @Autowired
    private ControllerUtils controllerUtils;

    /**
     * Autowired SectionService
     */
    @Autowired
    private SectionService sectionService;

    /**
     * Post a section
     * 
     * @param sectionPostDto Dto expected
     * @param userDetails    Authenticated user
     * @param bindingResult  Validation errors
     * @return 200 with section created in body, 404 if validation failed
     */
    @Operation(summary = "Create a section")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Section successfully created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Section.class)) }),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content) })
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> post(@Valid @RequestBody SectionPostDto sectionPostDto,
            @AuthenticationPrincipal UserDetails userDetails, BindingResult bindingResult) {
        checkErrors(bindingResult);

        Section section = sectionService.create(sectionPostDto, controllerUtils.getUserAccount(userDetails));

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(section);
    }

    /**
     * Get all sections
     * 
     * @return 200 with JSON List of Section body
     */
    @Operation(summary = "Get all sections")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get all", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Section[].class)) }) })
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(sectionService.getAll());
    }

    /**
     * Get a section by id
     * 
     * @param id Path variable expected to be an id
     * @return 200 with JSON Section body, 404 if not found
     */
    @Operation(summary = "Get a section by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get the section correspondig to the id", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Section.class)) }),
            @ApiResponse(responseCode = "404", description = "Section not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(sectionService.getById(id));
    }

    /**
     * Update a section by id
     * 
     * @param id            Path variable expected to be an id
     * @param sectionPutDto Dto expected
     * @param bindingResult Error from validation
     * @return 200 with JSON Section body, 400 if validation failed
     */
    @Operation(summary = "Update a section")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Section successfully created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Section.class)) }),
            @ApiResponse(responseCode = "400", description = "Validation failed", content = @Content),
            @ApiResponse(responseCode = "404", description = "Section not found", content = @Content) })
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateById(@PathVariable int id, @Valid @RequestBody SectionPutDto sectionPutDto,
            BindingResult bindingResult) {
        checkErrors(bindingResult);

        Section section = sectionService.updateById(id, sectionPutDto);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(section);
    }

    /**
     * Delete a section by id
     * The user must be an administrator
     * 
     * @param id Path variable expected to be an id
     * @return 200, 404 if not found
     */
    @SuppressWarnings("rawtypes")
    @Operation(summary = "Delete a section")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Section successfully deleted", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Section.class)) }),
            @ApiResponse(responseCode = "404", description = "Section not found", content = @Content) })
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity deleteById(@PathVariable int id) {
        sectionService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
