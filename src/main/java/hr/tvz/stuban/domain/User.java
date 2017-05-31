package hr.tvz.stuban.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2200191449706926219L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	private String username;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Note> notes;
	
	private Integer enabled;

	public User(Integer korisnikId, String username, String firstName, String lastName) {
		super();
		this.user_id = korisnikId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User() {
		super();
	}

	public Integer getId() {
		return user_id;
	}

	public void setId(Integer id) {
		this.user_id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}
