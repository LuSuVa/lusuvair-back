package fr.lusuva.lusuvair.dtos.apidto;

public class ParticleDto {
	private String name;
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
	public ParticleDto(String name, double v) {
		super();
		this.name = name;
		this.v = v;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the v
	 */
	public double getV() {
		return v;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param v the v to set
	 */
	public void setV(double v) {
		this.v = v;
	}
}
