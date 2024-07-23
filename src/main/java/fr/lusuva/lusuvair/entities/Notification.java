package fr.lusuva.lusuvair.entities;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

/**
 * Entity representing a notification.
 */
@Entity
public class Notification {

    /** The unique identifier for the notification */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    /** The message content of the notification */
    private String message;

    /**
     * The list of user accounts associated with the notification.
     * 
     * Uses a join table for the many-to-many relationship.
     */
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="USER_NOTIFICATION",
            joinColumns=@JoinColumn(name = "ID_USER_ACCOUNT"),
            inverseJoinColumns= @JoinColumn(name="ID_NOTIFICATION")
    )
    private List<UserAccount> userAccount;

    /**
     * Constructs a new Notification with default values.
     */
    public Notification() {
        super();
    }

    /**
     * Constructs a new Notification with the specified id, message, and user accounts.
     * 
     * @param id the unique identifier for the notification
     * @param message the message content of the notification
     * @param userAccount the list of user accounts associated with the notification
     */
    public Notification(int id, String message, List<UserAccount> userAccount) {
        super();
        this.id = id;
        this.message = message;
        this.userAccount = userAccount;
    }

    /**
     * Returns the unique identifier for the notification.
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the notification.
     * 
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the message content of the notification.
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message content of the notification.
     * 
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns the list of user accounts associated with the notification.
     * 
     * @return the userAccount
     */
    public List<UserAccount> getUserAccount() {
        return userAccount;
    }

    /**
     * Sets the list of user accounts associated with the notification.
     * 
     * @param userAccount the userAccount to set
     */
    public void setUserAccount(List<UserAccount> userAccount) {
        this.userAccount = userAccount;
    }
}
