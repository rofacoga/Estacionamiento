package co.com.ceiba.estacionamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.persistence.entities.Vehicle;
import co.com.ceiba.estacionamiento.services.impl.VehicleService;

/**
 * 
 * @author roger.cordoba
 */
@RestController
@RequestMapping("api")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @RequestMapping("/allVehicles")
    @ResponseBody
    public ResponseEntity<List> getVehicles() {
        return new ResponseEntity( this.vehicleService.getAllVehicles(), HttpStatus.OK);
    }

    @RequestMapping("/createVehicle")
    @ResponseBody
    public void createVehicle( Vehicle vehicle ) {
    	try {
    		this.vehicleService.createVehicle( vehicle );
			return;
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}
