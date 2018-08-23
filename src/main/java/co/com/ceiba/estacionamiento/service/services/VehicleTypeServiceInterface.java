package co.com.ceiba.estacionamiento.service.services;

import co.com.ceiba.estacionamiento.service.dtos.VehicleTypeDto;

/**
 * 
 * @author roger.cordoba
 */
public interface VehicleTypeServiceInterface {
	/**
	 * 
	 * @return
	 */
	public Iterable<VehicleTypeDto> getAllTypes();

	/**
	 * 
	 * @param type
	 * @return
	 */
	public VehicleTypeDto saveType(VehicleTypeDto type);

	/**
	 * 
	 * @param type
	 * @return
	 */
	public VehicleTypeDto deleteType(VehicleTypeDto type);

	/**
	 * 
	 * @param idType
	 * @return
	 */
	public VehicleTypeDto searchById(Long idType);
}
