package fr.lusuva.lusuvair.dtos.Particle;

import fr.lusuva.lusuvair.entities.Particle;

/**
 * Data Transfer Object for Particle entity.
 */
public class ParticleResponseDto {

    private int id;
    private String name;
    private double quantity;

    /**
     * Default constructor.
     */
    public ParticleResponseDto() {
        super();
    }

    /**
     * Constructs a ParticleResponseDto from a Particle entity.
     * 
     * @param particle the Particle entity
     */
    public ParticleResponseDto(Particle particle) {
        super();
        this.id = particle.getId();
        this.name = particle.getName();
        this.quantity = particle.getQuantity();
    }

    /**
     * Constructs a ParticleResponseDto with specified values.
     * 
     * @param id the ID of the particle
     * @param name the name of the particle
     * @param quantity the quantity of the particle
     */
    public ParticleResponseDto(int id, String name, double quantity) {
        super();
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Gets the ID of the particle.
     * 
     * @return the ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the particle.
     * 
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the particle.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the particle.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the quantity of the particle.
     * 
     * @return the quantity
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the particle.
     * 
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
