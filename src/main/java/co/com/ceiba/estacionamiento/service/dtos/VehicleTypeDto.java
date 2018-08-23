package co.com.ceiba.estacionamiento.service.dtos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.com.ceiba.estacionamiento.persistence.entities.VehicleType;

/**
 * 
 * @author roger.cordoba
 */
public class VehicleTypeDto {
	private String type;

	private Long 		id;
	private Boolean 	registrationActive;
	private Calendar 	registrationDate;
	

	/**
	 * Constructor without params
	 */
	public VehicleTypeDto() {
		super();
	}

	/**
	 * Constructor with all params
	 * 
	 * @param type
	 * @param id
	 * @param registrationActive
	 * @param registrationDate
	 */
	public VehicleTypeDto(String type, Long id, Boolean registrationActive, Calendar registrationDate) {
		super();
		this.type = type;
		this.id = id;
		this.registrationActive = registrationActive;
		this.registrationDate = registrationDate;
	}

	/**
	 * Method that convert this dto object in entity object
	 * 
	 * @return this object in entity form
	 */
	public VehicleType dtoToEntity() {
		return new VehicleType(this.type, this.id, this.registrationActive, this.registrationDate);
	}

	/**
	 * Method that convert entity object in dto object
	 * 
	 * @param type, is entity object to covert
	 * @return dto object converted
	 */
	public VehicleTypeDto entityToDto(VehicleType type) {
		return new VehicleTypeDto(type.getType(), type.getId(), type.getRegistrationActive(), type.getRegistrationDate());
	}

	/**
	 * Method to convert list of entity object in list of dto object
	 * 
	 * @param lista, list of entity object to convert
	 * @return the list of dtos objects converted
	 */
	public List<VehicleTypeDto> listEntitiesToDtos(List<VehicleType> lista) {
		List<VehicleTypeDto> list = new ArrayList<>();
		for (VehicleType vt: lista) {
			list.add(this.entityToDto(vt));
		}
		return list;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
