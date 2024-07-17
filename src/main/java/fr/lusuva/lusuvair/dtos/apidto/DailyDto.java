package fr.lusuva.lusuvair.dtos.apidto;

public class DailyDto {
	private O3Dto[] o3;

	/**
	 * 
	 */
	public DailyDto() {
		super();
	}

	/**
	 * @param o3
	 */
	public DailyDto(O3Dto[] o3) {
		super();
		this.o3 = o3;
	}

	/**
	 * @return the o3
	 */
	public O3Dto[] getO3() {
		return o3;
	}

	/**
	 * @param o3 the o3 to set
	 */
	public void setO3(O3Dto[] o3) {
		this.o3 = o3;
	}
}
