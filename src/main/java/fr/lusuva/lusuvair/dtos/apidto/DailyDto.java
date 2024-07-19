package fr.lusuva.lusuvair.dtos.apidto;

/**
 * Daily Dto
 */
public class DailyDto {
	/**
	 * o3 particle
	 */
	private DataForecast[] o3;

	/**
	 * pm10 particle
	 */
	private DataForecast[] pm10;

	/**
	 * pm25 particle
	 */
	private DataForecast[] pm25;

	/**
	 * Get o3
	 * @return Array of DailyForecast
	 */
	public DataForecast[] getO3() {
		return o3;
	}

	/**
	 * Get pm10
	 * @return Array of DailyForecast
	 */
	public DataForecast[] getPm10() {
		return pm10;
	}

	/**
	 * Get pm25
	 * @return Array of DailyForecast
	 */
	public DataForecast[] getPm25() {
		return pm25;
	}

	/**
	 * Set o3
	 * @param o3
	 */
	public void setO3(DataForecast[] o3) {
		this.o3 = o3;
	}

	/**
	 * Set pm10
	 * @param pm10
	 */
	public void setPm10(DataForecast[] pm10) {
		this.pm10 = pm10;
	}

	/**
	 * Set pm25
	 * @param pm25
	 */
	public void setPm25(DataForecast[] pm25) {
		this.pm25 = pm25;
	}
}
