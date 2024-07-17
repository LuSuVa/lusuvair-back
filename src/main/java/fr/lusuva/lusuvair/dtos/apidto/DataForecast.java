package fr.lusuva.lusuvair.dtos.apidto;


public class DataForecast {
	private int avg;
	private String day;
	private int max;
	private int min;

	/**
	 * 
	 */
	public DataForecast() {
		super();
	}

	/**
	 * @param avg
	 * @param day
	 * @param max
	 * @param min
	 */
	public DataForecast(int avg, String day, int max, int min) {
		super();
		this.avg = avg;
		this.day = day;
		this.max = max;
		this.min = min;
	}

	/**
	 * @return the avg
	 */
	public int getAvg() {
		return avg;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @return the min
	 */
	public int getMin() {
		return min;
	}

	/**
	 * @param avg the avg to set
	 */
	public void setAvg(int avg) {
		this.avg = avg;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		this.min = min;
	}
}
