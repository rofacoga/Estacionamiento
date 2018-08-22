package co.com.ceiba.estacionamiento.services;

import java.util.List;

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
	 * @return
	 */
	public Vehicle saveVehicle( Vehicle vehicle );

	/**
	 * 
	 * @param vehicle
	 * @return
	 */
	public Vehicle deleteVehicle( Vehicle vehicle );

	/**
	 * 
	 * @param plate
	 * @return
	 */
	public Vehicle searchByPlate( String plate );

	/**
	 * 
	 * @param plate
	 * @return
	 */
	public List<Vehicle> searchAllByPlate( String plate );
}
