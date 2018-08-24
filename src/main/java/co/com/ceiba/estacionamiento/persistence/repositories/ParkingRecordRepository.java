package co.com.ceiba.estacionamiento.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.estacionamiento.persistence.entities.ParkingRecord;

/**
 * 
 * @author roger.cordoba
 */
public interface ParkingRecordRepository extends CrudRepository<ParkingRecord, Long> {
	/**
	 * Method that allows listing all active objects
	 * 
	 * @param isActive
	 * @return the list of objects
	 */
	public List<ParkingRecord> findByRegistrationActive(Boolean isActive);

	/**
	 * Method that allows listing all active objects
	 * 
	 * @param isActive
	 * @return the list of objects
	 */
	public List<ParkingRecord> findByRegistrationActiveAndCheckOutIsNull(Boolean isActive);

	/**
	 * 
	 * @param isActive
	 * @param plate
	 * @return
	 */
	public List<ParkingRecord> findByRegistrationActiveAndVehiclePlateStartingWithAndCheckOutIsNull(Boolean isActive, String plate);

	/**
	 * 
	 * @param isActive
	 * @param plate
	 * @return
	 */
	public ParkingRecord findByRegistrationActiveAndVehiclePlateAndCheckOutIsNull(Boolean isActive, String plate);
}
