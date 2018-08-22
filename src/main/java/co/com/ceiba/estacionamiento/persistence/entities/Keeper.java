package co.com.ceiba.estacionamiento.persistence.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 
 * @author roger.cordoba
 */
@Entity(name = "KEEPERS")
public class Keeper {
	/**
	 * attribute for Unique Personal Identification Number
	 */
	@Column(name = "UPIN", nullable = false)
	private String upin;

	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;

	@Column(name = "SECONDNAME", nullable = false)
	private String secondName;

	@Column(name = "MOBILENUMBER", nullable = true)
	private String mobileNumber;

	@Column(name = "EMAIL", nullable = true)
	private String email;

	@Column(name = "NICKNAME", nullable = false)
	private String nickname;

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
	 * @return the upin
	 */
	public String getUpin() {
		return upin;
	}

	/**
	 * @param upin the upin to set
	 */
	public void setUpin(String upin) {
		this.upin = upin;
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
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
