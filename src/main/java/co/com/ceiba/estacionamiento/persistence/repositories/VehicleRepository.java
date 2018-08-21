package co.com.ceiba.estacionamiento.persistence.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;

/**
 * 
 * @author roger.cordoba
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

}
