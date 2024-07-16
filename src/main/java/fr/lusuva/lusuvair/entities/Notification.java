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
import jakarta.persistence.Table;

@Entity
@Table(name ="NOTIFICATION")
public class Notification {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String message;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="USER_NOTIFICATION",
			joinColumns=@JoinColumn(name = "ID_USER_ACCOUNT"),
			inverseJoinColumns= @JoinColumn(name="ID_NOTIFICATION")
			)
	private List<UserAccount> userAccount;
	/**
	 * 
	 */
	public Notification() {
		super();
	}
	/**
	 * @param id
	 * @param message
	 * @param userAccount
	 */
	public Notification(int id, String message, List<UserAccount> userAccount) {
		super();
		this.id = id;
		this.message = message;
		this.userAccount = userAccount;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @return the userAccount
	 */
	public List<UserAccount> getUserAccount() {
		return userAccount;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @param userAccount the userAccount to set
	 */
	public void setUserAccount(List<UserAccount> userAccount) {
		this.userAccount = userAccount;
	}
}
