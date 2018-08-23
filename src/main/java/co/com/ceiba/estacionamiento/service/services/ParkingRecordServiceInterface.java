package co.com.ceiba.estacionamiento.service.services;

import java.util.List;

import co.com.ceiba.estacionamiento.service.dtos.ParkingRecordDto;
import co.com.ceiba.estacionamiento.utils.exceptions.ThePlateStartWithTheLetterException;

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
	 * @param record
	 * @return
	 * @throws ThePlateStartWithTheLetterException 
	 */
	public ParkingRecordDto saveCheckIn(ParkingRecordDto record) throws ThePlateStartWithTheLetterException;

	/**
	 * 
	 * @param record
	 * @return
	 */
	public ParkingRecordDto saveCheckOut(ParkingRecordDto record);

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
	public List<ParkingRecordDto> searchAllByPlate(String plate);
}
