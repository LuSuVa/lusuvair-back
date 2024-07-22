package fr.lusuva.lusuvair.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    private String date;

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
     * Region: region
     */
    @ManyToOne
    @JoinColumn(name = "ID_REGION")
    private Region region;

    /**
     * Municipality : municipality
     */
    @ManyToOne
    @JoinColumn(name = "ID_MUNICIPALITY")
    private Municipality municipality;

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
    public String getDate() {
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
     * Get region
     * @return Region
     */
    public Region getRegion() {
        return region;
    }

    /**
     * Get Municipality
     * @return Municipality
     */
    public Municipality getMunicipality() {
        return municipality;
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
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Set List of Particle
     * @param particles
     */
    public void setParticles(List<Particle> particles) {
        this.particles = particles;
    }

    /**
     * Set region
     * @param region
     */
    public void setRegion(Region region) {
        this.region = region;
    }

    /**
     * Set municipality
     * @param municipality
     */
    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }
}
