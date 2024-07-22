package fr.lusuva.lusuvair.dtos.apiweatherdto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fr.lusuva.lusuvair.deserializers.ObservationDeserializer;

/**
 * Dto corresponding to the response of Weather API
 */
public class WeatherTypeDto {

	private StationDto station;

	/**
	 * Object observation
	 * 
	 * It has a particular deserializer because response JSON can be ObservationDto
	 * or an empty array
	 * 
	 * So it must be Object to receive both and can be casted later
	 */
	private ObservationDto observation;

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
	public ObservationDto getObservation() {
		return observation;
	}

	/**
	 * @param observation the observation to set
	 */
	@JsonDeserialize(using = ObservationDeserializer.class)
	public void setObservation(Object observation) {
		if (observation instanceof ObservationDto)
			this.observation = (ObservationDto) observation;
	}

}
