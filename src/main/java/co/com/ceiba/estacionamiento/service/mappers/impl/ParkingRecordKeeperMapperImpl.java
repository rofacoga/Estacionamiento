package co.com.ceiba.estacionamiento.service.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.persistence.entities.Keeper;
import co.com.ceiba.estacionamiento.persistence.entities.ParkingRecord;
import co.com.ceiba.estacionamiento.service.dtos.ParkingRecordDto;
import co.com.ceiba.estacionamiento.service.mappers.ParkingRecordMapperInterface;
import co.com.ceiba.estacionamiento.service.mappers.VehicleMapperInterface;

/**
 * 
 * @author roger.cordoba
 */
@Component
public class ParkingRecordKeeperMapperImpl implements ParkingRecordMapperInterface {
	@Autowired
	private VehicleMapperInterface vehicleMapper;

	@Override
	public ParkingRecord dtoToEntity(ParkingRecordDto dto) {
		ParkingRecord entity = new ParkingRecord();
		entity.setKeeperIn(new Keeper(dto.getKeeperIn()));
		entity.setKeeperOut((dto.getKeeperOut() == null) ? null : new Keeper(dto.getKeeperOut()));
		entity.setVehicle(this.vehicleMapper.dtoToEntity(dto.getVehicle()));
		entity.setCheckIn(dto.getCheckIn());
		entity.setCheckOut(dto.getCheckOut());
		entity.setTotalDays(dto.getTotalDays());
		entity.setTotalHours(dto.getTotalHours());
		entity.setTotalCost(dto.getTotalCost());
		entity.setId(dto.getId());
		entity.setRegistrationActive(dto.getRegistrationActive());
		entity.setRegistrationDate(dto.getRegistrationDate());

		return entity;
	}

	@Override
	public ParkingRecordDto entityToDto(ParkingRecord entity) {
		ParkingRecordDto dto = new ParkingRecordDto();
		dto.setKeeperIn(entity.getKeeperIn().getId());
		dto.setKeeperOut((entity.getKeeperOut() == null) ? null : entity.getKeeperOut().getId());
		dto.setVehicle(this.vehicleMapper.entityToDto(entity.getVehicle()));
		dto.setCheckIn(entity.getCheckIn());
		dto.setCheckOut(entity.getCheckOut());
		dto.setTotalDays(entity.getTotalDays());
		dto.setTotalHours(entity.getTotalHours());
		dto.setTotalCost(entity.getTotalCost());
		dto.setId(entity.getId());
		dto.setRegistrationActive(entity.getRegistrationActive());
		dto.setRegistrationDate(entity.getRegistrationDate());

		return dto;
	}

	@Override
	public List<ParkingRecordDto> listEntitiesToDtos(List<ParkingRecord> lista) {
		List<ParkingRecordDto> list = new ArrayList<>();
		for (ParkingRecord pr : lista) {
			list.add(this.entityToDto(pr));
		}
		return list;
	}
}
