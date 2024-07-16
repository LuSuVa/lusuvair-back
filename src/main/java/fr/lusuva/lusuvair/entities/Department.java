package fr.lusuva.lusuvair.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@OneToMany(mappedBy="department")
	private List<Municipality> municipalities = new ArrayList<>();

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

	/** Getter of the municipalities of department
	 * @return the municipalities
	 */
	public List<Municipality> getMunicipalities() {
		return municipalities;
	}

	/** Setter of the municipalities of department
	 * @param municipalities the municipalities to set
	 */
	public void setMunicipalities(List<Municipality> municipalities) {
		this.municipalities = municipalities;
	}
	
	
	
}
