package co.com.ceiba.estacionamiento.services;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;

/**
 * 
 * @author roger.cordoba
 */
public interface VehicleServiceInterface {
	/**
	 * 
	 * @return
	 */
	public Iterable<Vehicle> getAllVehicles();

	/**
	 * 
	 * @param vehicle
	 */
	public Vehicle createVehicle( Vehicle vehicle );
}
