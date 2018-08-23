package co.com.ceiba.estacionamiento.service.dtos;

import java.math.BigInteger;
import java.util.Calendar;

/**
 * 
 * @author roger.cordoba
 */
public class ParkingRecordDto {
	private KeeperDto 	keeperIn;
	private KeeperDto 	keeperOut;
	private VehicleDto 	vehicle;
	private Calendar 	checkIn;
	private Calendar 	checkOut;
	private Integer 	totalDays;
	private Integer 	totalHours;
	private BigInteger 	totalCost;

	private Long 	id;
	private Boolean registrationActive;
	private Calendar registrationDate;


	/**
	 * @return the keeperIn
	 */
	public KeeperDto getKeeperIn() {
		return keeperIn;
	}
	/**
	 * 
	 * @param keeperIn the keeperIn to set
	 */
	public void setKeeperIn(KeeperDto keeperIn) {
		this.keeperIn = keeperIn;
	}

	/**
	 * @return the keeperOut
	 */
	public KeeperDto getKeeperOut() {
		return keeperOut;
	}
	/**
	 * 
	 * @param keeper the keeper to set
	 */
	public void setKeeperOut(KeeperDto keeperOut) {
		this.keeperOut = keeperOut;
	}

	/**
	 * @return the vehicle
	 */
	public VehicleDto getVehicle() {
		return vehicle;
	}
	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(VehicleDto vehicle) {
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
