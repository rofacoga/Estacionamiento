package co.com.ceiba.estacionamiento.persistence.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import co.com.ceiba.estacionamiento.utils.StateEnum;

/**
 * 
 * @author roger.cordoba
 */
@Entity(name = "VEHICLE")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "VEHICLE_SEQ")
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "PLATE", nullable = false)
	private String plate;

	@Column(name = "REGISTRATION_STATUS", nullable = false)
	private StateEnum registrationStatus;

	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Calendar registrationDate = Calendar.getInstance();

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
	 * @return the registrationStatus
	 */
	public StateEnum getRegistrationStatus() {
		return registrationStatus;
	}

	/**
	 * @param registrationStatus the registrationStatus to set
	 */
	public void setRegistrationStatus(StateEnum registrationStatus) {
		this.registrationStatus = registrationStatus;
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
