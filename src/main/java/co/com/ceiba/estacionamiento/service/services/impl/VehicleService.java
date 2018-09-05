package co.com.ceiba.estacionamiento.service.services.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;
import co.com.ceiba.estacionamiento.persistence.repositories.VehicleRepository;
import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.mappers.VehicleMapperInterface;
import co.com.ceiba.estacionamiento.service.services.VehicleServiceInterface;
import co.com.ceiba.estacionamiento.utilities.Constants;
import co.com.ceiba.estacionamiento.utilities.exceptions.AnExceptionHandler;
import co.com.ceiba.estacionamiento.utilities.exceptions.CreateVehicleException;

/**
 * 
 * @author roger.cordoba
 */
@Service
@Transactional
public class VehicleService implements VehicleServiceInterface {

	@Autowired
	private VehicleRepository repository;
	@Autowired
	private VehicleMapperInterface mapper;

	@Override
	public Iterable<VehicleDto> getAllVehicles() {
		return this.mapper.listEntitiesToDtos(this.repository.findByRegistrationActive(true));
	}

	@Override
	public VehicleDto searchById(Long id) {
		if (id == null) {
			return new VehicleDto();
		}

		Optional<Vehicle> vehicle = this.repository.findById(id);
		if (vehicle.isPresent()) {
			return this.mapper.entityToDto(vehicle.get());
		} else {
			return new VehicleDto();
		}
	}

	@Override
	public VehicleDto saveVehicle(VehicleDto vehicle) throws AnExceptionHandler {
		if (vehicle == null) {
			return new VehicleDto();
		}

		if (vehicle.getId() == null) {
			Optional<Vehicle> vehicleOpt = this.repository.findByRegistrationActiveAndPlateIgnoreCase(true,
					vehicle.getPlate().trim());
			if (vehicleOpt.isPresent()) {
				throw new CreateVehicleException(Constants.MESSAGE_ERROR_CREATE_VEHICLE_PLATE_DUPLICATED);
			}

			vehicle.setCylinderGreaterThan500((vehicle.getCylinder() == null) ? vehicle.getCylinderGreaterThan500()
					: (vehicle.getCylinder() > Constants.CYLINDER_MAX_MOTOCYCLES));

			vehicle.setRegistrationActive(true);
			vehicle.setRegistrationDate(Calendar.getInstance());
		}

		Vehicle entity = this.repository.save(this.mapper.dtoToEntity(vehicle));

		return this.mapper.entityToDto(entity);
	}

	@Override
	public VehicleDto deleteVehicle(VehicleDto vehicle) {
		if (vehicle == null) {
			return new VehicleDto();
		}

		vehicle.setRegistrationActive(false);

		Vehicle entity = this.repository.save(this.mapper.dtoToEntity(vehicle));

		return this.mapper.entityToDto(entity);
	}

	@Override
	public VehicleDto searchByPlate(String plate) {
		Optional<Vehicle> vehicle = this.repository.findByRegistrationActiveAndPlateIgnoreCase(true,
				plate.toLowerCase().trim());
		if (vehicle.isPresent()) {
			return this.mapper.entityToDto(vehicle.get());
		} else {
			return new VehicleDto();
		}
	}

	@Override
	public List<VehicleDto> searchAllByPlate(String plate) {
		return this.mapper.listEntitiesToDtos(
				this.repository.findByRegistrationActiveAndPlateIgnoreCaseStartingWith(true, plate));
	}
}
