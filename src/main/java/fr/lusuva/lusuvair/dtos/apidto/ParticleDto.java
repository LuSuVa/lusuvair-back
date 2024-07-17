package fr.lusuva.lusuvair.dtos.apidto;

public class ParticleDto {
	
	private double v;

	/**
	 * 
	 */
	public ParticleDto() {
		super();
	}

	/**
	 * @param name
	 * @param v
	 */
	public ParticleDto(double v) {
		super();
		this.v = v;
	}

	/**
	 * @return the v
	 */
	public double getV() {
		return v;
	}

	/**
	 * @param v the v to set
	 */
	public void setV(double v) {
		this.v = v;
	}
	
}
