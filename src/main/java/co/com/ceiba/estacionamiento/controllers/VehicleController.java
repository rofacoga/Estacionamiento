package co.com.ceiba.estacionamiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.services.impl.VehicleService;
import co.com.ceiba.estacionamiento.utilities.VehicleTypeEnum;

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
	public ResponseEntity<Object> getVehicles() {
		return new ResponseEntity<>(this.vehicleService.getAllVehicles(), HttpStatus.OK);
	}

	@RequestMapping("/allTypesVehicles")
	public ResponseEntity<VehicleTypeEnum[]> getPeople() {
		return new ResponseEntity<>(VehicleTypeEnum.values(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createVehicle")
	public ResponseEntity<Object> createVehicle(@RequestBody VehicleDto vehicle) {
		return new ResponseEntity<>(this.vehicleService.saveVehicle(vehicle), HttpStatus.OK);
	}
}
