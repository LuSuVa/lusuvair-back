package fr.lusuva.lusuvair.dtos.apidto;

public class ForecastPerParticles {
	private String name;
	private DataForecast[] dataForecast;

	/**
	 * 
	 */
	public ForecastPerParticles() {
		super();
	}

	/**
	 * @param name
	 * @param dataForecast
	 */
	public ForecastPerParticles(String name, DataForecast[] dataForecast) {
		super();
		this.name = name;
		this.dataForecast = dataForecast;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the dataForecast
	 */
	public DataForecast[] getDataForecast() {
		return dataForecast;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param dataForecast the dataForecast to set
	 */
	public void setDataForecast(DataForecast[] dataForecast) {
		this.dataForecast = dataForecast;
	}

}
