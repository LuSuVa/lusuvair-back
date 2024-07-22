package fr.lusuva.lusuvair.dtos.apidto;

/**
 * The ForecastPerParticles class represents the forecast data for specific particles.
 * It includes the name of the particle and an array of DataForecast objects.
 */
public class ForecastPerParticles {
    
    private String name;
    private DataForecast[] dataForecast;

    /**
     * Default constructor for ForecastPerParticles.
     */
    public ForecastPerParticles() {
        super();
    }

    /**
     * Parameterized constructor for ForecastPerParticles.
     *
     * @param name the name of the particle
     * @param dataForecast an array of DataForecast objects representing the forecast data
     */
    public ForecastPerParticles(String name, DataForecast[] dataForecast) {
        super();
        this.name = name;
        this.dataForecast = dataForecast;
    }

    /**
     * Gets the name of the particle.
     *
     * @return the name of the particle
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the particle.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the array of DataForecast objects.
     *
     * @return the array of DataForecast objects
     */
    public DataForecast[] getDataForecast() {
        return dataForecast;
    }

    /**
     * Sets the array of DataForecast objects.
     *
     * @param dataForecast the array of DataForecast objects to set
     */
    public void setDataForecast(DataForecast[] dataForecast) {
        this.dataForecast = dataForecast;
    }
}
