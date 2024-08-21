package fr.lusuva.lusuvair.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusuva.lusuvair.dtos.AirQuality.AirQualityReponseDto;
import fr.lusuva.lusuvair.dtos.weather.WeatherResponseDto;
import fr.lusuva.lusuvair.entities.AirQuality;
import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.services.AirQualityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

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
    @GetMapping("/municipality/name/{name}")
    public ResponseEntity<?> getWeatherByMunicipalityName(@PathVariable String name) {
        return ResponseEntity.ok(new AirQualityReponseDto(airQualityService.getByMunicipalityName(name)));
    } 
}
