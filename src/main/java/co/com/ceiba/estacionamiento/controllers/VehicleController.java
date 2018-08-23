package co.com.ceiba.estacionamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.services.impl.VehicleService;

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
	public ResponseEntity<List<VehicleDto>> getVehicles() {
		return new ResponseEntity(this.vehicleService.getAllVehicles(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createVehicle")
	public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicle) {
		try {
			return new ResponseEntity(this.vehicleService.saveVehicle(vehicle), HttpStatus.OK);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
