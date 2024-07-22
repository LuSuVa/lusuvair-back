package fr.lusuva.lusuvair.dtos.apidto;

/**
 * Represents a particle measurement with its value.
 */
public class ParticleDto {

    /**
     * The value of the particle measurement.
     */
    private double v;

    /**
     * Default constructor for ParticleDto.
     */
    public ParticleDto() {
        super();
    }

    /**
     * Parameterized constructor for ParticleDto.
     *
     * @param v the value of the particle measurement
     */
    public ParticleDto(double v) {
        super();
        this.v = v;
    }

    /**
     * Gets the value of the particle measurement.
     *
     * @return the value of the particle measurement
     */
    public double getV() {
        return v;
    }

    /**
     * Sets the value of the particle measurement.
     *
     * @param v the value to set for the particle measurement
     */
    public void setV(double v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "ParticleDto [v=" + v + "]";
    }
}
