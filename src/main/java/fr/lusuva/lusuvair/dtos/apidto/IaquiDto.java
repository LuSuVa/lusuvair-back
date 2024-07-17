package fr.lusuva.lusuvair.dtos.apidto;

public class IaquiDto {
	private ParticleDto[] particle;

	/**
	 * 
	 */
	public IaquiDto() {
		super();
	}

	/**
	 * @param particle
	 */
	public IaquiDto(ParticleDto[] particle) {
		super();
		this.particle = particle;
	}

	/**
	 * @return the particle
	 */
	public ParticleDto[] getParticle() {
		return particle;
	}

	/**
	 * @param particle the particle to set
	 */
	public void setParticle(ParticleDto[] particle) {
		this.particle = particle;
	}

}
