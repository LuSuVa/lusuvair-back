package fr.lusuva.lusuvair.dtos.apidto;

public class IaqiDto {
	private ParticleDto co;
	private ParticleDto h;
	private ParticleDto no2;
	private ParticleDto o3;
	private ParticleDto p;
	private ParticleDto pm10;
	private ParticleDto pm25;
	private ParticleDto so2;
	private ParticleDto t;
	private ParticleDto w;
	private ParticleDto wg;
	
	/**
	 * 
	 */
	public IaqiDto() {
		super();
	}
	/**
	 * @param co
	 * @param h
	 * @param no2
	 * @param o3
	 * @param p
	 * @param pm10
	 * @param pm25
	 * @param so2
	 * @param t
	 * @param w
	 * @param wg
	 */
	public IaqiDto(ParticleDto co, ParticleDto h, ParticleDto no2, ParticleDto o3, ParticleDto p, ParticleDto pm10,
			ParticleDto pm25, ParticleDto so2, ParticleDto t, ParticleDto w, ParticleDto wg) {
		super();
		this.co = co;
		this.h = h;
		this.no2 = no2;
		this.o3 = o3;
		this.p = p;
		this.pm10 = pm10;
		this.pm25 = pm25;
		this.so2 = so2;
		this.t = t;
		this.w = w;
		this.wg = wg;
	}
	/**
	 * @return the co
	 */
	public ParticleDto getCo() {
		return co;
	}
	/**
	 * @return the h
	 */
	public ParticleDto getH() {
		return h;
	}
	/**
	 * @return the no2
	 */
	public ParticleDto getNo2() {
		return no2;
	}
	/**
	 * @return the o3
	 */
	public ParticleDto getO3() {
		return o3;
	}
	/**
	 * @return the p
	 */
	public ParticleDto getP() {
		return p;
	}
	/**
	 * @return the pm10
	 */
	public ParticleDto getPm10() {
		return pm10;
	}
	/**
	 * @return the pm25
	 */
	public ParticleDto getPm25() {
		return pm25;
	}
	/**
	 * @return the so2
	 */
	public ParticleDto getSo2() {
		return so2;
	}
	/**
	 * @return the t
	 */
	public ParticleDto getT() {
		return t;
	}
	/**
	 * @return the w
	 */
	public ParticleDto getW() {
		return w;
	}
	/**
	 * @return the wg
	 */
	public ParticleDto getWg() {
		return wg;
	}
	/**
	 * @param co the co to set
	 */
	public void setCo(ParticleDto co) {
		this.co = co;
	}
	/**
	 * @param h the h to set
	 */
	public void setH(ParticleDto h) {
		this.h = h;
	}
	/**
	 * @param no2 the no2 to set
	 */
	public void setNo2(ParticleDto no2) {
		this.no2 = no2;
	}
	/**
	 * @param o3 the o3 to set
	 */
	public void setO3(ParticleDto o3) {
		this.o3 = o3;
	}
	/**
	 * @param p the p to set
	 */
	public void setP(ParticleDto p) {
		this.p = p;
	}
	/**
	 * @param pm10 the pm10 to set
	 */
	public void setPm10(ParticleDto pm10) {
		this.pm10 = pm10;
	}
	/**
	 * @param pm25 the pm25 to set
	 */
	public void setPm25(ParticleDto pm25) {
		this.pm25 = pm25;
	}
	/**
	 * @param so2 the so2 to set
	 */
	public void setSo2(ParticleDto so2) {
		this.so2 = so2;
	}
	/**
	 * @param t the t to set
	 */
	public void setT(ParticleDto t) {
		this.t = t;
	}
	/**
	 * @param w the w to set
	 */
	public void setW(ParticleDto w) {
		this.w = w;
	}
	/**
	 * @param wg the wg to set
	 */
	public void setWg(ParticleDto wg) {
		this.wg = wg;
	}
	
}
