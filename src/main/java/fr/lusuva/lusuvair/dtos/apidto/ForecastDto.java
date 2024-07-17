package fr.lusuva.lusuvair.dtos.apidto;

public class ForecastDto {
	private DailyDto daily;

	/**
	 * 
	 */
	public ForecastDto() {
		super();
	}

	/**
	 * @param daily
	 */
	public ForecastDto(DailyDto daily) {
		super();
		this.daily = daily;
	}

	/**
	 * @return the daily
	 */
	public DailyDto getDaily() {
		return daily;
	}

	/**
	 * @param daily the daily to set
	 */
	public void setDaily(DailyDto daily) {
		this.daily = daily;
	}
}
