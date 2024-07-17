/**
 * DTO representing an update for weather forecasts.
 */
package fr.lusuva.lusuvair.dtos.apimeteodto;

public class UpdateDto {

	/* String giving the time and date of the forecast */
	private String dateTime;

	/**
	 * Constructor for UpdateDto.
	 *
	 * @param dateTime String giving the time and date of the forecast
	 */
	public UpdateDto(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Gets the time and date of the forecast.
	 *
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the time and date of the forecast.
	 *
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
