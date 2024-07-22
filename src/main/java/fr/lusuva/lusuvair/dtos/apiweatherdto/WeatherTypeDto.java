package fr.lusuva.lusuvair.dtos.apiweatherdto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fr.lusuva.lusuvair.deserializers.ObservationDeserializer;

/**
 * Dto corresponding to the response of Weather API
 */
public class WeatherTypeDto {

	StationDto station;

	/**
	 * Object observation
	 * 
	 * It has a particular deserializer because response JSON can be ObservationDto
	 * or an empty array
	 * 
	 * So it must be Object to receive both and can be casted later
	 */
	@JsonDeserialize(using = ObservationDeserializer.class)
	Object observation;

	/**
	 * @param station
	 * @param observation
	 */
	public WeatherTypeDto(StationDto station, Object observation) {
		this.station = station;
		this.observation = observation;
	}

	/**
	 * @return the station
	 */
	public StationDto getStation() {
		return station;
	}

	/**
	 * @param station the station to set
	 */
	public void setStation(StationDto station) {
		this.station = station;
	}

	/**
	 * @return the observation
	 */
	public Object getObservation() {
		return observation;
	}

	/**
	 * @param observation the observation to set
	 */
	public void setObservation(Object observation) {
		this.observation = observation;
	}

}
