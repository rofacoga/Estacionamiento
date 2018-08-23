package co.com.ceiba.estacionamiento.service.services.impl;

import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.persistence.entities.VehicleType;
import co.com.ceiba.estacionamiento.persistence.repositories.VehicleTypeRepository;
import co.com.ceiba.estacionamiento.service.dtos.VehicleTypeDto;
import co.com.ceiba.estacionamiento.service.services.VehicleTypeServiceInterface;

/**
 * 
 * @author roger.cordoba
 */
@Service
public class VehicleTypeService implements VehicleTypeServiceInterface {

	@Autowired
	private VehicleTypeRepository repository;

	@Override
	public Iterable<VehicleTypeDto> getAllTypes() {
		return new VehicleTypeDto().listEntitiesToDtos(this.repository.findByRegistrationActive(true));
	}

	@Override
	public VehicleTypeDto searchById(Long idType) {
		if (idType == null) {
			return new VehicleTypeDto();
		}

		Optional<VehicleType> type = this.repository.findById(idType);
		if (type.isPresent()) {
			return new VehicleTypeDto().entityToDto(type.get());
		}
		return new VehicleTypeDto();
	}

	@Override
	public VehicleTypeDto saveType(VehicleTypeDto type) {
		if (type == null || type.getType() == null || type.getType().trim().isEmpty()) {
			return new VehicleTypeDto();
		}

		if (type.getId() == null) {
			type.setRegistrationActive(true);
			type.setRegistrationDate(Calendar.getInstance());
		}
		type.setType(type.getType().trim().toLowerCase());

		VehicleType entity = this.repository.save(type.dtoToEntity());

		return type.entityToDto(entity);
	}

	@Override
	public VehicleTypeDto deleteType(VehicleTypeDto type) {
		type.setRegistrationActive(false);

		VehicleType entity = this.repository.save(type.dtoToEntity());

		return type.entityToDto(entity);
	}
}
