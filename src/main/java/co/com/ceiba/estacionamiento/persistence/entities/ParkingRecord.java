package co.com.ceiba.estacionamiento.persistence.entities;

import java.math.BigInteger;
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
import javax.persistence.Table;

/**
 * 
 * @author roger.cordoba
 */
@Entity
@Table(name = "PARKING_RECORDS")
public class ParkingRecord {

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="KEEPER_IN", foreignKey=@ForeignKey(name="FK_PARKRECO_KEEPER_KEEPERIN"), nullable=false)
	private Keeper keeperIn;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="KEEPER_OUT", foreignKey=@ForeignKey(name="FK_PARKRECO_KEEPER_KEEPEROUT"), nullable=true)
	private Keeper keeperOut;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="VEHICLE", foreignKey=@ForeignKey(name="FK_PARKRECO_VEHICLE_VEHICLE"), nullable=false)
	private Vehicle vehicle;

	@Column(name = "CHECKIN", nullable = false)
	private Calendar checkIn;

	@Column(name = "CHECKOUT", nullable = true)
	private Calendar checkOut;

	@Column(name = "TOTALDAYS", nullable = true)
	private Integer totalDays;

	@Column(name = "TOTALHOURS", nullable = true)
	private Integer totalHours;

	@Column(name = "TOTALCOST", nullable = true)
	private BigInteger totalCost;


	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PARKINGRECORD_SEQ")
	@SequenceGenerator(name = "PARKINGRECORD_SEQ", sequenceName = "PARKINGRECORD_SEQ", initialValue = 1, allocationSize = 1)
	private Long id;

	@Column(name = "REGISTRATION_ACTIVE", nullable = false)
	private Boolean registrationActive;

	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Calendar registrationDate;

}
