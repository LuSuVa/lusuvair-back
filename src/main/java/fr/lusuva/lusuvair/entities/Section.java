package fr.lusuva.lusuvair.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/** Entity representing a Section  */
@Entity
@Table(name = "SECTION")
public class Section {
	
	/** Id of the Section */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** Name of the Section */
	private String name;
	
	/** Description of the Section */
	private String description;
	
	/** Date and time when the section was created */
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name = "ID_FORUM")
	private Forum forum;

	/** Constructor of the class Section */
	public Section() {
	}

	/** Getter of the id of the section
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter of the id of the section
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter of the name of the section
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/** Setter of the name of the section
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Getter of the name of the section
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/** Setter of the description of the section
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Getter of the date of the section
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/** Setter of the date of the section
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/** Getter of the forum of the section
	 * @return the forum
	 */
	public Forum getForum() {
		return forum;
	}

	/** Setter of the forum of the section 
	 * @param forum the forum to set
	 */
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
	
}
