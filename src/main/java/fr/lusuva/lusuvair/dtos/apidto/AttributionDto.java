package fr.lusuva.lusuvair.dtos.apidto;

/**
 * DTO class representing an attribution.
 * It contains information about a URL, name, and logo.
 */
public class AttributionDto {
	
	/** 
	 * The URL of the attribution.
	 */
	private String url;
	
	/** 
	 * The name of the attribution.
	 */
	private String name;
	
	/** 
	 * The logo of the attribution.
	 */
	private String logo;
	
	/**
	 * Default constructor.
	 */
	public AttributionDto() {
		super();
	}
	
	/**
	 * Parameterized constructor to initialize the fields.
	 *
	 * @param url the URL of the attribution
	 * @param name the name of the attribution
	 * @param logo the logo of the attribution
	 */
	public AttributionDto(String url, String name, String logo) {
		super();
		this.url = url;
		this.name = name;
		this.logo = logo;
	}
	
	/**
	 * Gets the URL of the attribution.
	 *
	 * @return the URL
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the URL of the attribution.
	 *
	 * @param url the URL to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Gets the name of the attribution.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the attribution.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the logo of the attribution.
	 *
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}
	
	/**
	 * Sets the logo of the attribution.
	 *
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
}
