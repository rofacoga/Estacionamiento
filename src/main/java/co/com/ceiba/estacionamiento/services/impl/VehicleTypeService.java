package co.com.ceiba.estacionamiento.services.impl;

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
	
	public Iterable<VehicleType> getAllTypes() {
		return this.repository.findAll();
	}
}
