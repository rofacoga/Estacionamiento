package co.com.ceiba.estacionamiento.services.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;
import co.com.ceiba.estacionamiento.persistence.repositories.VehicleRepository;
import co.com.ceiba.estacionamiento.services.VehicleServiceInterface;

/**
 * 
 * @author roger.cordoba
 */
@Service
public class VehicleService implements VehicleServiceInterface {

	@Autowired
	private VehicleRepository repository;

	@Override
	public Iterable<Vehicle> getAllVehicles() {
		return this.repository.findByRegistrationActive(true);
	}

	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		if (vehicle == null) return new Vehicle();

		if (vehicle.getId() == null) {
			vehicle.setRegistrationActive(true);
			vehicle.setRegistrationDate(Calendar.getInstance());
		}

		return this.repository.save(vehicle);
	}

	@Override
	public Vehicle deleteVehicle(Vehicle vehicle) {
		vehicle.setRegistrationActive(false);

		return this.repository.save(vehicle);
	}

	@Override
	public Vehicle searchByPlate(String plate) {
		return this.repository.findByRegistrationActiveAndPlate(true, plate);
	}

	@Override
	public List<Vehicle> searchAllByPlate(String plate) {
		return this.repository.findByRegistrationActiveAndPlateStartingWith(true, plate);
	}
}
