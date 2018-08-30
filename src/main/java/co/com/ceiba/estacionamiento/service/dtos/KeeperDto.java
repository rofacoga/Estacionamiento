package co.com.ceiba.estacionamiento.service.dtos;

import java.util.Calendar;

/**
 * 
 * @author roger.cordoba
 */
public class KeeperDto {
	private String dni;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private String username;
	private String p4ssw0rd;

	private Long id;
	private Boolean registrationActive;
	private Calendar registrationDate;


//	public Keeper dtoToEntity() {
//		Keeper entity = new Keeper();
//		entity.setDni(this.dni);
//		entity.setFirstName(this.firstName);
//		entity.setLastName(this.lastName);
//		entity.setMobileNumber(this.mobileNumber);
//		entity.setEmail(this.email);
//		entity.setUsername(this.username);
//		entity.setP4ssw0rd(this.p4ssw0rd);
//		entity.setId(this.id);
//		entity.setRegistrationActive(this.registrationActive);
//		entity.setRegistrationDate(this.registrationDate);
//
//		return entity;
//	}
//
//	public KeeperDto entityToDto(Keeper keeper) {
//		KeeperDto dto = new KeeperDto();
//		dto.setDni(keeper.getDni());
//		dto.setFirstName(keeper.getFirstName());
//		dto.setLastName(keeper.getLastName());
//		dto.setMobileNumber(keeper.getMobileNumber());
//		dto.setEmail(keeper.getEmail());
//		dto.setUsername(keeper.getUsername());
//		dto.setPassword(keeper.getP4ssw0rd());
//		dto.setId(keeper.getId());
//		dto.setRegistrationActive(keeper.getRegistrationActive());
//		dto.setRegistrationDate(keeper.getRegistrationDate());
//
//		return dto;
//	}
//
//	public List<KeeperDto> listEntitiesToDtos(List<Keeper> lista) {
//		List<KeeperDto> list = new ArrayList<>();
//		for (Keeper k : lista) {
//			list.add(this.entityToDto(k));
//		}
//		return list;
//	}

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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the p4ssw0rd
	 */
	public String getP4ssw0rd() {
		return p4ssw0rd;
	}

	/**
	 * @param password the p4ssw0rd to set
	 */
	public void setPassword(String password) {
		this.p4ssw0rd = password;
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
