package fr.lusuva.lusuvair.dtos.apiweatherdto;

/*
 * DTO representing for weather forecasts
 */
public class ForecastDto {

	/* Insee code of the municipality*/
	private String insee;
	
	/* Zip code of the municipality*/
	private int cp;
	
	/* Date in local time, ISO8601 format */
	private String datetime;
	
	/* Average wind at 10 meters in km/h */
	private int wind10m;
				
	/* Rain probability between 0 and 100% */
	private int probarain;
	
	/* Sensitive time (Time code) – See Appendices */
	private int weather;
	
	private int dirwind10m;
	
	/* Sunshine duration in hours */
	private int sun_hours;
	
	/* Probability of freezing between 0 and 100% */
	private int probafrost;
	
	/* Fog probability between 0 and 100% */
	private int probafog;



	/**
	 * @param insee
	 * @param cp
	 * @param datetime
	 * @param wind10m
	 * @param probarain
	 * @param weather
	 * @param dirwind10m
	 * @param sun_hours
	 * @param probafrost
	 * @param probafog
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
	 * 
	 */
	public ForecastDto() {
	}

	/**
	 * @return the insee
	 */
	public String getInsee() {
		return insee;
	}

	/**
	 * @param insee the insee to set
	 */
	public void setInsee(String insee) {
		this.insee = insee;
	}

	/**
	 * @return the cp
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}

	/**
	 * @return the datetime
	 */
	public String getDatetime() {
		return datetime;
	}

	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	/**
	 * @return the wind10m
	 */
	public int getWind10m() {
		return wind10m;
	}

	/**
	 * @param wind10m the wind10m to set
	 */
	public void setWind10m(int wind10m) {
		this.wind10m = wind10m;
	}

	/**
	 * @return the probarain
	 */
	public int getProbarain() {
		return probarain;
	}

	/**
	 * @param probarain the probarain to set
	 */
	public void setProbarain(int probarain) {
		this.probarain = probarain;
	}

	/**
	 * @return the weather
	 */
	public int getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(int weather) {
		this.weather = weather;
	}

	/**
	 * @return the sun_hours
	 */
	public int getSun_hours() {
		return sun_hours;
	}

	/**
	 * @param sun_hours the sun_hours to set
	 */
	public void setSun_hours(int sun_hours) {
		this.sun_hours = sun_hours;
	}

	/**
	 * @return the probafrost
	 */
	public int getProbafrost() {
		return probafrost;
	}

	/**
	 * @param probafrost the probafrost to set
	 */
	public void setProbafrost(int probafrost) {
		this.probafrost = probafrost;
	}

	/**
	 * @return the probafog
	 */
	public int getProbafog() {
		return probafog;
	}

	/**
	 * @param probafog the probafog to set
	 */
	public void setProbafog(int probafog) {
		this.probafog = probafog;
	}

	/**
	 * @return the dirwind10m
	 */
	public int getDirwind10m() {
		return dirwind10m;
	}

	/**
	 * @param dirwind10m the dirwind10m to set
	 */
	public void setDirwind10m(int dirwind10m) {
		this.dirwind10m = dirwind10m;
	}
	
	


}
