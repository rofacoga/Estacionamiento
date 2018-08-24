package co.com.ceiba.estacionamiento.service.dtos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.com.ceiba.estacionamiento.persistence.entities.ParkingRecord;

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
	 * Constructor without params
	 */
	public ParkingRecordDto() {
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
	public ParkingRecordDto(KeeperDto keeperIn, KeeperDto keeperOut, VehicleDto vehicle, Calendar checkIn,
			Calendar checkOut, Integer totalDays, Integer totalHours, BigInteger totalCost, Long id,
			Boolean registrationActive, Calendar registrationDate) {
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
	 * Method that convert this dto object in entity object
	 * 
	 * @return this object in entity form
	 */
	public ParkingRecord dtoToEntity() {
		return new ParkingRecord(
				this.keeperIn.dtoToEntity(), 
				this.keeperOut.dtoToEntity(), 
				this.vehicle.dtoToEntity(), 
				this.checkIn, this.checkOut, 
				this.totalDays, this.totalHours, this.totalCost, 
				this.id, this.registrationActive, this.registrationDate);
	}

	/**
	 * Method that convert entity object in dto object
	 * 
	 * @param type, is entity object to covert
	 * @return dto object converted
	 */
	public ParkingRecordDto entityToDto(ParkingRecord record) {
		return new ParkingRecordDto(
				new KeeperDto().entityToDto(record.getKeeperIn()), 
				new KeeperDto().entityToDto(record.getKeeperOut()), 
				new VehicleDto().entityToDto(record.getVehicle()), 
				record.getCheckIn(), record.getCheckOut(), 
				record.getTotalDays(), record.getTotalHours(), record.getTotalCost(), 
				record.getId(), record.getRegistrationActive(), record.getRegistrationDate());
	}

	/**
	 * Method to convert list of entity object in list of dto object
	 * 
	 * @param lista, list of entity object to convert
	 * @return the list of dtos objects converted
	 */
	public List<ParkingRecordDto> listEntitiesToDtos(List<ParkingRecord> lista) {
		List<ParkingRecordDto> list = new ArrayList<>();
		for (ParkingRecord pr: lista) {
			list.add(this.entityToDto(pr));
		}
		return list;
	}

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
