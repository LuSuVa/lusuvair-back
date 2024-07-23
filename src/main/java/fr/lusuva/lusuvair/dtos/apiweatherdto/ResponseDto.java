package fr.lusuva.lusuvair.dtos.apiweatherdto;

/**
 * DTO representing a response that includes city details, update information, and weather forecast.
 */
public class ResponseDto {

    /** The city details */
    private CityDto city;

    /** The update information */
    private UpdateDto update;

    /** The weather forecast */
    private ForecastDto[] forecast;

    /**
     * Constructs a new ResponseDto with the specified city details, update information, and weather forecast.
     * 
     * @param city the city details
     * @param update the update information
     * @param forecast the weather forecast
     */
    public ResponseDto(CityDto city, UpdateDto update, ForecastDto[] forecast) {
        this.city = city;
        this.update = update;
        this.forecast = forecast;
    }

    /**
     * Constructs a new ResponseDto with default values.
     */
    public ResponseDto() {
    }

    /**
     * Returns the city details.
     * 
     * @return the city
     */
    public CityDto getCity() {
        return city;
    }

    /**
     * Sets the city details.
     * 
     * @param city the city to set
     */
    public void setCity(CityDto city) {
        this.city = city;
    }

    /**
     * Returns the update information.
     * 
     * @return the update
     */
    public UpdateDto getUpdate() {
        return update;
    }

    /**
     * Sets the update information.
     * 
     * @param update the update to set
     */
    public void setUpdate(UpdateDto update) {
        this.update = update;
    }

    /**
     * Returns the weather forecast.
     * 
     * @return the forecast
     */
    public ForecastDto[] getForecast() {
        return forecast;
    }

    /**
     * Sets the weather forecast.
     * 
     * @param forecast the forecast to set
     */
    public void setForecast(ForecastDto[] forecast) {
        this.forecast = forecast;
    }
}
