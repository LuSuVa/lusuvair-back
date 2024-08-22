package fr.lusuva.lusuvair.dtos.apidto;

/**
 * The DataDto class represents the data transfer object for air quality data.
 * It includes information such as air quality index, city details, dominant pollutant,
 * various indices, and forecast data.
 */
public class DataDto {

    private int aqi;
    private int idx;
    private AttributionDto[] attributionDto;
    private CityDto cityDto;
    private String dominentPol;
    private IaqiDto iaqi;
    private TimeDto time;
    private ForecastDto forecast;
    private DebugDto debugDto;

    /**
     * Default constructor for DataDto.
     */
    public DataDto() {
        super();
    }

    /**
     * Parameterized constructor for DataDto.
     *
     * @param aqi            the air quality index
     * @param idx            the index
     * @param attributionDto the attribution data
     * @param cityDto        the city data
     * @param dominentPol    the dominant pollutant
     * @param iaqi           the indoor air quality index data
     * @param time           the time data
     * @param forecast       the forecast data
     * @param debugDto       the debug data
     */
    public DataDto(int aqi, int idx, AttributionDto[] attributionDto, CityDto cityDto, String dominentPol,
                   IaqiDto iaqi, TimeDto time, ForecastDto forecast, DebugDto debugDto) {
        super();
        this.aqi = aqi;
        this.idx = idx;
        this.attributionDto = attributionDto;
        this.cityDto = cityDto;
        this.dominentPol = dominentPol;
        this.iaqi = iaqi;
        this.time = time;
        this.forecast = forecast;
        this.debugDto = debugDto;
    }

    /**
     * Gets the air quality index.
     *
     * @return the air quality index
     */
    public int getAqi() {
        return aqi;
    }

    /**
     * Sets the air quality index.
     *
     * @param aqi the air quality index to set
     */
    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    /**
     * Gets the index.
     *
     * @return the index
     */
    public int getIdx() {
        return idx;
    }

    /**
     * Sets the index.
     *
     * @param idx the index to set
     */
    public void setIdx(int idx) {
        this.idx = idx;
    }

    /**
     * Gets the attribution data.
     *
     * @return the attribution data
     */
    public AttributionDto[] getAttributionDto() {
        return attributionDto;
    }

    /**
     * Sets the attribution data.
     *
     * @param attributionDto the attribution data to set
     */
    public void setAttributionDto(AttributionDto[] attributionDto) {
        this.attributionDto = attributionDto;
    }

    /**
     * Gets the city data.
     *
     * @return the city data
     */
    public CityDto getCityDto() {
        return cityDto;
    }

    /**
     * Sets the city data.
     *
     * @param cityDto the city data to set
     */
    public void setCityDto(CityDto cityDto) {
        this.cityDto = cityDto;
    }

    /**
     * Gets the dominant pollutant.
     *
     * @return the dominant pollutant
     */
    public String getDominentPol() {
        return dominentPol;
    }

    /**
     * Sets the dominant pollutant.
     *
     * @param dominentPol the dominant pollutant to set
     */
    public void setDominentPol(String dominentPol) {
        this.dominentPol = dominentPol;
    }

    /**
     * Gets the indoor air quality index data.
     *
     * @return the indoor air quality index data
     */
    public IaqiDto getIaqi() {
        return iaqi;
    }

    /**
     * Sets the indoor air quality index data.
     *
     * @param iaqi the indoor air quality index data to set
     */
    public void setIaqi(IaqiDto iaqi) {
        this.iaqi = iaqi;
    }

    /**
     * Gets the time data.
     *
     * @return the time data
     */
    public TimeDto getTime() {
        return time;
    }

    /**
     * Sets the time data.
     *
     * @param time the time data to set
     */
    public void setTime(TimeDto time) {
        this.time = time;
    }

    /**
     * Gets the forecast data.
     *
     * @return the forecast data
     */
    public ForecastDto getForecast() {
        return forecast;
    }

    /**
     * Sets the forecast data.
     *
     * @param forecast the forecast data to set
     */
    public void setForecast(ForecastDto forecast) {
        this.forecast = forecast;
    }

    /**
     * Gets the debug data.
     *
     * @return the debug data
     */
    public DebugDto getDebugDto() {
        return debugDto;
    }

    /**
     * Sets the debug data.
     *
     * @param debugDto the debug data to set
     */
    public void setDebugDto(DebugDto debugDto) {
        this.debugDto = debugDto;
    }
}
