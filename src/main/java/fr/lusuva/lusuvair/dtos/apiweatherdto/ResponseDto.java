/**
 * DTO representing a response that includes city details, update information, and weather forecast.
 */
package fr.lusuva.lusuvair.dtos.apiweatherdto;

public class ResponseDto {
	
	private CityDto city;
	private UpdateDto update;
	private ForecastDto[] forecast;
	/**
	 * @param city
	 * @param update
	 * @param forecast
	 */
	public ResponseDto(CityDto city, UpdateDto update, ForecastDto[] forecast) {
		this.city = city;
		this.update = update;
		this.forecast = forecast;
	}
	/**
	 * 
	 */
	public ResponseDto() {
	}
	/**
	 * @return the city
	 */
	public CityDto getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(CityDto city) {
		this.city = city;
	}
	/**
	 * @return the update
	 */
	public UpdateDto getUpdate() {
		return update;
	}
	/**
	 * @param update the update to set
	 */
	public void setUpdate(UpdateDto update) {
		this.update = update;
	}
	/**
	 * @return the forecast
	 */
	public ForecastDto[] getForecast() {
		return forecast;
	}
	/**
	 * @param forecast the forecast to set
	 */
	public void setForecast(ForecastDto[] forecast) {
		this.forecast = forecast;
	}

	
}
