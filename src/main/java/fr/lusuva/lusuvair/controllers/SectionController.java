package fr.lusuva.lusuvair.controllers;

import static fr.lusuva.lusuvair.utils.ControllerUtils.checkErrors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusuva.lusuvair.dtos.section.SectionPostDto;
import fr.lusuva.lusuvair.entities.Section;
import fr.lusuva.lusuvair.services.SectionService;
import fr.lusuva.lusuvair.utils.ControllerUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sections")
public class SectionController {
    @Autowired
    private ControllerUtils controllerUtils;

    @Autowired
    private SectionService sectionService;

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
}
