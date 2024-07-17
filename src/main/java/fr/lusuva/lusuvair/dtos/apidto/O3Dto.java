package fr.lusuva.lusuvair.dtos.apidto;

public class O3Dto {
	private ForecastPerParticles[] forecastPerParticles;

	/**
	 * 
	 */
	public O3Dto() {
		super();
	}

	/**
	 * @param forecastPerParticles
	 */
	public O3Dto(ForecastPerParticles[] forecastPerParticles) {
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
