package fr.lusuva.lusuvair.dtos.apiweatherdto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.lusuva.lusuvair.deserializers.ObservationDeserializer;

/**
 * DTO corresponding to the response of the Weather API.
 */
public class WeatherTypeDto {

    /** The weather station details */
    private StationDto station;

    /**
     * Object observation
     * 
     * It has a particular deserializer because the response JSON can be 
     * an ObservationDto or an empty array. 
     * So it must be Object to receive both and can be cast later.
     */
    private ObservationDto observation;

    /**
     * Returns the weather station details.
     * 
     * @return the station
     */
    public StationDto getStation() {
        return station;
    }

    /**
     * Sets the weather station details.
     * 
     * @param station the station to set
     */
    public void setStation(StationDto station) {
        this.station = station;
    }

    /**
     * Returns the observation details.
     * 
     * @return the observation
     */
    public ObservationDto getObservation() {
        return observation;
    }

    /**
     * Sets the observation details.
     * 
     * @param observation the observation to set
     */
    @JsonDeserialize(using = ObservationDeserializer.class)
    public void setObservation(Object observation) {
        if (observation instanceof ObservationDto) {
            this.observation = (ObservationDto) observation;
        }
    }
}
