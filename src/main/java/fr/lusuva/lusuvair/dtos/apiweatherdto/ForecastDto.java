package fr.lusuva.lusuvair.dtos.apiweatherdto;

/**
 * DTO representing weather forecasts.
 */
public class ForecastDto {

    /** Insee code of the municipality */
    private String insee;
    
    /** Zip code of the municipality */
    private int cp;
    
    /** Date in local time, ISO8601 format */
    private String datetime;
    
    /** Average wind at 10 meters in km/h */
    private int wind10m;
                
    /** Rain probability between 0 and 100% */
    private int probarain;
    
    /** Sensitive time (Time code) – See Appendices */
    private int weather;
    
    /** Wind direction at 10 meters */
    private int dirwind10m;
    
    /** Sunshine duration in hours */
    private int sun_hours;
    
    /** Probability of freezing between 0 and 100% */
    private int probafrost;
    
    /** Fog probability between 0 and 100% */
    private int probafog;

    /**
     * Constructs a new ForecastDto with the specified values.
     * 
     * @param insee the Insee code of the municipality
     * @param cp the zip code of the municipality
     * @param datetime the date and time in ISO8601 format
     * @param wind10m the average wind speed at 10 meters in km/h
     * @param probarain the probability of rain between 0 and 100%
     * @param weather the weather code
     * @param dirwind10m the wind direction at 10 meters
     * @param sun_hours the sunshine duration in hours
     * @param probafrost the probability of freezing between 0 and 100%
     * @param probafog the probability of fog between 0 and 100%
     */
    public ForecastDto(String insee, int cp, String datetime, int wind10m, int probarain, int weather, int dirwind10m,
            int sun_hours, int probafrost, int probafog) {
        this.insee = insee;
        this.cp = cp;
        this.datetime = datetime;
        this.wind10m = wind10m;
        this.probarain = probarain;
        this.weather = weather;
        this.dirwind10m = dirwind10m;
        this.sun_hours = sun_hours;
        this.probafrost = probafrost;
        this.probafog = probafog;
    }

    /**
     * Constructs a new ForecastDto with default values.
     */
    public ForecastDto() {
    }

    /**
     * Returns the Insee code of the municipality.
     * 
     * @return the insee
     */
    public String getInsee() {
        return insee;
    }

    /**
     * Sets the Insee code of the municipality.
     * 
     * @param insee the insee to set
     */
    public void setInsee(String insee) {
        this.insee = insee;
    }

    /**
     * Returns the zip code of the municipality.
     * 
     * @return the cp
     */
    public int getCp() {
        return cp;
    }

    /**
     * Sets the zip code of the municipality.
     * 
     * @param cp the cp to set
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * Returns the date and time in ISO8601 format.
     * 
     * @return the datetime
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * Sets the date and time in ISO8601 format.
     * 
     * @param datetime the datetime to set
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * Returns the average wind speed at 10 meters in km/h.
     * 
     * @return the wind10m
     */
    public int getWind10m() {
        return wind10m;
    }

    /**
     * Sets the average wind speed at 10 meters in km/h.
     * 
     * @param wind10m the wind10m to set
     */
    public void setWind10m(int wind10m) {
        this.wind10m = wind10m;
    }

    /**
     * Returns the probability of rain between 0 and 100%.
     * 
     * @return the probarain
     */
    public int getProbarain() {
        return probarain;
    }

    /**
     * Sets the probability of rain between 0 and 100%.
     * 
     * @param probarain the probarain to set
     */
    public void setProbarain(int probarain) {
        this.probarain = probarain;
    }

    /**
     * Returns the weather code.
     * 
     * @return the weather
     */
    public int getWeather() {
        return weather;
    }

    /**
     * Sets the weather code.
     * 
     * @param weather the weather to set
     */
    public void setWeather(int weather) {
        this.weather = weather;
    }

    /**
     * Returns the wind direction at 10 meters.
     * 
     * @return the dirwind10m
     */
    public int getDirwind10m() {
        return dirwind10m;
    }

    /**
     * Sets the wind direction at 10 meters.
     * 
     * @param dirwind10m the dirwind10m to set
     */
    public void setDirwind10m(int dirwind10m) {
        this.dirwind10m = dirwind10m;
    }

    /**
     * Returns the sunshine duration in hours.
     * 
     * @return the sun_hours
     */
    public int getSun_hours() {
        return sun_hours;
    }

    /**
     * Sets the sunshine duration in hours.
     * 
     * @param sun_hours the sun_hours to set
     */
    public void setSun_hours(int sun_hours) {
        this.sun_hours = sun_hours;
    }

    /**
     * Returns the probability of freezing between 0 and 100%.
     * 
     * @return the probafrost
     */
    public int getProbafrost() {
        return probafrost;
    }

    /**
     * Sets the probability of freezing between 0 and 100%.
     * 
     * @param probafrost the probafrost to set
     */
    public void setProbafrost(int probafrost) {
        this.probafrost = probafrost;
    }

    /**
     * Returns the probability of fog between 0 and 100%.
     * 
     * @return the probafog
     */
    public int getProbafog() {
        return probafog;
    }

    /**
     * Sets the probability of fog between 0 and 100%.
     * 
     * @param probafog the probafog to set
     */
    public void setProbafog(int probafog) {
        this.probafog = probafog;
    }
}
