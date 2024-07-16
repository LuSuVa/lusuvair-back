package fr.lusuva.lusuvair.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entity representing a UserAccount.
 */
@Entity
@Table(name="USER_ACCOUNT")
public class UserAccount {

    /** Id of the UserAccount */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Last name of the user */
    private String lastName;

    /** First name of the user */
    private String firstName;

    /** Email of the user */
    private String email;

    /** Password of the user */
    private String password;

    /** Authorities granted to the user */
    @ElementCollection(fetch = FetchType.EAGER)
    private List<GrantedAuthority> authorities;

    /** Notifications associated with the user */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_NOTIFICATION",
            joinColumns = @JoinColumn(name = "ID_USER_ACCOUNT"),
            inverseJoinColumns = @JoinColumn(name = "ID_NOTIFICATION")
    )
    private List<Notification> notifications;

    /** Messages created by the user */
    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<>();

    /** Sections created by the user */
    @OneToMany(mappedBy = "user")
    private List<Section> sections = new ArrayList<>();

    /**
     * Default constructor for the UserAccount class.
     */
    public UserAccount() {
        super();
    }

    /**
     * Constructor for creating a UserAccount with specified details.
     *
     * @param lastName the last name of the user
     * @param firstName the first name of the user
     * @param email the email of the user
     * @param password the password of the user
     * @param role the role of the user
     */
    public UserAccount(String lastName, String firstName, String email, String password, String role) {
        GrantedAuthority roleAuthority = new SimpleGrantedAuthority(role);
        authorities = new ArrayList<>();
        authorities.add(roleAuthority);
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    /**
     * Gets the ID of the user.
     *
     * @return the ID of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param id the new ID of the user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the last name of the user.
     *
     * @return the last name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the user.
     *
     * @param lastName the new last name of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the user.
     *
     * @return the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the user.
     *
     * @param firstName the new first name of the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the new email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the new password of the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the authorities granted to the user.
     *
     * @return the authorities granted to the user
     */
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Sets the authorities granted to the user.
     *
     * @param authorities the new authorities granted to the user
     */
    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    /**
     * Gets the notifications associated with the user.
     *
     * @return the notifications associated with the user
     */
    public List<Notification> getNotifications() {
        return notifications;
    }

    /**
     * Sets the notifications associated with the user.
     *
     * @param notifications the new notifications associated with the user
     */
    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    /**
     * Gets the messages created by the user.
     *
     * @return the messages created by the user
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Sets the messages created by the user.
     *
     * @param messages the new messages created by the user
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Gets the sections created by the user.
     *
     * @return the sections created by the user
     */
    public List<Section> getSections() {
        return sections;
    }

    /**
     * Sets the sections created by the user.
     *
     * @param sections the new sections created by the user
     */
    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
