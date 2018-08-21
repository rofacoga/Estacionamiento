package co.com.ceiba.estacionamiento.services.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;
import co.com.ceiba.estacionamiento.persistence.repositories.VehicleRepository;
import co.com.ceiba.estacionamiento.services.VehicleServiceInterface;
import co.com.ceiba.estacionamiento.utils.StateEnum;

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
		return this.repository.findAll();
	}

	@Override
	public Vehicle createVehicle( Vehicle vehicle ) {
		vehicle.setRegistrationStatus( StateEnum.ACTIVE );
		vehicle.setRegistrationDate( Calendar.getInstance() );
		
		return this.repository.save( vehicle );
	}
}
