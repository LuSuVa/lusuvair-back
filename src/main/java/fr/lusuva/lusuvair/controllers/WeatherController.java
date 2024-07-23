package fr.lusuva.lusuvair.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lusuva.lusuvair.dtos.message.MessageResponseDto;
import fr.lusuva.lusuvair.entities.Weather;
import fr.lusuva.lusuvair.enums.WeatherType;
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
	WeatherService weatherService;
	
	@Operation(summary = "Get all Weather data")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "All Weather data in JSON format",
					content = {@Content(mediaType ="application/json",schema = @Schema(implementation = Weather.class))})
	})
	@GetMapping
    public List<Weather> getWeather() {
        return weatherService.getAll();
    }
	
	@Operation(summary = "Get weather data with his ID ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Weather data in JSON format",
					content = {@Content(mediaType ="application/json",schema = @Schema(implementation = Weather.class))})
	})
	@GetMapping("/{id}")
    public Weather getWeatherById(@PathVariable int id) {
        return weatherService.getById(id);
    }
	
	@Operation(summary = "Get the weather data of the municipality with his id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Municiaplity's weather data in JSON format",
					content = {@Content(mediaType ="application/json",schema = @Schema(implementation = Weather.class))})
	})
	@GetMapping("/municipality/{id}")
    public ResponseEntity<?> getWeatherByMunicipalityId(@PathVariable int id) {
        return ResponseEntity.ok(weatherService.getByMunicipalityId(id));
    }
	
	@Operation(summary = "Get the weather data of the municipality with his name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					description = "Municiaplity's weather data in JSON format",
					content = {@Content(mediaType ="application/json",schema = @Schema(implementation = Weather.class))})
	})
	@GetMapping("/municipality/{name}")
    public ResponseEntity<?> getWeatherByMunicipalityName(@PathVariable String name) {
		return ResponseEntity.ok(weatherService.getByMunicipalityName(name));
    }
	
	@Operation(summary = "Add a weather data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message successfully liked", content = @Content),
            @ApiResponse(responseCode = "404", description = "Message not found", content = @Content) })
    @PostMapping("/{pressure}/{date}/{dirWind}/{humidity}/{probaRain}/{temperature}/{type}/{wind}")
	public ResponseEntity<?> addWeather(@PathVariable int pressure,@PathVariable String date,@PathVariable int dirWind,@PathVariable int humidity,@PathVariable int probaRain,@PathVariable int temperature,@PathVariable int type, @PathVariable int wind){
		
		Weather weather = new Weather();
		
		weather.setAtmophericPressure(pressure);
        weather.setDate(LocalDateTime.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")));
        weather.setDirWind(dirWind);
        weather.setHumidity(humidity);
        weather.setProbaRain(probaRain);
        weather.setTemperature(temperature);
        weather.setType(WeatherType.getWeatherType(type));
        weather.setWind(wind);
		
		weatherService.insertNewWeather(weather);

        return ResponseEntity.ok().build();
	}
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Message successfully created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation failed", content = @Content),
			@ApiResponse(responseCode = "404", description = "Message not found", content = @Content) })
	@PutMapping("/{id}/{pressure}/{date}/{dirWind}/{humidity}/{probaRain}/{temperature}/{type}/{wind}")
	public ResponseEntity<?> updateWeather(@PathVariable int id,@PathVariable int pressure,@PathVariable String date,@PathVariable int dirWind,@PathVariable int humidity,@PathVariable int probaRain,@PathVariable int temperature,@PathVariable int type, @PathVariable int wind){
		Weather weather = new Weather();
		
		weather.setAtmophericPressure(pressure);
        weather.setDate(LocalDateTime.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")));
        weather.setDirWind(dirWind);
        weather.setHumidity(humidity);
        weather.setProbaRain(probaRain);
        weather.setTemperature(temperature);
        weather.setType(WeatherType.getWeatherType(type));
        weather.setWind(wind);
		
		weatherService.updateById(id,weather);
		
		return ResponseEntity.ok().build();
	}

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Message successfully created", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Validation failed", content = @Content),
			@ApiResponse(responseCode = "404", description = "Message not found", content = @Content) })
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteWeather(@PathVariable int id){
		weatherService.deleteById(id);
		
		return ResponseEntity.ok("Weather data sucessfuly deleted");
	}
}
