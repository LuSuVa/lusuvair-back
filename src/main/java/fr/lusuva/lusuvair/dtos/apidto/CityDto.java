package fr.lusuva.lusuvair.dtos.apidto;

public class CityDto {
	private double[] geo;
	private String name;
	private String url;
	private String location;
	
	/**
	 * 
	 */
	public CityDto() {
		super();
	}
	/**
	 * @param geo
	 * @param name
	 * @param url
	 * @param location
	 */
	public CityDto(double[] geo, String name, String url, String location) {
		super();
		this.geo = geo;
		this.name = name;
		this.url = url;
		this.location = location;
	}
	/**
	 * @return the geo
	 */
	public double[] getGeo() {
		return geo;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param geo the geo to set
	 */
	public void setGeo(double[] geo) {
		this.geo = geo;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
}
