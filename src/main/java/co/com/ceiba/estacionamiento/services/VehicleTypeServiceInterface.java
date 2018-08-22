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

	/**
	 * 
	 * @param type
	 * @return
	 */
	public VehicleType saveType( VehicleType type );

	/**
	 * 
	 * @param type
	 * @return
	 */
	public VehicleType deleteType( VehicleType type );
}
