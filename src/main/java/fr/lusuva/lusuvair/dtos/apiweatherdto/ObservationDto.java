package fr.lusuva.lusuvair.dtos.apiweatherdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * DTO representing weather observations.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObservationDto {
    
    /** The observation time */
    private String time;
    
    /** The temperature observation */
    private ObservationValueDto temperature;
    
    /** The humidity observation */
    private ObservationValueDto humidity;
    
    /** The barometric pressure observation */
    private ObservationValueDto barometer;

    /**
     * Constructs a new ObservationDto with default values.
     */
    public ObservationDto() {
    }

    /**
     * Constructs a new ObservationDto with the specified values.
     * 
     * @param time the observation time in ISO8601 format
     * @param temperature the temperature observation
     * @param humidity the humidity observation
     * @param barometer the barometric pressure observation
     */
    public ObservationDto(String time, ObservationValueDto temperature, ObservationValueDto humidity,
                          ObservationValueDto barometer) {
        this.time = time;
        this.temperature = temperature;
        this.humidity = humidity;
        this.barometer = barometer;
    }

    /**
     * Returns the observation time.
     * 
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the observation time.
     * 
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Returns the temperature observation.
     * 
     * @return the temperature
     */
    public ObservationValueDto getTemperature() {
        return temperature;
    }

    /**
     * Sets the temperature observation.
     * 
     * @param temperature the temperature to set
     */
    public void setTemperature(ObservationValueDto temperature) {
        this.temperature = temperature;
    }

    /**
     * Returns the humidity observation.
     * 
     * @return the humidity
     */
    public ObservationValueDto getHumidity() {
        return humidity;
    }

    /**
     * Sets the humidity observation.
     * 
     * @param humidity the humidity to set
     */
    public void setHumidity(ObservationValueDto humidity) {
        this.humidity = humidity;
    }

    /**
     * Returns the barometric pressure observation.
     * 
     * @return the barometer
     */
    public ObservationValueDto getBarometer() {
        return barometer;
    }

    /**
     * Sets the barometric pressure observation.
     * 
     * @param barometer the barometer to set
     */
    public void setBarometer(ObservationValueDto barometer) {
        this.barometer = barometer;
    }
}
