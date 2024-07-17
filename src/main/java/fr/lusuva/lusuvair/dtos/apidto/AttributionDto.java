package fr.lusuva.lusuvair.dtos.apidto;

public class AttributionDto {
	private String url;
	private String name;
	private String logo;
	
	/**
	 * 
	 */
	public AttributionDto() {
		super();
	}
	/**
	 * @param url
	 * @param name
	 * @param logo
	 */
	public AttributionDto(String url, String name, String logo) {
		super();
		this.url = url;
		this.name = name;
		this.logo = logo;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
}
