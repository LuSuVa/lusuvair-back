package fr.lusuva.lusuvair.dtos.apidto;

public class TimeDto {
	private String s;
	private String tz;
	private int v;
	private String iso;

	/**
	 * 
	 */
	public TimeDto() {
		super();
	}

	/**
	 * @param s
	 * @param tz
	 * @param v
	 * @param iso
	 */
	public TimeDto(String s, String tz, int v, String iso) {
		super();
		this.s = s;
		this.tz = tz;
		this.v = v;
		this.iso = iso;
	}

	/**
	 * @return the s
	 */
	public String getS() {
		return s;
	}

	/**
	 * @return the tz
	 */
	public String getTz() {
		return tz;
	}

	/**
	 * @return the v
	 */
	public int getV() {
		return v;
	}

	/**
	 * @return the iso
	 */
	public String getIso() {
		return iso;
	}

	/**
	 * @param s the s to set
	 */
	public void setS(String s) {
		this.s = s;
	}

	/**
	 * @param tz the tz to set
	 */
	public void setTz(String tz) {
		this.tz = tz;
	}

	/**
	 * @param v the v to set
	 */
	public void setV(int v) {
		this.v = v;
	}

	/**
	 * @param iso the iso to set
	 */
	public void setIso(String iso) {
		this.iso = iso;
	}
}
