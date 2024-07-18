package fr.lusuva.lusuvair.dtos.apidto;

public class ParticlesDto {
	private ForecastPerParticles[] forecastPerParticles;

	/**
	 * 
	 */
	public ParticlesDto() {
		super();
	}

	/**
	 * @param forecastPerParticles
	 */
	public ParticlesDto(ForecastPerParticles[] forecastPerParticles) {
		super();
		this.forecastPerParticles = forecastPerParticles;
	}

	/**
	 * @return the forecastPerParticles
	 */
	public ForecastPerParticles[] getForecastPerParticles() {
		return forecastPerParticles;
	}

	/**
	 * @param forecastPerParticles the forecastPerParticles to set
	 */
	public void setForecastPerParticles(ForecastPerParticles[] forecastPerParticles) {
		this.forecastPerParticles = forecastPerParticles;
	}

}
