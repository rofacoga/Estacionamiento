package co.com.ceiba.estacionamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.persistence.entities.VehicleType;
import co.com.ceiba.estacionamiento.services.VehicleTypeServiceInterface;

/**
 * 
 * @author roger.cordoba
 */
@RestController
@RequestMapping("vehicleType")
public class VehicleTypeController {
	@Autowired
	private VehicleTypeServiceInterface typeService;

	@RequestMapping("/allTypes")
	public ResponseEntity<List<VehicleType>> getPeople() {
		return new ResponseEntity(this.typeService.getAllTypes(), HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/createType")
	public ResponseEntity<VehicleType> createType(@RequestBody VehicleType type) {
		try {
			return new ResponseEntity(this.typeService.saveType(type), HttpStatus.OK);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
