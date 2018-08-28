package co.com.ceiba.estacionamiento.service.services;

import java.util.List;

import co.com.ceiba.estacionamiento.service.dtos.ParkingRecordDto;
import co.com.ceiba.estacionamiento.utilities.exceptions.AnExceptionHandler;

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
	public Iterable<ParkingRecordDto> getAllParkedVehicles();

	/**
	 * 
	 * @param record
	 * @return
	 * 
	 * @throws ThePlateStartWithTheLetterException 
	 * @throws DayToEvaluateInvalidException 
	 * @throws ThePlateIsAlreadyRegisteredException 
	 * @throws ParkingExceedsTheAllowedCapacityException 
	 */
	public ParkingRecordDto saveCheckIn(ParkingRecordDto record) throws AnExceptionHandler;

	/**
	 * 
	 * @param record
	 * @return
	 * @throws DateCheckInIsAfterThanDateCheckOutException 
	 * @throws RegistrationOfParkedVehicleNotFoundException 
	 * @throws RequiredFieldIsEmptyException 
	 */
	public ParkingRecordDto saveCheckOut(ParkingRecordDto record) throws AnExceptionHandler;

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ParkingRecordDto searchById(Long id);

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
