package fr.lusuva.lusuvair.dtos.apiweatherdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObservationDto {
	private String time;
	private ObservationValueDto temperature;
	private ObservationValueDto humidity;
	private ObservationValueDto barometer;

	public ObservationDto() {
	}

	public ObservationDto(String time, ObservationValueDto temperature, ObservationValueDto humidity,
			ObservationValueDto barometer) {
		this.time = time;
		this.temperature = temperature;
		this.humidity = humidity;
		this.barometer = barometer;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ObservationValueDto getTemperature() {
		return temperature;
	}

	public void setTemperature(ObservationValueDto temperature) {
		this.temperature = temperature;
	}

	public ObservationValueDto getHumidity() {
		return humidity;
	}

	public void setHumidity(ObservationValueDto humidity) {
		this.humidity = humidity;
	}

	public ObservationValueDto getBarometer() {
		return barometer;
	}

	public void setBarometer(ObservationValueDto barometer) {
		this.barometer = barometer;
	}

}
