package fr.lusuva.lusuvair.dtos.apiweatherdto;

/**
 * DTO representing an update for weather forecasts.
 */
public class UpdateDto {

    /** String giving the time and date of the forecast */
    private String dateTime;

    /**
     * Constructs a new UpdateDto with the specified date and time of the forecast.
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
