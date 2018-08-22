package co.com.ceiba.estacionamiento.services.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.persistence.entities.VehicleType;
import co.com.ceiba.estacionamiento.persistence.repositories.VehicleTypeRepository;
import co.com.ceiba.estacionamiento.services.VehicleTypeServiceInterface;

/**
 * 
 * @author roger.cordoba
 */
@Service
public class VehicleTypeService implements VehicleTypeServiceInterface {

	@Autowired
	private VehicleTypeRepository repository;

	@Override
	public Iterable<VehicleType> getAllTypes() {
		return this.repository.findAll();
	}

	@Override
	public VehicleType saveType(VehicleType type) {
		if (type == null) {
			return new VehicleType();
		}

		if (type.getId() == null) {
			type.setRegistrationActive(true);
			type.setRegistrationDate(Calendar.getInstance());
		}

		return this.repository.save(type);
	}

	@Override
	public VehicleType deleteType(VehicleType type) {
		type.setRegistrationActive(false);

		return this.repository.save(type);
	}
}
