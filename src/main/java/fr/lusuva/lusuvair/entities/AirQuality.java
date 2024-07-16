package fr.lusuva.lusuvair.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Entity representing AirQuality
 */
@Entity
@Table(name = "AIR_QUALITY")
public class AirQuality {
    /**
     * int: id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    /**
     * LocalDate: date
     */
    @Column(name = "DATE")
    private LocalDate date;

    /**
     * List of Particle
     */
    @ManyToMany
    @JoinTable(
        name = "AIR_QUALITY_PARTICLES",
        joinColumns = @JoinColumn(name = "ID_AIR_QUALITY"),
        inverseJoinColumns = @JoinColumn(name = "ID_PARTICLE")
    )
    private List<Particle> particles;

    /**
     * Get id
     * @return int representing id
     */
    public int getId() {
        return id;
    }

    /**
     * Get Date
     * @return LocalDate representing date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Get List of Particle
     * @return List of Particle 
     */
    public List<Particle> getParticles() {
        return particles;
    }

    /**
     * Set id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set date
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Set List of Particle
     * @param particles
     */
    public void setParticles(List<Particle> particles) {
        this.particles = particles;
    }
}
