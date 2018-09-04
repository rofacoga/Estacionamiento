package co.com.ceiba.estacionamiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.services.VehicleServiceInterface;
import co.com.ceiba.estacionamiento.utilities.VehicleTypeEnum;
import co.com.ceiba.estacionamiento.utilities.exceptions.AnExceptionHandler;

/**
 * 
 * @author roger.cordoba
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping("vehicle")
public class VehicleController {
	@Autowired
	private VehicleServiceInterface vehicleService;

	@RequestMapping("/allVehicles")
	public ResponseEntity<Object> getAllVehicles() {
		return new ResponseEntity<>(this.vehicleService.getAllVehicles(), HttpStatus.OK);
	}

	@RequestMapping("/allTypesVehicles")
	public ResponseEntity<VehicleTypeEnum[]> getAllTypesVehicles() {
		return new ResponseEntity<>(VehicleTypeEnum.values(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveVehicle")
	public ResponseEntity<Object> saveVehicle(@RequestBody VehicleDto vehicle) throws AnExceptionHandler {
		return new ResponseEntity<>(this.vehicleService.saveVehicle(vehicle), HttpStatus.OK);
	}
}
