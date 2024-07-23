package fr.lusuva.lusuvair.dtos.weather;

import java.time.LocalDateTime;

import fr.lusuva.lusuvair.dtos.municipality.MunicipalityResponseDto;
import fr.lusuva.lusuvair.entities.Weather;

/**
 * Data Transfer Object for Weather responses.
 */
public class WeatherResponseDto {
    
    /**
     * The unique identifier of the weather record.
     */
    private int id;
    
    /**
     * The date and time of the weather record.
     */
    private LocalDateTime date;
    
    /**
     * The municipality associated with the weather record.
     */
    private MunicipalityResponseDto municipality;
    
    /**
     * The atmospheric pressure recorded.
     */
    private double atmophericPressure;
    
    /**
     * The humidity level recorded.
     */
    private double humidity;
    
    /**
     * The temperature recorded.
     */
    private double temperature;
    
    /**
     * The type of weather.
     */
    private String type;
    
    /**
     * The wind speed recorded.
     */
    private int wind;
    
    /**
     * The direction of the wind recorded.
     */
    private int dirWind;
    
    /**
     * The probability of rain recorded.
     */
    private int probaRain;

    /**
     * Constructs a WeatherResponseDto from a Weather entity.
     *
     * @param weather the Weather entity to convert to a DTO
     */
    public WeatherResponseDto(Weather weather) {
        this.id = weather.getId();
        this.date = weather.getDate();
        this.municipality = new MunicipalityResponseDto(weather.getMunicipality());
        this.atmophericPressure = weather.getAtmophericPressure();
        this.humidity = weather.getHumidity();
        this.temperature = weather.getTemperature();
        this.type = weather.getType().getFrenchDescription();
        this.wind = weather.getWind();
        this.dirWind = weather.getDirWind();
        this.probaRain = weather.getProbaRain();
    }

    /**
     * Gets the unique identifier of the weather record.
     *
     * @return the id of the weather record
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the weather record.
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the date and time of the weather record.
     *
     * @return the date of the weather record
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets the date and time of the weather record.
     *
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Gets the municipality associated with the weather record.
     *
     * @return the municipality of the weather record
     */
    public MunicipalityResponseDto getMunicipality() {
        return municipality;
    }

    /**
     * Sets the municipality associated with the weather record.
     *
     * @param municipality the municipality to set
     */
    public void setMunicipality(MunicipalityResponseDto municipality) {
        this.municipality = municipality;
    }

    /**
     * Gets the atmospheric pressure recorded.
     *
     * @return the atmospheric pressure
     */
    public double getAtmophericPressure() {
        return atmophericPressure;
    }

    /**
     * Sets the atmospheric pressure recorded.
     *
     * @param atmophericPressure the atmospheric pressure to set
     */
    public void setAtmophericPressure(double atmophericPressure) {
        this.atmophericPressure = atmophericPressure;
    }

    /**
     * Gets the humidity level recorded.
     *
     * @return the humidity level
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * Sets the humidity level recorded.
     *
     * @param humidity the humidity level to set
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * Gets the temperature recorded.
     *
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Sets the temperature recorded.
     *
     * @param temperature the temperature to set
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Gets the type of weather.
     *
     * @return the type of weather
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of weather.
     *
     * @param type the type of weather to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the wind speed recorded.
     *
     * @return the wind speed
     */
    public int getWind() {
        return wind;
    }

    /**
     * Sets the wind speed recorded.
     *
     * @param wind the wind speed to set
     */
    public void setWind(int wind) {
        this.wind = wind;
    }

    /**
     * Gets the direction of the wind recorded.
     *
     * @return the wind direction
     */
    public int getDirWind() {
        return dirWind;
    }

    /**
     * Sets the direction of the wind recorded.
     *
     * @param dirWind the wind direction to set
     */
    public void setDirWind(int dirWind) {
        this.dirWind = dirWind;
    }

    /**
     * Gets the probability of rain recorded.
     *
     * @return the probability of rain
     */
    public int getProbaRain() {
        return probaRain;
    }

    /**
     * Sets the probability of rain recorded.
     *
     * @param probaRain the probability of rain to set
     */
    public void setProbaRain(int probaRain) {
        this.probaRain = probaRain;
    }
}
