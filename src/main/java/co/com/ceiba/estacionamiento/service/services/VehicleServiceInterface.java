package co.com.ceiba.estacionamiento.service.services;

import java.util.List;

import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.utilities.exceptions.AnExceptionHandler;

/**
 * 
 * @author roger.cordoba
 */
public interface VehicleServiceInterface {
	/**
	 * 
	 * @return
	 */
	public Iterable<VehicleDto> getAllVehicles();

	/**
	 * 
	 * @param vehicle
	 * @return
	 * @throws AnExceptionHandler 
	 */
	public VehicleDto saveVehicle( VehicleDto vehicle ) throws AnExceptionHandler;

	/**
	 * 
	 * @param vehicle
	 * @return
	 */
	public VehicleDto deleteVehicle( VehicleDto vehicle );

	/**
	 * 
	 * @param plate
	 * @return
	 */
	public VehicleDto searchByPlate( String plate );

	/**
	 * 
	 * @param plate
	 * @return
	 */
	public List<VehicleDto> searchAllByPlate( String plate );

	/**
	 * 
	 * @param idType
	 * @return
	 */
	public VehicleDto searchById(Long idType);
}
