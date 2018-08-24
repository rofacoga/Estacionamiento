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

	/**
	 * Constructor without params
	 */
	public ParkingRecord() {
		super();
	}

	/**
	 * Constructor with all params
	 * 
	 * @param keeperIn
	 * @param keeperOut
	 * @param vehicle
	 * @param checkIn
	 * @param checkOut
	 * @param totalDays
	 * @param totalHours
	 * @param totalCost
	 * @param id
	 * @param registrationActive
	 * @param registrationDate
	 */
	public ParkingRecord(Keeper keeperIn, Keeper keeperOut, Vehicle vehicle, Calendar checkIn, Calendar checkOut,
			Integer totalDays, Integer totalHours, BigInteger totalCost, Long id, Boolean registrationActive,
			Calendar registrationDate) {
		super();
		this.keeperIn = keeperIn;
		this.keeperOut = keeperOut;
		this.vehicle = vehicle;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.totalDays = totalDays;
		this.totalHours = totalHours;
		this.totalCost = totalCost;
		this.id = id;
		this.registrationActive = registrationActive;
		this.registrationDate = registrationDate;
	}

	/**
	 * @return the keeperIn
	 */
	public Keeper getKeeperIn() {
		return keeperIn;
	}

	/**
	 * @param keeperIn the keeperIn to set
	 */
	public void setKeeperIn(Keeper keeperIn) {
		this.keeperIn = keeperIn;
	}

	/**
	 * @return the keeperOut
	 */
	public Keeper getKeeperOut() {
		return keeperOut;
	}

	/**
	 * @param keeperOut the keeperOut to set
	 */
	public void setKeeperOut(Keeper keeperOut) {
		this.keeperOut = keeperOut;
	}

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	/**
	 * @return the checkIn
	 */
	public Calendar getCheckIn() {
		return checkIn;
	}

	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(Calendar checkIn) {
		this.checkIn = checkIn;
	}

	/**
	 * @return the checkOut
	 */
	public Calendar getCheckOut() {
		return checkOut;
	}

	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(Calendar checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * @return the totalDays
	 */
	public Integer getTotalDays() {
		return totalDays;
	}

	/**
	 * @param totalDays the totalDays to set
	 */
	public void setTotalDays(Integer totalDays) {
		this.totalDays = totalDays;
	}

	/**
	 * @return the totalHours
	 */
	public Integer getTotalHours() {
		return totalHours;
	}

	/**
	 * @param totalHours the totalHours to set
	 */
	public void setTotalHours(Integer totalHours) {
		this.totalHours = totalHours;
	}

	/**
	 * @return the totalCost
	 */
	public BigInteger getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(BigInteger totalCost) {
		this.totalCost = totalCost;
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
