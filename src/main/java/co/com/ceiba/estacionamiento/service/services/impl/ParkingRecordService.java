package co.com.ceiba.estacionamiento.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.estacionamiento.persistence.repositories.VehicleRepository;
import co.com.ceiba.estacionamiento.service.dtos.ParkingRecordDto;
import co.com.ceiba.estacionamiento.service.services.ParkingRecordServiceInterface;
import co.com.ceiba.estacionamiento.utils.Validations;
import co.com.ceiba.estacionamiento.utils.exceptions.ThePlateStartWithTheLetterException;

public class ParkingRecordService implements ParkingRecordServiceInterface {

	@Autowired
	private VehicleRepository repository;

	@Override
	public Iterable<ParkingRecordDto> getAllRecords() {
		// TODO Auto-generated method stub
		//return new VehicleDto().listEntitiesToDtos(this.repository.findByRegistrationActive(true));
		return null;
	}

	@Override
	public ParkingRecordDto saveCheckIn(ParkingRecordDto record) throws ThePlateStartWithTheLetterException {
		// TODO Auto-generated method stub
		if (Validations.doesThePlateStartWithTheLetter('a', record.getVehicle().getPlate())) {
			throw new ThePlateStartWithTheLetterException("");
		}
		return null;
	}

	@Override
	public ParkingRecordDto saveCheckOut(ParkingRecordDto record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParkingRecordDto searchByPlate(String plate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParkingRecordDto> searchAllByPlate(String plate) {
		// TODO Auto-generated method stub
		return null;
	}

}
