package co.com.ceiba.estacionamiento.service.services;

import java.util.List;

import co.com.ceiba.estacionamiento.service.dtos.ParkingRecordDto;
import co.com.ceiba.estacionamiento.utilities.exceptions.DateCheckInIsAfterThanDateCheckOutException;
import co.com.ceiba.estacionamiento.utilities.exceptions.DayToEvaluateInvalidException;
import co.com.ceiba.estacionamiento.utilities.exceptions.ThePlateStartWithTheLetterException;

/**
 * 
 * @author roger.cordoba
 */
public interface ParkingRecordServiceInterface {
	/**
	 * 
	 * @return
	 */
	public Iterable<ParkingRecordDto> getAllRecords();
	/**
	 * 
	 * @return
	 */
	public Iterable<ParkingRecordDto> getAllRecordsParked();

	/**
	 * 
	 * @param record
	 * @return
	 * @throws ThePlateStartWithTheLetterException 
	 * @throws DayToEvaluateInvalidException 
	 */
	public ParkingRecordDto saveCheckIn(ParkingRecordDto record) throws ThePlateStartWithTheLetterException, DayToEvaluateInvalidException;

	/**
	 * 
	 * @param record
	 * @return
	 * @throws DateCheckInIsAfterThanDateCheckOutException 
	 */
	public ParkingRecordDto saveCheckOut(ParkingRecordDto record) throws DateCheckInIsAfterThanDateCheckOutException;

	/**
	 * 
	 * @param plate
	 * @return
	 */
	public ParkingRecordDto searchByPlate(String plate);

	/**
	 * 
	 * @param plate
	 * @return
	 */
	public List<ParkingRecordDto> searchAllVehiclesParkedByPlate(String plate);
}
