/**
 * DTO representing a response that includes city details, update information, and weather forecast.
 */
package fr.lusuva.lusuvair.dtos.apiweatherdto;

public class ResponseDto {
	
	private CityDto cityDto;
	private UpdateDto updateDto;
	private ForecastDto forecastDto;

	/**
	 * Constructor for ResponseDto.
	 *
	 * @param cityDto     DTO representing the city details
	 * @param updateDto   DTO representing the update information
	 * @param forecastDto DTO representing the weather forecast
	 */
	public ResponseDto(CityDto cityDto, UpdateDto updateDto, ForecastDto forecastDto) {
		this.cityDto = cityDto;
		this.updateDto = updateDto;
		this.forecastDto = forecastDto;
	}

	/**
	 * Gets the city details.
	 *
	 * @return the cityDto
	 */
	public CityDto getCityDto() {
		return cityDto;
	}

	/**
	 * Sets the city details.
	 *
	 * @param cityDto the cityDto to set
	 */
	public void setCityDto(CityDto cityDto) {
		this.cityDto = cityDto;
	}

	/**
	 * Gets the update information.
	 *
	 * @return the updateDto
	 */
	public UpdateDto getUpdateDto() {
		return updateDto;
	}

	/**
	 * Sets the update information.
	 *
	 * @param updateDto the updateDto to set
	 */
	public void setUpdateDto(UpdateDto updateDto) {
		this.updateDto = updateDto;
	}

	/**
	 * Gets the weather forecast.
	 *
	 * @return the forecastDto
	 */
	public ForecastDto getForecastDto() {
		return forecastDto;
	}

	/**
	 * Sets the weather forecast.
	 *
	 * @param forecastDto the forecastDto to set
	 */
	public void setForecastDto(ForecastDto forecastDto) {
		this.forecastDto = forecastDto;
	}
}
