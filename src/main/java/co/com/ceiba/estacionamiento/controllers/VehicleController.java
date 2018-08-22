package co.com.ceiba.estacionamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;
import co.com.ceiba.estacionamiento.services.impl.VehicleService;

/**
 * 
 * @author roger.cordoba
 */
@RestController
@RequestMapping("vehicle")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;

	@RequestMapping("/allVehicles")
	public ResponseEntity<List<Vehicle>> getVehicles() {
		return new ResponseEntity(this.vehicleService.getAllVehicles(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createVehicle")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
		try {
			return new ResponseEntity(this.vehicleService.saveVehicle(vehicle), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.METHOD_FAILURE);
		}
	}
}
