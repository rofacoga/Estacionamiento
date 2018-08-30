package co.com.ceiba.estacionamiento.service.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.persistence.entities.Keeper;
import co.com.ceiba.estacionamiento.service.dtos.KeeperDto;
import co.com.ceiba.estacionamiento.service.mappers.KeeperMapperInterface;

/**
 * 
 * @author roger.cordoba
 */
@Component
public class KeeperMapperImpl implements KeeperMapperInterface {

	@Override
	public Keeper dtoToEntity(KeeperDto dto) {
		Keeper entity = new Keeper();
		entity.setDni(dto.getDni());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setMobileNumber(dto.getMobileNumber());
		entity.setEmail(dto.getEmail());
		entity.setUsername(dto.getUsername());
		entity.setP4ssw0rd(dto.getP4ssw0rd());
		entity.setId(dto.getId());
		entity.setRegistrationActive(dto.getRegistrationActive());
		entity.setRegistrationDate(dto.getRegistrationDate());

		return entity;
	}

	@Override
	public KeeperDto entityToDto(Keeper entity) {
		KeeperDto dto = new KeeperDto();
		dto.setDni(entity.getDni());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setMobileNumber(entity.getMobileNumber());
		dto.setEmail(entity.getEmail());
		dto.setUsername(entity.getUsername());
		dto.setPassword(entity.getP4ssw0rd());
		dto.setId(entity.getId());
		dto.setRegistrationActive(entity.getRegistrationActive());
		dto.setRegistrationDate(entity.getRegistrationDate());

		return dto;
	}

	@Override
	public List<KeeperDto> listEntitiesToDtos(List<Keeper> lista) {
		List<KeeperDto> list = new ArrayList<>();
		for (Keeper k : lista) {
			list.add(this.entityToDto(k));
		}
		return list;
	}

}
