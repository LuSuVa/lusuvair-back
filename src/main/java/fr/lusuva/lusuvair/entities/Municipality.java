package fr.lusuva.lusuvair.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	
	@ManyToOne
	@JoinColumn(name = "id_region")
	private Region region;
	
	@ManyToOne
	@JoinColumn(name = "id_department")
	private Department department;

	/** Constructor of the class Municipality */
	public Municipality() {
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
	
	
}
