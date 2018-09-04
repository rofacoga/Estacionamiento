package co.com.ceiba.estacionamiento.persistence.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.com.ceiba.estacionamiento.utilities.VehicleTypeEnum;

/**
 * 
 * @author roger.cordoba
 */
@Entity
@Table(name = "VEHICLES")
public class Vehicle {

	@Column(name = "VEHICLETYPE", nullable = false)
	private VehicleTypeEnum type;

	@Column(name = "PLATE", nullable = false)
	private String plate;

	@Column(name = "CYLINDER", nullable = true)
	private Integer cylinder;

	@Column(name = "CYLINDER_BIGGER500", nullable = true)
	private Boolean cylinderGreaterThan500;


	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "VEHICLE_SEQ")
	@SequenceGenerator(name = "VEHICLE_SEQ", sequenceName = "VEHICLE_SEQ", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "REGISTRATION_ACTIVE", nullable = false)
	private Boolean registrationActive;

	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Calendar registrationDate;


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
		this.plate = plate.toUpperCase().trim();
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
