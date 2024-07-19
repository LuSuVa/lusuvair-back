package fr.lusuva.lusuvair.dtos.apiweatherdto;

public class ObservationDto {
	private String time;
	private TemperatureDto temperatureDto;
	private HumidityDto humidityDto;
	private BarometerDto barometerDto;
	
	/**
	 * @param time
	 * @param globalRadiationDto
	 * @param temperatureDto
	 * @param humidityDto
	 * @param barometerDto
	 */
	public ObservationDto(String time,TemperatureDto temperatureDto,
			HumidityDto humidityDto, BarometerDto barometerDto) {
		this.time = time;
		this.temperatureDto = temperatureDto;
		this.humidityDto = humidityDto;
		this.barometerDto = barometerDto;
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
	 * @return the temperatureDto
	 */
	public TemperatureDto getTemperatureDto() {
		return temperatureDto;
	}

	/**
	 * @param temperatureDto the temperatureDto to set
	 */
	public void setTemperatureDto(TemperatureDto temperatureDto) {
		this.temperatureDto = temperatureDto;
	}

	/**
	 * @return the humidityDto
	 */
	public HumidityDto getHumidityDto() {
		return humidityDto;
	}

	/**
	 * @param humidityDto the humidityDto to set
	 */
	public void setHumidityDto(HumidityDto humidityDto) {
		this.humidityDto = humidityDto;
	}

	/**
	 * @return the barometerDto
	 */
	public BarometerDto getBarometerDto() {
		return barometerDto;
	}

	/**
	 * @param barometerDto the barometerDto to set
	 */
	public void setBarometerDto(BarometerDto barometerDto) {
		this.barometerDto = barometerDto;
	}
	
	
}
