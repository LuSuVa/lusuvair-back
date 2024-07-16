package fr.lusuva.lusuvair.entities;

import java.time.LocalDateTime;
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

/**
 * Represents a message entity with an ID, likes, dislikes, date, section, and parent message.
 */
@Entity
@Table(name = "MESSAGE")
public class Message {

    /** Id of the message */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Number of likes for the message */
    private int like;

    /** Number of dislikes for the message */
    private int dislike;

    /** Date and time when the message was created */
    private LocalDateTime date;

    /** The section to which the message belongs */
    @ManyToOne
    @JoinColumn(name = "ID_SECTION")
    private Section section;

    /** The parent message, if this message is a reply */
    @ManyToOne
    @JoinColumn(name = "ID_MESSAGE")
    private Message message;
    
    /** Messages created by the user */
    @OneToMany(mappedBy = "message")
    private List<Message> messages = new ArrayList<>();

    /** The user who posted the message */
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private UserAccount user;
    
    /**
     * Default constructor for the Message class.
     */
    public Message() {
    }

    /**
     * Gets the ID of the message.
     *
     * @return the ID of the message
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the message.
     *
     * @param id the new ID of the message
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the number of likes for the message.
     *
     * @return the number of likes
     */
    public int getLike() {
        return like;
    }

    /**
     * Sets the number of likes for the message.
     *
     * @param like the new number of likes
     */
    public void setLike(int like) {
        this.like = like;
    }

    /**
     * Gets the number of dislikes for the message.
     *
     * @return the number of dislikes
     */
    public int getDislike() {
        return dislike;
    }

    /**
     * Sets the number of dislikes for the message.
     *
     * @param dislike the new number of dislikes
     */
    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    /**
     * Gets the date and time when the message was created.
     *
     * @return the creation date and time
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets the date and time when the message was created.
     *
     * @param date the new creation date and time
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Gets the section to which the message belongs.
     *
     * @return the section
     */
    public Section getSection() {
        return section;
    }

    /**
     * Sets the section to which the message belongs.
     *
     * @param section the new section
     */
    public void setSection(Section section) {
        this.section = section;
    }

    /**
     * Gets the parent message, if this message is a reply.
     *
     * @return the parent message
     */
    public Message getMessage() {
        return message;
    }

    /**
     * Sets the parent message, if this message is a reply.
     *
     * @param message the new parent message
     */
    public void setMessage(Message message) {
        this.message = message;
    }

	/** Gets the user who posted the message.
	 * @return the user
	 */
	public UserAccount getUser() {
		return user;
	}

	/** Sets the user who posted the message.
	 * @param user the user to set
	 */
	public void setUser(UserAccount user) {
		this.user = user;
	}
    
    
}