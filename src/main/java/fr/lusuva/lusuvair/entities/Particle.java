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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entity representing a Particle
 */
@Entity
@Table(name = "PARTICLE")
public class Particle {
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
	 * double: quantity
	 */
	@Column(name = "QUANTITY")
	private double quantity;

	/**
	 * List of favorite indicators
	 */
	@OneToMany(mappedBy = "particle")
	private List<FavoriteIndicator> favoriteIndicators;

	/**
	 * List of Air Quality
	 */
	@ManyToMany
	@JoinTable(name = "AIR_QUALITY_PARTICLES", joinColumns = @JoinColumn(name = "ID_PARTICLE"), inverseJoinColumns = @JoinColumn(name = "ID_AIR_QUALITY"))
	private List<AirQuality> airQualities;

	/**
	 * Get id
	 * 
	 * @return int representing id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get name
	 * 
	 * @return String representing name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get quantity
	 * 
	 * @return double representing quantity
	 */
	public double getQuantity() {
		return quantity;
	}

	/**
	 * Get favorite indicators
	 * 
	 * @return List of FavoriteIndicator
	 */
	public List<FavoriteIndicator> getFavoriteIndicators() {
		return favoriteIndicators;
	}

	/**
	 * Get air qualities
	 * 
	 * @return List of AirQuality
	 */
	public List<AirQuality> getAirQualities() {
		return airQualities;
	}

	/**
	 * Set id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Set name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set quantity
	 * 
	 * @param quantity
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	/**
	 * Set list of FavoriteIndicators
	 * 
	 * @param favoriteIndicators
	 */
	public void setFavoriteIndicators(List<FavoriteIndicator> favoriteIndicators) {
		this.favoriteIndicators = favoriteIndicators;
	}

	/**
	 * Set list of AirQuality
	 * 
	 * @param airQualities
	 */
	public void setAirQualities(List<AirQuality> airQualities) {
		this.airQualities = airQualities;
	}

	@Override
	public String toString() {
		return "Particle [id=" + id + ", quantity=" + quantity + ", name=" + name + ", favoriteIndicators="
				+ favoriteIndicators + ", airQualities=" + airQualities + "]";
	}

}
