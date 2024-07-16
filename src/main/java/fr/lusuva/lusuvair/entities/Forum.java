package fr.lusuva.lusuvair.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Represents a forum entity with an ID, name, and a list of sections.
 */
@Entity
@Table(name = "FORUM")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "forum")
    private List<Section> sections = new ArrayList<>();

    /**
     * Default constructor for the Forum class.
     */
    public Forum() {
    }

    /**
     * Gets the ID of the forum.
     *
     * @return the ID of the forum
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the forum.
     *
     * @param id the new ID of the forum
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the forum.
     *
     * @return the name of the forum
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the forum.
     *
     * @param name the new name of the forum
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of sections in the forum.
     *
     * @return the list of sections in the forum
     */
    public List<Section> getSections() {
        return sections;
    }

    /**
     * Sets the list of sections in the forum.
     *
     * @param sections the new list of sections in the forum
     */
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}