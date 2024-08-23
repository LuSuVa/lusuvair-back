package fr.lusuva.lusuvair.controllers;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusuva.lusuvair.dtos.AirQuality.AirQualityReponseDto;
import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.services.AirQualityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.NonUniqueResultException;

/**
 * Rest Controller for managing {@code AirQuality} entities.
 * 
 * This controller provides endpoints to retrieve AirQuality data from the database.
 */
@RestController
@RequestMapping("/airQualities")
public class AirQualityController {

    @Autowired
    private AirQualityService airQualityService;

    /**
     * Get all airQualities
     * 
     * Retrieves a list of all AirQuality entities from the database.
     * 
     * @return ResponseEntity containing the list of AirQualityReponseDto objects and a status of 200 OK
     */
    @Operation(summary = "Get all airQualities")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get all", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = AirQualityReponseDto[].class)) }) })
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(airQualityService.getAll().stream()
                .map(airQuality -> new AirQualityReponseDto(airQuality)).collect(Collectors.toList()));
    }

    /**
     * Get airQuality by ID
     * 
     * Retrieves an AirQuality entity by its ID.
     * 
     * @param id the ID of the AirQuality entity to be retrieved
     * @return ResponseEntity containing the AirQualityReponseDto object and a status of 200 OK
     */
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(new AirQualityReponseDto(airQualityService.getById(id)));
    }
    
    /**
     * Get air quality data of a municipality by its name
     *
     * @param name the name of the municipality
     * @return the air quality data of the municipality with the specified name
     */
    @Operation(summary = "Get the air quality data of the municipality by its name")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200",
                     description = "Municipality's air quality data in JSON format",
                     content = {@Content(mediaType ="application/json", schema = @Schema(implementation = AirQuality.class))})
    })
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/municipality/name/{name}")
    public ResponseEntity<?> getByMunicipalityName(@PathVariable String name) {
             Object result = airQualityService.getByMunicipalityName(name);

             if (result instanceof AirQuality[]) {
                 AirQuality[] resultArray = (AirQuality[]) result;

                 if (resultArray.length > 0) {
                     return ResponseEntity.ok(new AirQualityReponseDto(resultArray[0]));
                 } else {
                     return ResponseEntity.noContent().build();
                 }
             } else if (result instanceof AirQuality) {
              
                 return ResponseEntity.ok(new AirQualityReponseDto((AirQuality) result));
             } else {
                 return ResponseEntity.notFound().build();
             }
    } 
}
