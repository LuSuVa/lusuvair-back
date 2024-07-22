package fr.lusuva.lusuvair.entities;

import java.time.LocalDateTime;
import java.util.List;

import fr.lusuva.lusuvair.enums.WeatherType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
     * double: temperature
     */
    @Column(name = "TEMPERATURE")
    private double temperature;
    
    /**
     * LocalDate: date
     */
    @Column(name = "DATE")
    private LocalDateTime date;
    
    /**
     * String: type
     * TODO : Maybe put a enum here
     */
    @Column(name = "TYPE")
    private WeatherType type;
    
    /* Average wind at 10 meters in km/h */
    @Column(name = "WIND")
	private int wind;
	
	/* Wind direction in degrees (0 to 360°) */
    @Column(name = "DIRWIND")
	private int dirWind;
	
	/* Rain probability between 0 and 100% */
    @Column(name = "PROBARAIN")
	private int probaRain;

    /**
     * List of favorite indicators
     */
    @OneToMany(mappedBy = "weather")
    private List<FavoriteIndicator> favoriteIndicators;
    
    @ManyToOne
    @JoinColumn(name = "ID_MUNICIPALITY")
    private Municipality municipality;

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
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @return the type
	 */
	public WeatherType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(WeatherType type) {
		this.type = type;
	}

	/**
	 * @return the wind
	 */
	public int getWind() {
		return wind;
	}

	/**
	 * @param wind the wind to set
	 */
	public void setWind(int wind) {
		this.wind = wind;
	}

	/**
	 * @return the dirWind
	 */
	public int getDirWind() {
		return dirWind;
	}

	/**
	 * @param dirWind the dirWind to set
	 */
	public void setDirWind(int dirWind) {
		this.dirWind = dirWind;
	}

	/**
	 * @return the probaRain
	 */
	public int getProbaRain() {
		return probaRain;
	}

	/**
	 * @return the municipality
	 */
	public Municipality getMunicipality() {
		return municipality;
	}

	/**
	 * @param municipality the municipality to set
	 */
	public void setMunicipality(Municipality municipality) {
		this.municipality = municipality;
	}

	/**
	 * @param probaRain the probaRain to set
	 */
	public void setProbaRain(int probaRain) {
		this.probaRain = probaRain;
	}

	/**
	 * @return the favoriteIndicators
	 */
	public List<FavoriteIndicator> getFavoriteIndicators() {
		return favoriteIndicators;
	}

	/**
	 * @param favoriteIndicators the favoriteIndicators to set
	 */
	public void setFavoriteIndicators(List<FavoriteIndicator> favoriteIndicators) {
		this.favoriteIndicators = favoriteIndicators;
	}

	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
    
}
