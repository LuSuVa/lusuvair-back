package fr.lusuva.lusuvair.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entity representing a favorite indicator
 */
@Entity
@Table(name = "FAVORITE_INDICATOR")
public class FavoriteIndicator {
    /**
     * int: id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    /**
     * String: name
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Weather: weather
     */
    @ManyToOne
    @JoinColumn(name = "ID_WEATHER")
    private Weather weather;

    /**
     * Particle: particle
     */
    @ManyToOne
    @JoinColumn(name = "ID_PARTICLE")
    private Particle particle;

    /**
     * Get id
     * @return int representing id
     */
    public int getId() {
        return id;
    }

    /**
     * Get name
     * @return String representing name
     */
    public String getName() {
        return name;
    }

    /**
     * Get weather
     * @return Weather
     */
    public Weather getWeather() {
        return weather;
    }

    /**
     * Set id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set weather
     * @param weather
     */
    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
