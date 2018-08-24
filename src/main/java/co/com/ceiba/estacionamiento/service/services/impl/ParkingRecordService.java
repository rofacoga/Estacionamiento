package co.com.ceiba.estacionamiento.service.services.impl;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.estacionamiento.persistence.repositories.ParkingRecordRepository;
import co.com.ceiba.estacionamiento.service.dtos.ParkingRecordDto;
import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.services.ParkingRecordServiceInterface;
import co.com.ceiba.estacionamiento.utilities.Constants;
import co.com.ceiba.estacionamiento.utilities.Utils;
import co.com.ceiba.estacionamiento.utilities.Validations;
import co.com.ceiba.estacionamiento.utilities.exceptions.DateCheckInIsAfterThanDateCheckOutException;
import co.com.ceiba.estacionamiento.utilities.exceptions.DayToEvaluateInvalidException;
import co.com.ceiba.estacionamiento.utilities.exceptions.ThePlateStartWithTheLetterException;

public class ParkingRecordService implements ParkingRecordServiceInterface {

	@Autowired
	private ParkingRecordRepository repository;

	@Override
	public ParkingRecordDto saveCheckIn(ParkingRecordDto record)
			throws ThePlateStartWithTheLetterException, DayToEvaluateInvalidException {
		// TODO Auto-generated method stub
		if (Validations.doesThePlateStartWithTheLetter('a', record.getVehicle().getPlate())
				&& (Validations.isTheCalendarDayTheDayOfTheWeek(record.getCheckIn(), Calendar.SUNDAY)
						|| Validations.isTheCalendarDayTheDayOfTheWeek(record.getCheckIn(), Calendar.MONDAY))) {
			throw new ThePlateStartWithTheLetterException("");
		}
		return null;
	}

	@Override
	public ParkingRecordDto saveCheckOut(ParkingRecordDto record) throws DateCheckInIsAfterThanDateCheckOutException {
		if (record.getCheckOut().before(record.getCheckIn())) {
			throw new DateCheckInIsAfterThanDateCheckOutException("");
		}

		Double totalHoursParking = Utils.calculateTotalHoursParking(record.getCheckIn(), record.getCheckOut());
		Double costPerHourParking = (false) ? Constants.COST_HOUR_MOTORCYCLES : Constants.COST_HOUR_VEHICLES;
		Double costPerDayParking = (false) ? Constants.COST_HOUR_MOTORCYCLES : Constants.COST_HOUR_VEHICLES;
		BigInteger totalCostParking = Utils.calculateTotalCostParking(costPerDayParking, costPerHourParking,
				totalHoursParking);

		record.setTotalCost(totalCostParking);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParkingRecordDto searchByPlate(String plate) {
		return new ParkingRecordDto()
				.entityToDto(this.repository.findByRegistrationActiveAndVehiclePlateAndCheckOutIsNull(true, plate));
	}

	@Override
	public List<ParkingRecordDto> searchAllVehiclesParkedByPlate(String plate) {
		return new ParkingRecordDto().listEntitiesToDtos(
				this.repository.findByRegistrationActiveAndVehiclePlateStartingWithAndCheckOutIsNull(true, plate));
	}

	@Override
	public Iterable<ParkingRecordDto> getAllRecords() {
		return new ParkingRecordDto().listEntitiesToDtos(this.repository.findByRegistrationActive(true));
	}

	@Override
	public Iterable<ParkingRecordDto> getAllRecordsParked() {
		return new ParkingRecordDto()
				.listEntitiesToDtos(this.repository.findByRegistrationActiveAndCheckOutIsNull(true));
	}
}
