package fr.lusuva.lusuvair.dtos.apiweatherdto;

public class StationDto {
	private String name;
	
	private String city;


	/**
	 * 
	 */
	public StationDto() {
	}



	/**
	 * @param name
	 * @param city
	 */
	public StationDto(String name, String city) {
		this.name = name;
		this.city = city;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
