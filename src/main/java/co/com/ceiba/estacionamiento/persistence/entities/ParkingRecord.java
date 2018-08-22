package co.com.ceiba.estacionamiento.persistence.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "PARKING_RECORDS")
public class ParkingRecord {

	@Column(name = "checkIn", nullable = false)
	private Calendar checkIn;

	@Column(name = "checkOut", nullable = false)
	private Calendar checkOut;


	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "KEEPER_SEQ")
	@SequenceGenerator(name = "KEEPER_SEQ", sequenceName = "KEEPER_SEQ", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "REGISTRATION_ACTIVE", nullable = false)
	private Boolean registrationActive;

	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Calendar registrationDate;

}
