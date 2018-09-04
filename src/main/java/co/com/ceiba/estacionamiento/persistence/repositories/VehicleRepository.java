package co.com.ceiba.estacionamiento.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;

/**
 * 
 * @author roger.cordoba
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	/**
	 * Method that allows listing all active objects
	 * 
	 * @param isActive
	 * @return the list of objects
	 */
	public List<Vehicle> findByRegistrationActive(Boolean isActive);

	/**
	 * 
	 * @param isActive
	 * @param plate
	 * @return
	 */
	public List<Vehicle> findByRegistrationActiveAndPlateIgnoreCaseStartingWith(Boolean isActive, String plate);

	/**
	 * 
	 * @param isActive
	 * @param plate
	 * @return
	 */
	public Optional<Vehicle> findByRegistrationActiveAndPlateIgnoreCase(Boolean isActive, String plate);
}
