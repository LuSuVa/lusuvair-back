/**
 * DTO representing a city with its geographical and administrative details.
 */
package fr.lusuva.lusuvair.dtos.apiweatherdto;

public class CityDto {

	/* Insee code of the municipality */
	private String insee;	
	
	/* Zip code of the municipality */
	private int cp;	
	
	/* Name of the municipality */
	private String name;	
	
	/* Latitude of the municipality */
	private double latitude;	
	
	/* Longitude of the municipality */
	private double longitude;	
	
	/* Altitude of the municipality */
	private double altitude;

	/**
	 * Constructor for CityDto.
	 *
	 * @param insee     Insee code of the municipality
	 * @param cp        Zip code of the municipality
	 * @param name      Name of the municipality
	 * @param latitude  Latitude of the municipality
	 * @param longitude Longitude of the municipality
	 * @param altitude  Altitude of the municipality
	 */
	public CityDto(String insee, int cp, String name, double latitude, double longitude, double altitude) {
		this.insee = insee;
		this.cp = cp;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}

	/**
	 * Gets the Insee code of the municipality.
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
	 * Gets the zip code of the municipality.
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
	 * Gets the name of the municipality.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the municipality.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the latitude of the municipality.
	 *
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude of the municipality.
	 *
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the longitude of the municipality.
	 *
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude of the municipality.
	 *
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the altitude of the municipality.
	 *
	 * @return the altitude
	 */
	public double getAltitude() {
		return altitude;
	}

	/**
	 * Sets the altitude of the municipality.
	 *
	 * @param altitude the altitude to set
	 */
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
}
