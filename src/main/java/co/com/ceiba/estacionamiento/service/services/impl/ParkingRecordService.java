package co.com.ceiba.estacionamiento.service.services.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.persistence.entities.ParkingRecord;
import co.com.ceiba.estacionamiento.persistence.repositories.ParkingRecordRepository;
import co.com.ceiba.estacionamiento.service.dtos.ParkingRecordDto;
import co.com.ceiba.estacionamiento.service.services.ParkingRecordServiceInterface;
import co.com.ceiba.estacionamiento.utilities.Constants;
import co.com.ceiba.estacionamiento.utilities.Utils;
import co.com.ceiba.estacionamiento.utilities.Validations;
import co.com.ceiba.estacionamiento.utilities.VehicleTypeEnum;
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
@Service
@Transactional
public class ParkingRecordService implements ParkingRecordServiceInterface {

	@Autowired
	private ParkingRecordRepository repository;

	@Override
	public ParkingRecordDto saveCheckIn(ParkingRecordDto record) throws DayToEvaluateInvalidException,
			ThePlateStartWithTheLetterException, ThePlateIsAlreadyRegisteredException, ParkingExceedsTheAllowedCapacityException {

		this.validateCheckInRecord(record);

		if (record.getId() == null) {
			record.setRegistrationActive(true);
			record.setRegistrationDate(Calendar.getInstance());
		}

		ParkingRecord entity = this.repository.save(record.dtoToEntity());

		return record.entityToDto(entity);
	}

	@Override
	public ParkingRecordDto saveCheckOut(ParkingRecordDto record) throws DateCheckInIsAfterThanDateCheckOutException,
			RegistrationOfParkedVehicleNotFoundException, RequiredFieldIsEmptyException {

		Calendar checkOut = record.getCheckOut();
		Long keeperOut = record.getKeeperOut();

		record = this.searchById(record.getId());
		record.setCheckOut(checkOut);
		record.setKeeperOut(keeperOut);
		this.validateCheckOutRecord(record);

		// true = Constants.NAME_MOTORCYCLE, false = Constants.NAME_MOTORCYCLE.
		Boolean isMotorcycle = (record.getVehicle().getType().equals(VehicleTypeEnum.MOTORCYCLE));

		Double totalHoursParking = Utils.calculateTotalHoursParking(record.getCheckIn(), record.getCheckOut());
		Double costPerHourParking = (isMotorcycle) ? Constants.COST_HOUR_MOTORCYCLES : Constants.COST_HOUR_CARS;
		Double costPerDayParking = (isMotorcycle) ? Constants.COST_DAY_MOTORCYCLES : Constants.COST_DAY_CARS;

		BigInteger[] res = Utils.calculateTotalCostParking(costPerDayParking, costPerHourParking, totalHoursParking);

		if (isMotorcycle) {
			res[0] = (record.getVehicle().isCylinderGreaterThan500())
					? res[0].add(BigDecimal.valueOf(Constants.COST_SURCHARGE_MOTORCYCLES).toBigInteger())
					: res[0];
		}

		record.setTotalCost(res[0]);
		record.setTotalDays(res[1].intValue());
		record.setTotalHours(res[2].intValue());

		ParkingRecord entity = this.repository.save(record.dtoToEntity());

		return record.entityToDto(entity);
	}

	@Override
	public ParkingRecordDto searchById(Long id) {
		Optional<ParkingRecord> record = this.repository.findById(id);

		if (record.isPresent()) {
			return new ParkingRecordDto().entityToDto(record.get());
		} else {
			return new ParkingRecordDto();
		}
	}

	@Override
	public ParkingRecordDto searchByPlate(String plate) {
		Optional<ParkingRecord> record = this.repository
				.findByRegistrationActiveAndVehiclePlateIgnoreCaseAndCheckOutIsNull(true, plate);

		if (record.isPresent()) {
			return new ParkingRecordDto().entityToDto(record.get());
		} else {
			return new ParkingRecordDto();
		}
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
	public Iterable<ParkingRecordDto> getAllParkedVehicles() {
		return new ParkingRecordDto()
				.listEntitiesToDtos(this.repository.findByRegistrationActiveAndCheckOutIsNull(true));
	}

	/**
	 * 
	 * 
	 * @param record
	 * 
	 * @throws DayToEvaluateInvalidException
	 * @throws ThePlateStartWithTheLetterException
	 * @throws ThePlateIsAlreadyRegisteredException
	 * @throws ParkingExceedsTheAllowedCapacityException 
	 */
	private void validateCheckInRecord(ParkingRecordDto record) throws DayToEvaluateInvalidException,
			ThePlateStartWithTheLetterException, ThePlateIsAlreadyRegisteredException, ParkingExceedsTheAllowedCapacityException {

		if (!(Validations.doesThePlateStartWithTheLetter('a', record.getVehicle().getPlate())
				&& (Validations.isTheCalendarDayTheDayOfTheWeek(record.getCheckIn(), Calendar.SUNDAY)
						|| Validations.isTheCalendarDayTheDayOfTheWeek(record.getCheckIn(), Calendar.MONDAY)))) {

			throw new ThePlateStartWithTheLetterException(
					"The license plate of the vehicle begins with the letter A, and can only enter the parking lot on Sundays and Mondays!");
		}

		int amountAtTheTime = (int) this.repository.countByRegistrationActiveAndVehicleTypeAndCheckOutIsNull(true,
				record.getVehicle().getType());
		int allowedAmount = (record.getVehicle().getType() == VehicleTypeEnum.MOTORCYCLE)
				? Constants.CANT_MAX_MOTORCYCLES
				: Constants.CANT_MAX_CARS;
		if (amountAtTheTime >= allowedAmount) {
			throw new ParkingExceedsTheAllowedCapacityException("The parking lot is full! The "+allowedAmount+" quotas have already been occupied");
		}

		Optional<ParkingRecord> recordOpt = this.repository
				.findByRegistrationActiveAndVehiclePlateIgnoreCaseAndCheckOutIsNull(true,
						record.getVehicle().getPlate());

		if (recordOpt.isPresent()) {
			throw new ThePlateIsAlreadyRegisteredException(
					"The license plate of the vehicle is already registered in the parking lot!");
		}

	}

	/**
	 * 
	 * 
	 * @param record
	 * 
	 * @throws RequiredFieldIsEmptyException
	 * @throws DateCheckInIsAfterThanDateCheckOutException
	 * @throws RegistrationOfParkedVehicleNotFoundException
	 */
	private void validateCheckOutRecord(ParkingRecordDto record) throws RequiredFieldIsEmptyException,
			DateCheckInIsAfterThanDateCheckOutException, RegistrationOfParkedVehicleNotFoundException {

		if (record.getCheckOut() == null) {
			throw new RequiredFieldIsEmptyException("The Calendar Check Out field is Empty!");
		}

		if (record.getCheckOut().before(record.getCheckIn())) {
			throw new DateCheckInIsAfterThanDateCheckOutException(
					"The Calendar Out Date is before of Calendar In Date!");
		}

		ParkingRecordDto recordDto = this.searchByPlate(record.getVehicle().getPlate());

		if (recordDto.getId() == null) {
			throw new RegistrationOfParkedVehicleNotFoundException("The vehicle with license plate: "
					+ record.getVehicle().getPlate().toUpperCase() + ", not found in the parking lot!");
		}

	}
}
