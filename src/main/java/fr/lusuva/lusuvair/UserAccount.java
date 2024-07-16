package fr.lusuva.lusuvair;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import fr.lusuva.lusuvair.entities.Notification;
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

@Entity
public class UserAccount {

	  @Id
	  @GeneratedValue(strategy= GenerationType.IDENTITY)
	  private int id;
	  private String lastName;
	  private String firstName;
	  private String email;
	  private String password;
	  @ElementCollection(fetch=FetchType.EAGER)
	  private List<GrantedAuthority> authorities;
	  @ManyToMany(cascade = CascadeType.ALL)
	  @JoinTable(
			  name= "USER_NOTIFICATION",
			  joinColumns=@JoinColumn(name = "ID_USER_ACCOUNT"),
			  inverseJoinColumns= @JoinColumn(name="ID_NOTIFICATION")
			  )
	  private List<Notification> notification;
	  public UserAccount() {
			super();		
		}
	  
		public UserAccount(String lastName, String firstName,String email, String password, String role) {
			GrantedAuthority roleAuthority = new SimpleGrantedAuthority(role);
			authorities = new ArrayList<>();
			authorities.add(roleAuthority);
			this.lastName = lastName;
			this.firstName = firstName;
			this.email = email;
			this.password = password;
			
		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @return the lastName
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * @return the firstName
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @return the authorities
		 */
		public List<GrantedAuthority> getAuthorities() {
			return authorities;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		/**
		 * @param firstName the firstName to set
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		/**
		 * @param authorities the authorities to set
		 */
		public void setAuthorities(List<GrantedAuthority> authorities) {
			this.authorities = authorities;
		}
	
}
