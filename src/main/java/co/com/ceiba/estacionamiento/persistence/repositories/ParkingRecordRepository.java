package co.com.ceiba.estacionamiento.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.estacionamiento.persistence.entities.ParkingRecord;
import co.com.ceiba.estacionamiento.utilities.VehicleTypeEnum;

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
	public Optional<ParkingRecord> findByRegistrationActiveAndVehiclePlateIgnoreCaseAndCheckOutIsNull(Boolean isActive, String plate);

	/**
	 * 
	 * 
	 * @param isActive
	 * @param type
	 * @return
	 */
	public long countByRegistrationActiveAndVehicleTypeAndCheckOutIsNull(Boolean isActive, VehicleTypeEnum type);
}
