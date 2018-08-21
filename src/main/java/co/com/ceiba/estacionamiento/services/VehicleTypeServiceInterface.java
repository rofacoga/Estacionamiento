package co.com.ceiba.estacionamiento.services;

import co.com.ceiba.estacionamiento.persistence.entities.VehicleType;

/**
 * 
 * @author roger.cordoba
 */
public interface VehicleTypeServiceInterface {
	/**
	 * 
	 * @return
	 */
	public Iterable<VehicleType> getAllTypes();
}
