package co.com.ceiba.estacionamiento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.services.VehicleTypeServiceInterface;
import co.com.ceiba.estacionamiento.services.impl.VehicleService;
import co.com.ceiba.estacionamiento.services.impl.VehicleTypeService;

/**
 * 
 * @author roger.cordoba
 */
@RestController
@RequestMapping("api")
public class VehicleTypeController {
    @Autowired
    private VehicleTypeServiceInterface typeService;

    @RequestMapping("/allTypes")
    @ResponseBody
    public ResponseEntity<List> getPeople() {
        return new ResponseEntity( typeService.getAllTypes(), HttpStatus.OK );
    }
}
