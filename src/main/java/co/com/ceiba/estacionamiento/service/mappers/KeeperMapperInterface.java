package co.com.ceiba.estacionamiento.service.mappers;

import java.util.List;

import co.com.ceiba.estacionamiento.persistence.entities.Keeper;
import co.com.ceiba.estacionamiento.service.dtos.KeeperDto;

/**
 * 
 * @author roger.cordoba
 */
public interface KeeperMapperInterface {
	/**
	 * Method that convert this dto object in entity object
	 * 
	 * @return this object in entity form
	 */
	Keeper dtoToEntity(KeeperDto dto);

	/**
	 * Method that convert entity object in dto object
	 * 
	 * @param type, is entity object to covert
	 * @return dto object converted
	 */
	KeeperDto entityToDto(Keeper entity);

	/**
	 * Method to convert list of entity object in list of dto object
	 * 
	 * @param lista, list of entity object to convert
	 * @return the list of dtos objects converted
	 */
	List<KeeperDto> listEntitiesToDtos(List<Keeper> list);
}
