package fr.lusuva.lusuvair.dtos.apiweatherdto;

public class StationDto {
	private String name;

	/**
	 * @param name
	 */
	public StationDto(String name) {
		this.name = name;
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
	
	
}
