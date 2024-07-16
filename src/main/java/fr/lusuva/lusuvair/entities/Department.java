package fr.lusuva.lusuvair.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/** Entity representing a department */
@Entity
@Table(name = "DEPARTMENT")
public class Department {
	
	/** Id of the municipality */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** Name of the department */
	private String name;
	
	/** Municipality list of department	 */
	@OneToMany(mappedBy="department")
	private List<Municipality> municipalities = new ArrayList<>();
	
	/** Region of the department */
	@ManyToOne
	@JoinColumn(name = "ID_REGION")
	private Region region;

	/** Constructor of the class department */
	public Department() {
	}

	/** Getter of the id of department
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter of the id of department
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter of the name of department
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** Setter of the name of department
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter of the municipalities in the department
	 * @return the list of municipalities
	 */
	public List<Municipality> getMunicipalities() {
		return municipalities;
	}

	/** Setter of the municipalities in the department
	 * @param municipalities the list of municipalities to set
	 */
	public void setMunicipalities(List<Municipality> municipalities) {
		this.municipalities = municipalities;
	}

	/** Getter of the region of department
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/** Setter of the region of department
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}
	
}
