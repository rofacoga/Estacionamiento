package co.com.ceiba.estacionamiento.service.services.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;
import co.com.ceiba.estacionamiento.persistence.repositories.VehicleRepository;
import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.services.VehicleServiceInterface;

/**
 * 
 * @author roger.cordoba
 */
@Service
public class VehicleService implements VehicleServiceInterface {

	@Autowired
	private VehicleRepository repository;

	@Override
	public Iterable<VehicleDto> getAllVehicles() {
		return new VehicleDto().listEntitiesToDtos(this.repository.findByRegistrationActive(true));
	}

	@Override
	public VehicleDto saveVehicle(VehicleDto vehicle) {
		if (vehicle == null) {
			return new VehicleDto();
		}

		if (vehicle.getId() == null) {
			vehicle.setRegistrationActive(true);
			vehicle.setRegistrationDate(Calendar.getInstance());
		}

		Vehicle entity = this.repository.save(vehicle.dtoToEntity());

		return vehicle.entityToDto(entity);
	}

	@Override
	public VehicleDto deleteVehicle(VehicleDto vehicle) {
		vehicle.setRegistrationActive(false);

		Vehicle entity = this.repository.save(vehicle.dtoToEntity());

		return vehicle.entityToDto(entity);
	}

	@Override
	public VehicleDto searchByPlate(String plate) {
		return new VehicleDto().entityToDto(this.repository.findByRegistrationActiveAndPlate(true, plate));
	}

	@Override
	public List<VehicleDto> searchAllByPlate(String plate) {
		return new VehicleDto().listEntitiesToDtos(this.repository.findByRegistrationActiveAndPlateStartingWith(true, plate));
	}
}
