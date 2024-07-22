package fr.lusuva.lusuvair.dtos.apiweatherdto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fr.lusuva.lusuvair.deserializers.ObservationDeserializer;

public class WeatherTypeDto {
	
	StationDto station;
	
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
