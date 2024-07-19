package fr.lusuva.lusuvair.dtos.apidto;

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
	
	public DataDto() {
		super();
	}
	/**
	 * @param aqi
	 * @param idx
	 * @param attributionDto
	 * @param cityDto
	 * @param dominentPol
	 * @param iaqui
	 * @param time
	 * @param forecast
	 * @param debugDto
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
	 * @return the aqi
	 */
	public int getAqi() {
		return aqi;
	}
	/**
	 * @return the idx
	 */
	public int getIdx() {
		return idx;
	}
	/**
	 * @return the attributionDto
	 */
	public AttributionDto[] getAttributionDto() {
		return attributionDto;
	}
	/**
	 * @return the cityDto
	 */
	public CityDto getCityDto() {
		return cityDto;
	}
	/**
	 * @return the dominentPol
	 */
	public String getDominentPol() {
		return dominentPol;
	}
	/**
	 * @return the iaqui
	 */
	public IaqiDto getIaqi() {
		return iaqi;
	}
	/**
	 * @return the time
	 */
	public TimeDto getTime() {
		return time;
	}
	/**
	 * @return the forecast
	 */
	public ForecastDto getForecast() {
		return forecast;
	}
	/**
	 * @return the debugDto
	 */
	public DebugDto getDebugDto() {
		return debugDto;
	}
	/**
	 * @param aqi the aqi to set
	 */
	public void setAqi(int aqi) {
		this.aqi = aqi;
	}
	/**
	 * @param idx the idx to set
	 */
	public void setIdx(int idx) {
		this.idx = idx;
	}
	/**
	 * @param attributionDto the attributionDto to set
	 */
	public void setAttributionDto(AttributionDto[] attributionDto) {
		this.attributionDto = attributionDto;
	}
	/**
	 * @param cityDto the cityDto to set
	 */
	public void setCityDto(CityDto cityDto) {
		this.cityDto = cityDto;
	}
	/**
	 * @param dominentPol the dominentPol to set
	 */
	public void setDominentPol(String dominentPol) {
		this.dominentPol = dominentPol;
	}
	/**
	 * @param iaqi the iaqui to set
	 */
	public void setIaqi(IaqiDto iaqi) {
		this.iaqi = iaqi;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(TimeDto time) {
		this.time = time;
	}
	/**
	 * @param forecast the forecast to set
	 */
	public void setForecast(ForecastDto forecast) {
		this.forecast = forecast;
	}
	/**
	 * @param debugDto the debugDto to set
	 */
	public void setDebugDto(DebugDto debugDto) {
		this.debugDto = debugDto;
	}
}
