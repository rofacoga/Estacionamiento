package co.com.ceiba.estacionamiento.service.dtos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;
import co.com.ceiba.estacionamiento.utilities.Constants;
import co.com.ceiba.estacionamiento.utilities.VehicleTypeEnum;

/**
 * 
 * @author roger.cordoba
 */
public class VehicleDto {
	private String plate;
	private Integer cylinder;
	private Boolean cylinderGreaterThan500;
	private VehicleTypeEnum type;

	private Long id;
	private Boolean registrationActive;
	private Calendar registrationDate;

	/**
	 * 
	 * @return
	 */
	public boolean isCylinderGreaterThan500() {
		return (this.cylinder == null) ? this.cylinderGreaterThan500
				: (this.cylinder >= Constants.CYLINDER_MAX_MOTOCYCLES);
	}

	/**
	 * Method that convert this dto object in entity object
	 * 
	 * @return this object in entity form
	 */
	public Vehicle dtoToEntity() {
		Vehicle entity = new Vehicle();
		entity.setPlate(this.plate);
		entity.setCylinder(this.cylinder);
		entity.setType(this.type);
		entity.setId(this.id);
		entity.setRegistrationActive(this.registrationActive);
		entity.setRegistrationDate(this.registrationDate);

		return entity;
	}

	/**
	 * Method that convert entity object in dto object
	 * 
	 * @param type, is entity object to covert
	 * @return dto object converted
	 */
	public VehicleDto entityToDto(Vehicle vehicle) {
		VehicleDto dto = new VehicleDto();
		dto.setPlate(vehicle.getPlate());
		dto.setCylinder(vehicle.getCylinder());
		dto.setType(vehicle.getType());
		dto.setId(vehicle.getId());
		dto.setRegistrationActive(vehicle.getRegistrationActive());
		dto.setRegistrationDate(vehicle.getRegistrationDate());

		return dto;
	}

	/**
	 * Method to convert list of entity object in list of dto object
	 * 
	 * @param lista, list of entity object to convert
	 * @return the list of dtos objects converted
	 */
	public List<VehicleDto> listEntitiesToDtos(List<Vehicle> lista) {
		List<VehicleDto> list = new ArrayList<>();
		for (Vehicle v : lista) {
			list.add(this.entityToDto(v));
		}
		return list;
	}

	/**
	 * @return the plate
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * @param plate the plate to set
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}

	/**
	 * @return the cylinder
	 */
	public Integer getCylinder() {
		return cylinder;
	}

	/**
	 * @param cylinder the cylinder to set
	 */
	public void setCylinder(Integer cylinder) {
		this.cylinder = cylinder;
	}

	/**
	 * @return the cylinderGreaterThan500
	 */
	public Boolean getCylinderGreaterThan500() {
		return cylinderGreaterThan500;
	}

	/**
	 * @param cylinderGreaterThan500 the cylinderGreaterThan500 to set
	 */
	public void setCylinderGreaterThan500(Boolean cylinderGreaterThan500) {
		this.cylinderGreaterThan500 = cylinderGreaterThan500;
	}

	/**
	 * @return the type
	 */
	public VehicleTypeEnum getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(VehicleTypeEnum type) {
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
