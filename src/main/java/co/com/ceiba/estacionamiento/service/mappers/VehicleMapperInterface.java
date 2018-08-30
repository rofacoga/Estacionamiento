package co.com.ceiba.estacionamiento.service.mappers;

import java.util.List;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;
import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;

/**
 * 
 * @author roger.cordoba
 */
public interface VehicleMapperInterface {
	/**
	 * Method that convert this dto object in entity object
	 * 
	 * @return this object in entity form
	 */
	Vehicle dtoToEntity(VehicleDto dto);

	/**
	 * Method that convert entity object in dto object
	 * 
	 * @param type, is entity object to covert
	 * @return dto object converted
	 */
	VehicleDto entityToDto(Vehicle entity);

	/**
	 * Method to convert list of entity object in list of dto object
	 * 
	 * @param lista, list of entity object to convert
	 * @return the list of dtos objects converted
	 */
	List<VehicleDto> listEntitiesToDtos(List<Vehicle> list);
}
