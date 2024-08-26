package fr.lusuva.lusuvair.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusuva.lusuvair.dtos.weather.WeatherResponseDto;
import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.services.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	/**
	 * Get all Weather data
	 *
	 * @return a list of all weather data
	 */
	@Operation(summary = "Get all Weather data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "All Weather data in JSON format", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Weather.class)) }) })
	@GetMapping
	public ResponseEntity<?> getWeather() {
		return ResponseEntity.ok(weatherService.getAll().stream().map(WeatherResponseDto::new).toList());
	}

	/**
	 * Get weather data by its ID
	 *
	 * @param id the ID of the weather data
	 * @return the weather data with the specified ID
	 */
	@Operation(summary = "Get weather data with its ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Weather data in JSON format", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Weather.class)) }) })
	@GetMapping("/{id}")
	public ResponseEntity<?> getWeatherById(@PathVariable int id) {
		return ResponseEntity.ok(new WeatherResponseDto(weatherService.getById(id)));
	}

	/**
	 * Get weather data of a municipality by its ID
	 *
	 * @param id the ID of the municipality
	 * @return the weather data of the municipality with the specified ID
	 */
	@Operation(summary = "Get the weather data of the municipality by its ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Municipality's weather data in JSON format", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Weather.class)) }) })
	@GetMapping("/municipality/{id}")
	public ResponseEntity<?> getWeatherByMunicipalityId(@PathVariable int id) {
		return ResponseEntity.ok(new WeatherResponseDto(weatherService.getByMunicipalityId(id)));
	}

	/**
	 * Get weather data of a municipality by its name
	 *
	 * @param name the name of the municipality
	 * @return the weather data of the municipality with the specified name
	 */
	@Operation(summary = "Get the weather data of the municipality by its name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Municipality's weather data in JSON format", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Weather.class)) }) })
	@GetMapping("/municipality/name/{name}")
	public ResponseEntity<?> getWeatherByMunicipalityName(@PathVariable String name) {
		return ResponseEntity.ok(new WeatherResponseDto(weatherService.getByMunicipalityName(name)));
	}
}
