package fr.lusuva.lusuvair.dtos.apiweatherdto;

public class ObservationDto {
	private String time;
	private TemperatureDto temperature;
	private HumidityDto humidity;
	private BarometerDto barometer;
	/**
	 * @param time
	 * @param temperature
	 * @param humidity
	 * @param barometer
	 */
	public ObservationDto(String time, TemperatureDto temperature, HumidityDto humidity, BarometerDto barometer) {
		this.time = time;
		this.temperature = temperature;
		this.humidity = humidity;
		this.barometer = barometer;
	}
	/**
	 * 
	 */
	public ObservationDto() {
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the temperature
	 */
	public TemperatureDto getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(TemperatureDto temperature) {
		this.temperature = temperature;
	}
	/**
	 * @return the humidity
	 */
	public HumidityDto getHumidity() {
		return humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(HumidityDto humidity) {
		this.humidity = humidity;
	}
	/**
	 * @return the barometer
	 */
	public BarometerDto getBarometer() {
		return barometer;
	}
	/**
	 * @param barometer the barometer to set
	 */
	public void setBarometer(BarometerDto barometer) {
		this.barometer = barometer;
	}
	

	
}
