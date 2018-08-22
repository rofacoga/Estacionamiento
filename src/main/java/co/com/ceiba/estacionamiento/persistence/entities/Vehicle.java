package co.com.ceiba.estacionamiento.persistence.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * 
 * @author roger.cordoba
 */
@Entity(name = "VEHICLES")
public class Vehicle {

	@Column(name = "PLATE", nullable = false)
	private String plate;

	@Column(name = "CYLINDER", nullable = true)
	private Integer cylinder;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TYPE", foreignKey=@ForeignKey(name="FK_VEHICLE_VEHICLETYPE_TYPE"), nullable=false)
	private VehicleType type;


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
	 * @return the type
	 */
	public VehicleType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(VehicleType type) {
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
