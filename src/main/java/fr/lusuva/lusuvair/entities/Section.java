package fr.lusuva.lusuvair.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
 * Entity representing a Section.
 */
@Entity
@Table(name = "SECTION")
public class Section {

    /** Id of the Section */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    /** Name of the Section */
    @Column(name = "NAME")
    private String name;

    /** Description of the Section */
    @Column(name = "DESCRIPTION")
    private String description;

    /** Date and time when the section was created */
    @Column(name = "DATE")
    private LocalDateTime date;

    
    /** The user who created the section */
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    @JsonIgnoreProperties({"sections", "password", "authorities", "notifications", "messages"})
    private UserAccount user;

    /**
     * Messages
     */
    @OneToMany(mappedBy = "section")
    @JsonIgnoreProperties("section")
    private List<Message> messages = new ArrayList<>();

    /**
     * Default constructor for the Section class.
     */
    public Section() {
    }

    /**
     * Gets the ID of the section.
     *
     * @return the ID of the section
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the section.
     *
     * @param id the new ID of the section
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the section.
     *
     * @return the name of the section
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the section.
     *
     * @param name the new name of the section
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the section.
     *
     * @return the description of the section
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the section.
     *
     * @param description the new description of the section
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the date and time when the section was created.
     *
     * @return the creation date and time
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets the date and time when the section was created.
     *
     * @param date the new creation date and time
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }



    /**
     * Gets the user who created the section.
     *
     * @return the user
     */
    public UserAccount getUser() {
        return user;
    }

    /**
     * Sets the user who created the section.
     *
     * @param user the new user
     */
    public void setUser(UserAccount user) {
        this.user = user;
    }

    /**
     * Get messages
     * @return List of Message
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Set messages 
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}
