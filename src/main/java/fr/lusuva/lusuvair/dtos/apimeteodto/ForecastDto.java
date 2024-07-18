package fr.lusuva.lusuvair.dtos.apimeteodto;

/*
 * DTO representing for weather forecasts
 */
public class ForecastDto {

	/* Insee code of the municipality*/
	private String insee;
	
	/* Zip code of the municipality*/
	private int cp;
	
	/* Decimal latitude of the municipality */
	private double latitude;
	
	/* Decimal longitude of the municipality */
	private double longitude;
	
	/* Day between 0 and 13 (For the same day: 0, for the next day: 1, etc.) */
	private int day;
	
	/* Date in local time, ISO8601 format */
	private String dateTime;
	
	/* Average wind at 10 meters in km/h */
	private int wind10m;
	
	/* Wind gusts at 10 meters in km/h */
	private int gust10m;
	
	/* Wind direction in degrees (0 to 360°) */
	private int dirwind10m;
	
	/* Total rainfall over the hourly or tri-hourly period in mm */
	private double rr10;
	
	/* Maximum cumulative rainfall over the hourly or tri-hourly period in mm */
	private double rr1;
	
	/* Rain probability between 0 and 100% */
	private int probarain;
	
	/* Sensitive time (Time code) – See Appendices */
	private int weather;
	
	/* Minimum temperature at 2 meters in °C */
	private int tmin;
	
	/* Maximum temperature at 2 meters in °C */
	private int tmax;
	
	/* Sunshine duration in hours */
	private int sun_hours;
	
	/* Cumulative evapotranspiration in mm */
	private int etp;
	
	/* Probability of freezing between 0 and 100% */
	private int probafrost;
	
	/* Fog probability between 0 and 100% */
	private int probafog;
	
	/* Wind probability >70 km/h between 0 and 100% */
	private int probawind70;
	
	/* Wind probability >100 km/h between 0 and 100% */
	private int probawind100;
	
	/* Potential wind gust under storm or squall in km/h */
	private int gustx;

	/**
	 * Constructor for ForecastDto.
	 *
	 * @param insee Insee code of the municipality
	 * @param cp Zip code of the municipality
	 * @param latitude Decimal latitude of the municipality
	 * @param longitude Decimal longitude of the municipality
	 * @param day Day between 0 and 13 (For the same day: 0, for the next day: 1, etc.)
	 * @param dateTime Date in local time, ISO8601 format
	 * @param wind10m Average wind at 10 meters in km/h
	 * @param gust10m Wind gusts at 10 meters in km/h
	 * @param dirwind10m Wind direction in degrees (0 to 360°)
	 * @param rr10 Total rainfall over the hourly or tri-hourly period in mm
	 * @param rr1 Maximum cumulative rainfall over the hourly or tri-hourly period in mm
	 * @param probarain Rain probability between 0 and 100%
	 * @param weather Sensitive time (Time code)
	 * @param tmin Minimum temperature at 2 meters in °C
	 * @param tmax Maximum temperature at 2 meters in °C
	 * @param sun_hours Sunshine duration in hours
	 * @param etp Cumulative evapotranspiration in mm
	 * @param probafrost Probability of freezing between 0 and 100%
	 * @param probafog Fog probability between 0 and 100%
	 * @param probawind70 Wind probability >70 km/h between 0 and 100%
	 * @param probawind100 Wind probability >100 km/h between 0 and 100%
	 * @param gustx Potential wind gust under storm or squall in km/h
	 */
	public ForecastDto(String insee, int cp, double latitude, double longitude, int day, String dateTime, int wind10m,
			int gust10m, int dirwind10m, double rr10, double rr1, int probarain, int weather, int tmin, int tmax,
			int sun_hours, int etp, int probafrost, int probafog, int probawind70, int probawind100, int gustx) {
		this.insee = insee;
		this.cp = cp;
		this.latitude = latitude;
		this.longitude = longitude;
		this.day = day;
		this.dateTime = dateTime;
		this.wind10m = wind10m;
		this.gust10m = gust10m;
		this.dirwind10m = dirwind10m;
		this.rr10 = rr10;
		this.rr1 = rr1;
		this.probarain = probarain;
		this.weather = weather;
		this.tmin = tmin;
		this.tmax = tmax;
		this.sun_hours = sun_hours;
		this.etp = etp;
		this.probafrost = probafrost;
		this.probafog = probafog;
		this.probawind70 = probawind70;
		this.probawind100 = probawind100;
		this.gustx = gustx;
	}

	/**
	 * Gets the Insee code of the municipality.
	 *
	 * @return the Insee code
	 */
	public String getInsee() {
		return insee;
	}

	/**
	 * Sets the Insee code of the municipality.
	 *
	 * @param insee the Insee code to set
	 */
	public void setInsee(String insee) {
		this.insee = insee;
	}

	/**
	 * Gets the zip code of the municipality.
	 *
	 * @return the zip code
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * Sets the zip code of the municipality.
	 *
	 * @param cp the zip code to set
	 */
	public void setCp(int cp) {
		this.cp = cp;
	}

	/**
	 * Gets the decimal latitude of the municipality.
	 *
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the decimal latitude of the municipality.
	 *
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the decimal longitude of the municipality.
	 *
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the decimal longitude of the municipality.
	 *
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the day between 0 and 13.
	 *
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Sets the day between 0 and 13.
	 *
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * Gets the date in local time, ISO8601 format.
	 *
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the date in local time, ISO8601 format.
	 *
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Gets the average wind at 10 meters in km/h.
	 *
	 * @return the wind10m
	 */
	public int getWind10m() {
		return wind10m;
	}

	/**
	 * Sets the average wind at 10 meters in km/h.
	 *
	 * @param wind10m the wind10m to set
	 */
	public void setWind10m(int wind10m) {
		this.wind10m = wind10m;
	}

	/**
	 * Gets the wind gusts at 10 meters in km/h.
	 *
	 * @return the gust10m
	 */
	public int getGust10m() {
		return gust10m;
	}

	/**
	 * Sets the wind gusts at 10 meters in km/h.
	 *
	 * @param gust10m the gust10m to set
	 */
	public void setGust10m(int gust10m) {
		this.gust10m = gust10m;
	}

	/**
	 * Gets the wind direction in degrees (0 to 360°).
	 *
	 * @return the dirwind10m
	 */
	public int getDirwind10m() {
		return dirwind10m;
	}

	/**
	 * Sets the wind direction in degrees (0 to 360°).
	 *
	 * @param dirwind10m the dirwind10m to set
	 */
	public void setDirwind10m(int dirwind10m) {
		this.dirwind10m = dirwind10m;
	}

	/**
	 * Gets the total rainfall over the hourly or tri-hourly period in mm.
	 *
	 * @return the rr10
	 */
	public double getRr10() {
		return rr10;
	}

	/**
	 * Sets the total rainfall over the hourly or tri-hourly period in mm.
	 *
	 * @param rr10 the rr10 to set
	 */
	public void setRr10(double rr10) {
		this.rr10 = rr10;
	}

	/**
	 * Gets the maximum cumulative rainfall over the hourly or tri-hourly period in mm.
	 *
	 * @return the rr1
	 */
	public double getRr1() {
		return rr1;
	}

	/**
	 * Sets the maximum cumulative rainfall over the hourly or tri-hourly period in mm.
	 *
	 * @param rr1 the rr1 to set
	 */
	public void setRr1(double rr1) {
		this.rr1 = rr1;
	}

	/**
	 * Gets the rain probability between 0 and 100%.
	 *
	 * @return the probarain
	 */
	public int getProbarain() {
		return probarain;
	}

	/**
	 * Sets the rain probability between 0 and 100%.
	 *
	 * @param probarain the probarain to set
	 */
	public void setProbarain(int probarain) {
		this.probarain = probarain;
	}

	/**
	 * Gets the sensitive time (Time code).
	 *
	 * @return the weather
	 */
	public int getWeather() {
		return weather;
	}

	/**
	 * Sets the sensitive time (Time code).
	 *
	 * @param weather the weather to set
	 */
	public void setWeather(int weather) {
		this.weather = weather;
	}

	/**
	 * Gets the minimum temperature at 2 meters in °C.
	 *
	 * @return the tmin
	 */
	public int getTmin() {
		return tmin;
	}

	/**
	 * Sets the minimum temperature at 2 meters in °C.
	 *
	 * @param tmin the tmin to set
	 */
	public void setTmin(int tmin) {
		this.tmin = tmin;
	}

	/**
	 * Gets the maximum temperature at 2 meters in °C.
	 *
	 * @return the tmax
	 */
	public int getTmax() {
		return tmax;
	}

	/**
	 * Sets the maximum temperature at 2 meters in °C.
	 *
	 * @param tmax the tmax to set
	 */
	public void setTmax(int tmax) {
		this.tmax = tmax;
	}

	/**
	 * Gets the sunshine duration in hours.
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
	 * Gets the cumulative evapotranspiration in mm.
	 *
	 * @return the etp
	 */
	public int getEtp() {
		return etp;
	}

	/**
	 * Sets the cumulative evapotranspiration in mm.
	 *
	 * @param etp the etp to set
	 */
	public void setEtp(int etp) {
		this.etp = etp;
	}

	/**
	 * Gets the probability of freezing between 0 and 100%.
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
	 * Gets the fog probability between 0 and 100%.
	 *
	 * @return the probafog
	 */
	public int getProbafog() {
		return probafog;
	}

	/**
	 * Sets the fog probability between 0 and 100%.
	 *
	 * @param probafog the probafog to set
	 */
	public void setProbafog(int probafog) {
		this.probafog = probafog;
	}

	/**
	 * Gets the wind probability >70 km/h between 0 and 100%.
	 *
	 * @return the probawind70
	 */
	public int getProbawind70() {
		return probawind70;
	}

	/**
	 * Sets the wind probability >70 km/h between 0 and 100%.
	 *
	 * @param probawind70 the probawind70 to set
	 */
	public void setProbawind70(int probawind70) {
		this.probawind70 = probawind70;
	}

	/**
	 * Gets the wind probability >100 km/h between 0 and 100%.
	 *
	 * @return the probawind100
	 */
	public int getProbawind100() {
		return probawind100;
	}

	/**
	 * Sets the wind probability >100 km/h between 0 and 100%.
	 *
	 * @param probawind100 the probawind100 to set
	 */
	public void setProbawind100(int probawind100) {
		this.probawind100 = probawind100;
	}

	/**
	 * Gets the potential wind gust under storm or squall in km/h.
	 *
	 * @return the gustx
	 */
	public int getGustx() {
		return gustx;
	}

	/**
	 * Sets the potential wind gust under storm or squall in km/h.
	 *
	 * @param gustx the gustx to set
	 */
	public void setGustx(int gustx) {
		this.gustx = gustx;
	}
}
