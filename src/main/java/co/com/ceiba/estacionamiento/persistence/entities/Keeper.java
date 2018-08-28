package co.com.ceiba.estacionamiento.persistence.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author roger.cordoba
 */
@Entity
@Table(name = "KEEPERS")
public class Keeper {
	/**
	 * attribute for Unique Personal Identification Number
	 */
	@Column(name = "DNI", nullable = false)
	private String dni;

	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;

	@Column(name = "LASTNAME", nullable = false)
	private String secondName;

	@Column(name = "MOBILENUMBER", nullable = true)
	private String mobileNumber;

	@Column(name = "EMAIL", nullable = true)
	private String email;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;


	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "KEEPER_SEQ")
	@SequenceGenerator(name = "KEEPER_SEQ", sequenceName = "KEEPER_SEQ", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "REGISTRATION_ACTIVE", nullable = false)
	private Boolean registrationActive;

	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Calendar registrationDate;

	/**
	 * Constructor without params
	 */
	public Keeper() {
		super();
	}

	/**
	 * Constructor with id as param
	 */
	public Keeper(Long id) {
		super();
		this.id=id;
	}

	/**
	 * Constructor with all params
	 * 
	 * @param dni
	 * @param firstName
	 * @param secondName
	 * @param mobileNumber
	 * @param email
	 * @param username
	 * @param password
	 * @param id
	 * @param registrationActive
	 * @param registrationDate
	 */
	public Keeper(String dni, String firstName, String secondName, String mobileNumber, String email, String username,
			String password, Long id, Boolean registrationActive, Calendar registrationDate) {
		super();
		this.dni = dni;
		this.firstName = firstName;
		this.secondName = secondName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.username = username;
		this.password = password;
		this.id = id;
		this.registrationActive = registrationActive;
		this.registrationDate = registrationDate;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * @param secondName the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the registrationActive
	 */
	public Boolean getRegistrationActive() {
		return registrationActive;
	}

	/**
	 * @param registrationActive the registrationActive to set
	 */
	public void setRegistrationActive(Boolean registrationActive) {
		this.registrationActive = registrationActive;
	}

	/**
	 * @return the registrationDate
	 */
	public Calendar getRegistrationDate() {
		return registrationDate;
	}

	/**
	 * @param registrationDate the registrationDate to set
	 */
	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}
}
