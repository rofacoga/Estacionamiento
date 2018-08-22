package co.com.ceiba.estacionamiento.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;

/**
 * 
 * @author roger.cordoba
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	/**
	 * 
	 * @param regState
	 * @return
	 */
	public List<Vehicle> findByRegistrationActive(Boolean isActive);

	/**
	 * 
	 * @param regState
	 * @param plate
	 * @return
	 */
	public List<Vehicle> findByRegistrationActiveAndPlateStartingWith(Boolean isActive, String plate);

	/**
	 * 
	 * @param regState
	 * @param plate
	 * @return
	 */
	public Vehicle findByRegistrationActiveAndPlate(Boolean isActive, String plate);
}
