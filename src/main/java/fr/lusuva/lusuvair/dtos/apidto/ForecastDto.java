package fr.lusuva.lusuvair.dtos.apidto;

/**
 * The ForecastDto class represents the data transfer object for forecast information.
 * It includes the daily forecast data.
 */
public class ForecastDto {
    
    private DailyDto daily;

    /**
     * Default constructor for ForecastDto.
     */
    public ForecastDto() {
        super();
    }

    /**
     * Parameterized constructor for ForecastDto.
     *
     * @param daily the daily forecast data
     */
    public ForecastDto(DailyDto daily) {
        super();
        this.daily = daily;
    }

    /**
     * Gets the daily forecast data.
     *
     * @return the daily forecast data
     */
    public DailyDto getDaily() {
        return daily;
    }

    /**
     * Sets the daily forecast data.
     *
     * @param daily the daily forecast data to set
     */
    public void setDaily(DailyDto daily) {
        this.daily = daily;
    }
}
