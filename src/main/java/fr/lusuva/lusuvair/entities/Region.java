package fr.lusuva.lusuvair.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/** Entity representing a REGION */
@Entity
@Table(name = "REGION")
public class Region {

	/** Id of the region */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** Name of the region */
	private String name;
	
	@OneToMany(mappedBy="region")
	private List<Region> regions = new ArrayList<>();

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

	/** Getter of the municipalities of region
	 * @return the regions
	 */
	public List<Region> getRegions() {
		return regions;
	}

	/** Setter of the municipalities of region
	 * @param regions the regions to set
	 */
	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}
	
	
	
}
