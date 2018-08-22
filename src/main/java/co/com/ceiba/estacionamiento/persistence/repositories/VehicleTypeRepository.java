package co.com.ceiba.estacionamiento.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.estacionamiento.persistence.entities.VehicleType;

/**
 * 
 * @author roger.cordoba
 */
public interface VehicleTypeRepository extends CrudRepository<VehicleType, Long> {
	/**
	 * 
	 * @param regState
	 * @return
	 */
	public List<VehicleType> findByRegistrationActive(Boolean isActive);
}
