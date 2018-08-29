package co.com.ceiba.estacionamiento.service.dtos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.com.ceiba.estacionamiento.persistence.entities.Keeper;
import co.com.ceiba.estacionamiento.persistence.entities.ParkingRecord;

/**
 * 
 * @author roger.cordoba
 */
public class ParkingRecordDto {
	private Long 		keeperIn;
	private Long 		keeperOut;
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
	 * Method that convert this dto object in entity object
	 * 
	 * @return this object in entity form
	 */
	public ParkingRecord dtoToEntity() {
		ParkingRecord entity = new ParkingRecord();
		entity.setKeeperIn(new Keeper(this.keeperIn));
		entity.setKeeperOut((this.keeperOut==null)?null:new Keeper(this.keeperOut));
		entity.setVehicle(this.vehicle.dtoToEntity());
		entity.setCheckIn(this.checkIn);
		entity.setCheckOut(this.checkOut);
		entity.setTotalDays(this.totalDays);
		entity.setTotalHours(this.totalHours);
		entity.setTotalCost(this.totalCost);
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
	public ParkingRecordDto entityToDto(ParkingRecord record) {
		ParkingRecordDto dto = new ParkingRecordDto();
		dto.setKeeperIn(record.getKeeperIn().getId());
		dto.setKeeperOut((record.getKeeperOut()==null)?null:record.getKeeperOut().getId());
		dto.setVehicle(new VehicleDto().entityToDto(record.getVehicle()));
		dto.setCheckIn(record.getCheckIn());
		dto.setCheckOut(record.getCheckOut());
		dto.setTotalDays(record.getTotalDays());
		dto.setTotalHours(record.getTotalHours());
		dto.setTotalCost(record.getTotalCost());
		dto.setId(record.getId());
		dto.setRegistrationActive(record.getRegistrationActive());
		dto.setRegistrationDate(record.getRegistrationDate());

		return dto;
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
	public Long getKeeperIn() {
		return keeperIn;
	}
	/**
	 * 
	 * @param keeperIn the keeperIn to set
	 */
	public void setKeeperIn(Long keeperIn) {
		this.keeperIn = keeperIn;
	}

	/**
	 * @return the keeperOut
	 */
	public Long getKeeperOut() {
		return keeperOut;
	}
	/**
	 * 
	 * @param keeper the keeper to set
	 */
	public void setKeeperOut(Long keeperOut) {
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
