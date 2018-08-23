package co.com.ceiba.estacionamiento.service.dtos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.com.ceiba.estacionamiento.persistence.entities.Keeper;

/**
 * 
 * @author roger.cordoba
 */
public class KeeperDto {
	private String upin;
	private String firstName;
	private String secondName;
	private String mobileNumber;
	private String email;
	private String username;
	private String password;

	private Long id;
	private Boolean registrationActive;
	private Calendar registrationDate;

	/**
	 * Constructor without params
	 */
	public KeeperDto() {
		super();
	}

	/**
	 * Constructor with all params
	 * 
	 * @param upin
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
	public KeeperDto(String upin, String firstName, String secondName, String mobileNumber, String email,
			String username, String password, Long id, Boolean registrationActive, Calendar registrationDate) {
		super();
		this.upin = upin;
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
	 * Method that convert this dto object in entity object
	 * 
	 * @return this object in entity form
	 */
	public Keeper dtoToEntity() {
		return new Keeper(this.upin, this.firstName, this.secondName, this.mobileNumber, this.email, this.username,
				this.password, this.id, this.registrationActive, this.registrationDate);
	}

	/**
	 * Method that convert entity object in dto object
	 * 
	 * @param type, is entity object to covert
	 * @return dto object converted
	 */
	public KeeperDto entityToDto(Keeper type) {
		return new KeeperDto(type.getUpin(), type.getFirstName(), type.getSecondName(), type.getMobileNumber(),
				type.getEmail(), type.getUsername(), type.getPassword(), type.getId(), type.getRegistrationActive(),
				type.getRegistrationDate());
	}

	/**
	 * Method to convert list of entity object in list of dto object
	 * 
	 * @param lista, list of entity object to convert
	 * @return the list of dtos objects converted
	 */
	public List<KeeperDto> listEntitiesToDtos(List<Keeper> lista) {
		List<KeeperDto> list = new ArrayList<>();
		for (Keeper k : lista) {
			list.add(this.entityToDto(k));
		}
		return list;
	}

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
