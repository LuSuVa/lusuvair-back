package fr.lusuva.lusuvair.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entity representing a weather
 */
@Entity
@Table(name = "WEATHER")
public class Weather {
    /**
     * int: id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    /**
     * double: atmospheric pressure
     */
    @Column(name = "ATMOSPHERIC_PRESSURE")
    private double atmophericPressure;
    
    /**
     * double: humidity
     */
    @Column(name = "HUMIDITY")
    private double humidity;
    
    /**
     * LocalDate: date
     */
    @Column(name = "DATE")
    private LocalDate date;
    
    /**
     * String: type
     * TODO : Maybe put a enum here
     */
    @Column(name = "TYPE")
    private String type;

    /**
     * List of favorite indicators
     */
    @OneToMany(mappedBy = "weather")
    private List<FavoriteIndicator> favoriteIndicators;

    /**
     * Get id
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     * Get atmospheric pressure
     * @return double representing atmospheric pressure 
     */
    public double getAtmophericPressure() {
        return atmophericPressure;
    }

    /**
     * Get humidity
     * @return double representing humidity
     */
    public double getHumidity() {
        return humidity;
    }

    /**
     * Get date
     * @return LocalDate representing date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Get type
     * @return String representing type
     */
    public String getType() {
        return type;
    }

    /**
     * Set id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set atmospheric pressure
     * @param atmophericPressure
     */
    public void setAtmophericPressure(double atmophericPressure) {
        this.atmophericPressure = atmophericPressure;
    }

    /**
     * Set humidity
     * @param humidity
     */
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * Set date
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Set type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
