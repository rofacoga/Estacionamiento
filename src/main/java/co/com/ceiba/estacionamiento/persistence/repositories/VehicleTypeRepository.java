package co.com.ceiba.estacionamiento.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.estacionamiento.persistence.entities.VehicleType;

/**
 * 
 * @author roger.cordoba
 */
public interface VehicleTypeRepository extends CrudRepository<VehicleType, Long> {

}
