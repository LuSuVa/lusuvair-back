package fr.lusuva.lusuvair.dtos.apiweatherdto;

public class HumidityDto {

	private String value;
	private String unit;
	/**
	 * @param value
	 * @param unit
	 */
	public HumidityDto(String value, String unit) {
		this.value = value;
		this.unit = unit;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
