package co.com.ceiba.estacionamiento.service.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;
import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.mappers.VehicleMapperInterface;

/**
 * 
 * @author roger.cordoba
 */
@Component
public class VehicleMapperImpl implements VehicleMapperInterface {

	@Override
	public Vehicle dtoToEntity(VehicleDto dto) {
		Vehicle entity = new Vehicle();
		entity.setType(dto.getType());
		entity.setPlate(dto.getPlate());
		entity.setCylinder(dto.getCylinder());
		entity.setCylinderGreaterThan500(dto.getCylinderGreaterThan500());
		entity.setId(dto.getId());
		entity.setRegistrationActive(dto.getRegistrationActive());
		entity.setRegistrationDate(dto.getRegistrationDate());

		return entity;
	}

	@Override
	public VehicleDto entityToDto(Vehicle entity) {
		VehicleDto dto = new VehicleDto();
		dto.setType(entity.getType());
		dto.setPlate(entity.getPlate());
		dto.setCylinder(entity.getCylinder());
		dto.setCylinderGreaterThan500(entity.getCylinderGreaterThan500());
		dto.setId(entity.getId());
		dto.setRegistrationActive(entity.getRegistrationActive());
		dto.setRegistrationDate(entity.getRegistrationDate());

		return dto;
	}

	@Override
	public List<VehicleDto> listEntitiesToDtos(List<Vehicle> lista) {
		List<VehicleDto> list = new ArrayList<>();
		for (Vehicle k : lista) {
			list.add(this.entityToDto(k));
		}
		return list;
	}

}
