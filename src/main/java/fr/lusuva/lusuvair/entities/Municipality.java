package fr.lusuva.lusuvair.entities;

import java.util.List;

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
 * Represents a municipality entity in the system.
 * <p>
 * This class is mapped to the MUNICIPALITY table in the database and serves as
 * the primary representation
 * of a municipality within the application. It includes relationships to
 * regions, departments, user accounts,
 * air qualities, and weather observations.
 */
@Entity
@Table(name = "MUNICIPALITY")
public class Municipality {

	/**
	 * Unique identifier for the municipality.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/**
	 * ZIP code of the municipality.
	 */
	@Column(name = "ZIP_CODE")
	private int zipCode;

	/**
	 * Name of the municipality.
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * Population of the municipality.
	 */
	@Column(name = "POPULATION")
	private int population;

	/**
	 * INSEE code of the municipality.
	 */
	@Column(name = "INSEE_CODE")
	private int inseeCode;

	/**
	 * The region to which the municipality belongs.
	 */
	@ManyToOne
	@JoinColumn(name = "ID_REGION")
	private Region region;

	/**
	 * The department to which the municipality belongs.
	 */
	@ManyToOne
	@JoinColumn(name = "ID_DEPARTMENT")
	private Department department;

	/**
	 * List of user accounts associated with the municipality.
	 */
	@OneToMany(mappedBy = "municipality")
	private List<UserAccount> userAccounts;

	/**
	 * List of air quality measurements associated with the municipality.
	 */
	@OneToMany(mappedBy = "municipality")
	private List<AirQuality> airQualities;

	/**
	 * List of weather observations associated with the municipality.
	 */
	@OneToMany(mappedBy = "municipality")
	private List<Weather> weather;

	/**
	 * Default constructor.
	 */
	public Municipality() {
	}

	/**
	 * Constructor with parameters.
	 *
	 * @param zipCode    the ZIP code of the municipality
	 * @param name       the name of the municipality
	 * @param population the population of the municipality
	 * @param inseeCode  the INSEE code of the municipality
	 */
	public Municipality(int zipCode, String name, int population, int inseeCode) {
		super();
		this.zipCode = zipCode;
		this.name = name;
		this.population = population;
		this.inseeCode = inseeCode;
	}

	/**
	 * Gets the unique identifier for the municipality.
	 *
	 * @return the municipality ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for the municipality.
	 *
	 * @param id the municipality ID to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the ZIP code of the municipality.
	 *
	 * @return the ZIP code
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the ZIP code of the municipality.
	 *
	 * @param zipCode the ZIP code to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Gets the name of the municipality.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the municipality.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the population of the municipality.
	 *
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * Sets the population of the municipality.
	 *
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	/**
	 * Gets the region to which the municipality belongs.
	 *
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * Sets the region to which the municipality belongs.
	 *
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * Gets the department to which the municipality belongs.
	 *
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Sets the department to which the municipality belongs.
	 *
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * Gets the list of air quality measurements associated with the municipality.
	 *
	 * @return the list of air qualities
	 */
	public List<AirQuality> getAirQualities() {
		return airQualities;
	}

	/**
	 * Sets the list of air quality measurements associated with the municipality.
	 *
	 * @param airQualities the list of air qualities to set
	 */
	public void setAirQualities(List<AirQuality> airQualities) {
		this.airQualities = airQualities;
	}

	/**
	 * Gets the list of user accounts associated with the municipality.
	 *
	 * @return the list of user accounts
	 */
	public List<UserAccount> getUserAccounts() {
		return userAccounts;
	}

	/**
	 * Sets the list of user accounts associated with the municipality.
	 *
	 * @param userAccounts the list of user accounts to set
	 */
	public void setUserAccounts(List<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	/**
	 * Gets the list of weather observations associated with the municipality.
	 *
	 * @return the list of weather observations
	 */
	public List<Weather> getWeather() {
		return weather;
	}

	/**
	 * Sets the list of weather observations associated with the municipality.
	 *
	 * @param weather the list of weather observations to set
	 */
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	/**
	 * Gets the INSEE code of the municipality.
	 *
	 * @return the INSEE code
	 */
	public int getInseeCode() {
		return inseeCode;
	}

	/**
	 * Sets the INSEE code of the municipality.
	 *
	 * @param inseeCode the INSEE code to set
	 */
	public void setInseeCode(int inseeCode) {
		this.inseeCode = inseeCode;
	}
}
