package fr.lusuva.lusuvair.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/** Entity representing a municipality */
@Entity
@Table(name = "MUNICIPALITY")
public class Municipality {
	
	/** Id of the municipality */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** Zip code of the municipality */
	private int zipCode;
	
	/** Name of the municipality */
	private String name;
	
	/** Population of the municipality */
	private int population;
	
	/** Region of the municipality */
	@ManyToOne
	@JoinColumn(name = "ID_REGION")
	private Region region;
	
	/** Department of the municipality */
	@ManyToOne
	@JoinColumn(name = "ID_DEPARTMENT")
	private Department department;
	
	/**
	 * List of AirQuality
	 */
	@OneToMany(mappedBy = "municipality")
	private List<UserAccount> userAccounts;

	/**
	 * List of AirQuality
	 */
	@OneToMany(mappedBy = "municipality")
	private List<AirQuality> airQualities;
	
	/**
     * List of weather
     */
    @OneToMany(mappedBy = "municipality")
    private List<Weather> weather;
    

	/** Constructor of the class Municipality */
	public Municipality() {
	}

	/**
	 * @param id
	 * @param zipCode
	 * @param name
	 * @param population
	 * @param region
	 * @param department
	 * @param airQualities
	 */
	public Municipality(int zipCode, String name, int population) {
		super();
		
		this.zipCode = zipCode;
		this.name = name;
		this.population = population;

	}

	/** Getter of the id of the municipality
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter of the id of the municipality
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter of the zipCode of the municipality
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/** Setter of the zipCode of the municipality
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/** Getter of the name of the municipality
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** Setter of the name of the municipality
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**  Getter of the population of the municipality
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/** Setter of the population of the municipality
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	/** Getter of the region of the municipality
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/** Setter of the region of the municipality
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/** Getter of the department of the municipality
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/** Setter of the department of the municipality
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}	
	
	/**
	 * Getter of the AirQualities
	 * @return List of AirQuality
	 */
	public List<AirQuality> getAirQualities() {
		return airQualities;
	}

	/**
	 * Setter of the AirQualities
	 * @param airQualities
	 */
	public void setAirQualities(List<AirQuality> airQualities) {
		this.airQualities = airQualities;
	}

	/**
	 * @return the userAccounts
	 */
	public List<UserAccount> getUserAccounts() {
		return userAccounts;
	}

	/**
	 * @param userAccounts the userAccounts to set
	 */
	public void setUserAccounts(List<UserAccount> userAccounts) {
		this.userAccounts = userAccounts;
	}

	/**
	 * @return the weather
	 */
	public List<Weather> getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	
	
}
