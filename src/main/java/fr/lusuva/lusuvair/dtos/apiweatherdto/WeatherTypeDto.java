package fr.lusuva.lusuvair.dtos.apiweatherdto;

public class WeatherTypeDto {
	StationDto stationDto;
	ObservationDto observationDto;
	/**
	 * @param stationDto
	 * @param observationDto
	 */
	public WeatherTypeDto(StationDto stationDto, ObservationDto observationDto) {
		this.stationDto = stationDto;
		this.observationDto = observationDto;
	}
	/**
	 * @return the stationDto
	 */
	public StationDto getStationDto() {
		return stationDto;
	}
	/**
	 * @param stationDto the stationDto to set
	 */
	public void setStationDto(StationDto stationDto) {
		this.stationDto = stationDto;
	}
	/**
	 * @return the observationDto
	 */
	public ObservationDto getObservationDto() {
		return observationDto;
	}
	/**
	 * @param observationDto the observationDto to set
	 */
	public void setObservationDto(ObservationDto observationDto) {
		this.observationDto = observationDto;
	}
	
	
}
