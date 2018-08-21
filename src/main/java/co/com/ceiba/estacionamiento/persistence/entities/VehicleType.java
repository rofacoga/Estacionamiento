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
@Entity(name = "VEHICLE_TYPE")
public class VehicleType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="VEHICLETYPE_SEQ")
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "TYPE", nullable = false)
	private String type;

	@Column(name = "REGISTRATION_STATUS", nullable = false)
	private StateEnum registrationStatus;

	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Calendar registrationDate = Calendar.getInstance();
}
