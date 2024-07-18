package fr.lusuva.lusuvair.dtos.apidto;

import java.util.Arrays;

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

    // Constructeur sans arguments
    public DataDto() {
        super();
    }

    // Constructeur avec arguments
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

    // Getters et Setters
    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public AttributionDto[] getAttributionDto() {
        return attributionDto;
    }

    public void setAttributionDto(AttributionDto[] attributionDto) {
        this.attributionDto = attributionDto;
    }

    public CityDto getCityDto() {
        return cityDto;
    }

    public void setCityDto(CityDto cityDto) {
        this.cityDto = cityDto;
    }

    public String getDominentPol() {
        return dominentPol;
    }

    public void setDominentPol(String dominentPol) {
        this.dominentPol = dominentPol;
    }

    public IaqiDto getIaqi() {
        return iaqi;
    }

    public void setIaqi(IaqiDto iaqi) {
        this.iaqi = iaqi;
    }

    public TimeDto getTime() {
        return time;
    }

    public void setTime(TimeDto time) {
        this.time = time;
    }

    public ForecastDto getForecast() {
        return forecast;
    }

    public void setForecast(ForecastDto forecast) {
        this.forecast = forecast;
    }

    public DebugDto getDebugDto() {
        return debugDto;
    }

    public void setDebugDto(DebugDto debugDto) {
        this.debugDto = debugDto;
    }

    @Override
    public String toString() {
        return "DataDto {aqi=" + aqi + ", idx=" + idx + "}";
    }
}
