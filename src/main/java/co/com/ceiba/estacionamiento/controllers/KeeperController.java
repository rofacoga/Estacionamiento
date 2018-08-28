package co.com.ceiba.estacionamiento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.service.dtos.KeeperDto;
import co.com.ceiba.estacionamiento.service.dtos.ParkingRecordDto;
import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.services.KeeperServiceInterface;
import co.com.ceiba.estacionamiento.service.services.ParkingRecordServiceInterface;
import co.com.ceiba.estacionamiento.service.services.VehicleServiceInterface;
import co.com.ceiba.estacionamiento.utilities.exceptions.DateCheckInIsAfterThanDateCheckOutException;
import co.com.ceiba.estacionamiento.utilities.exceptions.DayToEvaluateInvalidException;
import co.com.ceiba.estacionamiento.utilities.exceptions.ParkingExceedsTheAllowedCapacityException;
import co.com.ceiba.estacionamiento.utilities.exceptions.RegistrationOfParkedVehicleNotFoundException;
import co.com.ceiba.estacionamiento.utilities.exceptions.RequiredFieldIsEmptyException;
import co.com.ceiba.estacionamiento.utilities.exceptions.ThePlateIsAlreadyRegisteredException;
import co.com.ceiba.estacionamiento.utilities.exceptions.ThePlateStartWithTheLetterException;

/**
 * 
 * @author roger.cordoba
 */
@RestController
@RequestMapping("keeper")
public class KeeperController {
	@Autowired
	private KeeperServiceInterface keeperService;
	@Autowired
	private ParkingRecordServiceInterface recordService;
	@Autowired
	private VehicleServiceInterface vehicleService;

	/**
	 * 
	 * @param record
	 * @return
	 * 
	 * @throws ThePlateIsAlreadyRegisteredException
	 * @throws DayToEvaluateInvalidException
	 * @throws ThePlateStartWithTheLetterException
	 * @throws ParkingExceedsTheAllowedCapacityException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/checkIn")
	public ResponseEntity<Object> checkIn(@RequestBody ParkingRecordDto record)
			throws ThePlateIsAlreadyRegisteredException, ThePlateStartWithTheLetterException,
			DayToEvaluateInvalidException, ParkingExceedsTheAllowedCapacityException {
		VehicleDto vehicle = this.vehicleService.searchByPlate(record.getVehicle().getPlate());

		if (vehicle.getId() == null) {
			vehicle = this.vehicleService.saveVehicle(record.getVehicle());
		}

		record.setVehicle(vehicle);
		return new ResponseEntity<>(this.recordService.saveCheckIn(record), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/checkOut")
	public ResponseEntity<Object> checkOut(@RequestBody ParkingRecordDto record)
			throws DateCheckInIsAfterThanDateCheckOutException, RegistrationOfParkedVehicleNotFoundException,
			RequiredFieldIsEmptyException {
		return new ResponseEntity<>(this.recordService.saveCheckOut(record), HttpStatus.OK);
	}

	@RequestMapping(value = "/allParkedVehicles")
	public ResponseEntity<Object> allParkedVehicles() {
		return new ResponseEntity<>(this.recordService.getAllParkedVehicles(), HttpStatus.OK);
	}

	@RequestMapping(value = "/parkedVehiclesHistory")
	public ResponseEntity<Object> allRecords() {
		return new ResponseEntity<>(this.recordService.getAllRecords(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/saveKeeper")
	public ResponseEntity<Object> createVehicle(@RequestBody KeeperDto keeper) {
		return new ResponseEntity<>(this.keeperService.saveKeeper(keeper), HttpStatus.OK);
	}
}
