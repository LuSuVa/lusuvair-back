package fr.lusuva.lusuvair.dtos.apidto;

/**
 * DTO class representing a city.
 * It contains geographical coordinates, name, URL, and location information.
 */
public class CityDto {
	
	/** 
	 * The geographical coordinates of the city.
	 */
	private double[] geo;
	
	/** 
	 * The name of the city.
	 */
	private String name;
	
	/** 
	 * The URL associated with the air quality of the city.
	 */
	private String url;
	
	/** 
	 * The location description of the city.
	 */
	private String location;
	
	/**
	 * Default constructor.
	 */
	public CityDto() {
		super();
	}
	
	/**
	 * Parameterized constructor to initialize the fields.
	 *
	 * @param geo the geographical coordinates of the city
	 * @param name the name of the city
	 * @param url the URL associated with the city
	 * @param location the location description of the city
	 */
	public CityDto(double[] geo, String name, String url, String location) {
		super();
		this.geo = geo;
		this.name = name;
		this.url = url;
		this.location = location;
	}
	
	/**
	 * Gets the geographical coordinates of the city.
	 *
	 * @return the geographical coordinates
	 */
	public double[] getGeo() {
		return geo;
	}
	
	/**
	 * Sets the geographical coordinates of the city.
	 *
	 * @param geo the geographical coordinates to set
	 */
	public void setGeo(double[] geo) {
		this.geo = geo;
	}
	
	/**
	 * Gets the name of the city.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the city.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the URL associated with the city.
	 *
	 * @return the URL
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the URL associated with the city.
	 *
	 * @param url the URL to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Gets the location description of the city.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the location description of the city.
	 *
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
