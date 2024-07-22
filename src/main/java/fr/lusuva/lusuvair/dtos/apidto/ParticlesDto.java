package fr.lusuva.lusuvair.dtos.apidto;

/**
 * Represents the particles forecast data.
 */
public class ParticlesDto {

    /**
     * An array of {@link ForecastPerParticles} objects, each containing forecast data for different types of particles.
     */
    private ForecastPerParticles[] forecastPerParticles;

    /**
     * Default constructor for ParticlesDto.
     */
    public ParticlesDto() {
        super();
    }

    /**
     * Parameterized constructor for ParticlesDto.
     *
     * @param forecastPerParticles an array of {@link ForecastPerParticles} objects to initialize this DTO
     */
    public ParticlesDto(ForecastPerParticles[] forecastPerParticles) {
        super();
        this.forecastPerParticles = forecastPerParticles;
    }

    /**
     * Gets the array of {@link ForecastPerParticles} objects.
     *
     * @return the array of {@link ForecastPerParticles} objects
     */
    public ForecastPerParticles[] getForecastPerParticles() {
        return forecastPerParticles;
    }

    /**
     * Sets the array of {@link ForecastPerParticles} objects.
     *
     * @param forecastPerParticles the array of {@link ForecastPerParticles} objects to set
     */
    public void setForecastPerParticles(ForecastPerParticles[] forecastPerParticles) {
        this.forecastPerParticles = forecastPerParticles;
    }
}
