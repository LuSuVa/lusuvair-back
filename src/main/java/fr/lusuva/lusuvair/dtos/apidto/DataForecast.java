package fr.lusuva.lusuvair.dtos.apidto;

/**
 * The DataForecast class represents the data transfer object for weather forecast data.
 * It includes information such as average, day, maximum, and minimum values.
 */
public class DataForecast {

    private int avg;
    private String day;
    private int max;
    private int min;

    /**
     * Default constructor for DataForecast.
     */
    public DataForecast() {
        super();
    }

    /**
     * Parameterized constructor for DataForecast.
     *
     * @param avg the average value
     * @param day the day of the forecast
     * @param max the maximum value
     * @param min the minimum value
     */
    public DataForecast(int avg, String day, int max, int min) {
        super();
        this.avg = avg;
        this.day = day;
        this.max = max;
        this.min = min;
    }

    /**
     * Gets the average value.
     *
     * @return the average value
     */
    public int getAvg() {
        return avg;
    }

    /**
     * Sets the average value.
     *
     * @param avg the average value to set
     */
    public void setAvg(int avg) {
        this.avg = avg;
    }

    /**
     * Gets the day of the forecast.
     *
     * @return the day of the forecast
     */
    public String getDay() {
        return day;
    }

    /**
     * Sets the day of the forecast.
     *
     * @param day the day of the forecast to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * Gets the maximum value.
     *
     * @return the maximum value
     */
    public int getMax() {
        return max;
    }

    /**
     * Sets the maximum value.
     *
     * @param max the maximum value to set
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * Gets the minimum value.
     *
     * @return the minimum value
     */
    public int getMin() {
        return min;
    }

    /**
     * Sets the minimum value.
     *
     * @param min the minimum value to set
     */
    public void setMin(int min) {
        this.min = min;
    }
}
