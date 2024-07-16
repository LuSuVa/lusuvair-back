package fr.lusuva.lusuvair.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/** Entity representing a region */
@Entity
@Table(name = "REGION")
public class Region {

	/** Id of the region */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** Name of the region */
	private String name;
	
	/** Region list of department */
	@OneToMany(mappedBy="region")
	private List<Municipality> municipalities = new ArrayList<>();
	
	/** Region list of department */
	@OneToMany(mappedBy="region")
	private List<Department> departments = new ArrayList<>();

	/**
	 * List of AirQuality
	 */
	@OneToMany(mappedBy = "region")
	private List<AirQuality> airQualities;

	/** Constructor of the class region */
	public Region() {
	}

	/** Getter of the id of region
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter of the id of region
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter of the name of region
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** Setter of the name of region
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter of the municipalities of the Region
	 * @return the list of municipalities
	 */
	public List<Municipality> getMunicipalities() {
		return municipalities;
	}

	/** Setter of the municipalities of the Region
	 * @param municipalities the list of municipalities to set
	 */
	public void setMunicipalities(List<Municipality> municipalities) {
		this.municipalities = municipalities;
	}

	/** Getter of the departments of the Region
	 * @return the departments
	 */
	public List<Department> getDepartments() {
		return departments;
	}

	/** Setter of the departments of the Region
	 * @param departments the departments to set
	 */
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
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
}
