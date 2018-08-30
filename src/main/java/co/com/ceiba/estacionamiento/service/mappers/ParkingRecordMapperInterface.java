package co.com.ceiba.estacionamiento.service.mappers;

import java.util.List;

import co.com.ceiba.estacionamiento.persistence.entities.ParkingRecord;
import co.com.ceiba.estacionamiento.service.dtos.ParkingRecordDto;

/**
 * 
 * @author roger.cordoba
 */
public interface ParkingRecordMapperInterface {
	/**
	 * Method that convert this dto object in entity object
	 * 
	 * @return this object in entity form
	 */
	ParkingRecord dtoToEntity(ParkingRecordDto dto);

	/**
	 * Method that convert entity object in dto object
	 * 
	 * @param type, is entity object to covert
	 * @return dto object converted
	 */
	ParkingRecordDto entityToDto(ParkingRecord entity);

	/**
	 * Method to convert list of entity object in list of dto object
	 * 
	 * @param lista, list of entity object to convert
	 * @return the list of dtos objects converted
	 */
	List<ParkingRecordDto> listEntitiesToDtos(List<ParkingRecord> list);
}
