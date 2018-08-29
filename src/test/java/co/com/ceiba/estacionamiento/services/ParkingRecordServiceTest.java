package co.com.ceiba.estacionamiento.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.service.dtos.ParkingRecordDto;
import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.services.ParkingRecordServiceInterface;
import co.com.ceiba.estacionamiento.utilities.Constants;
import co.com.ceiba.estacionamiento.utilities.VehicleTypeEnum;
import co.com.ceiba.estacionamiento.utilities.exceptions.AnExceptionHandler;

@Transactional
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ParkingRecordServiceTest {
	@Autowired
	ParkingRecordServiceInterface service;

	private Long 	idObject;
	private String 	plateObject = "abc123";

	@Test
	@Rollback
	public void testSaveCheckInCar() throws AnExceptionHandler {
		VehicleDto vehicle = new VehicleDto();
		vehicle.setType(VehicleTypeEnum.CAR);
		vehicle.setPlate(this.plateObject);
		vehicle.setCylinder(1300);

		ParkingRecordDto object = new ParkingRecordDto();
		object.setCheckIn(new GregorianCalendar(2018, Calendar.AUGUST, 27, 07, 05, 30));
		object.setKeeperIn(Long.valueOf(1));
		object.setVehicle(vehicle);
		
		object = this.service.saveCheckIn(object);

		assertNotNull("Verify that object have an id", object.getId());
		this.idObject = object.getId();

		object = this.service.saveCheckIn(null);
		assertNull("Verify that object have an id", object.getId());
	}

	@Test
	@Rollback
	public void testSaveCheckInMotorcycle600() throws AnExceptionHandler {
		VehicleDto vehicle = new VehicleDto();
		vehicle.setType(VehicleTypeEnum.MOTORCYCLE);
		vehicle.setPlate(this.plateObject);
		vehicle.setCylinder(600);

		ParkingRecordDto object = new ParkingRecordDto();
		object.setCheckIn(new GregorianCalendar(2018, Calendar.AUGUST, 27, 07, 05, 30));
		object.setKeeperIn(Long.valueOf(1));
		object.setVehicle(vehicle);
		
		object = this.service.saveCheckIn(object);

		assertNotNull("Verify that object have an id", object.getId());
		this.idObject = object.getId();

		object = this.service.saveCheckIn(null);
		assertNull("Verify that object have an id", object.getId());
	}

	@Test
	@Rollback
	public void testSaveCheckInMotorcycle125() throws AnExceptionHandler {
		VehicleDto vehicle = new VehicleDto();
		vehicle.setType(VehicleTypeEnum.MOTORCYCLE);
		vehicle.setPlate(this.plateObject);
		vehicle.setCylinder(125);

		ParkingRecordDto object = new ParkingRecordDto();
		object.setCheckIn(new GregorianCalendar(2018, Calendar.AUGUST, 27, 07, 05, 30));
		object.setKeeperIn(Long.valueOf(1));
		object.setVehicle(vehicle);
		
		object = this.service.saveCheckIn(object);

		assertNotNull("Verify that object have an id", object.getId());
		this.idObject = object.getId();

		object = this.service.saveCheckIn(null);
		assertNull("Verify that object have an id", object.getId());
	}

	@Test
	@Rollback
	public void testSaveCheckOutCar() {
		try {
			this.testSaveCheckInCar();
		} catch (AnExceptionHandler e1) {
			
		}
		ParkingRecordDto object = new ParkingRecordDto();
		object.setId(this.idObject);
		object.setKeeperOut(Long.valueOf(1));

		try {
			this.service.saveCheckOut(object);
		} catch (AnExceptionHandler e) {
			assertEquals(Constants.MESSAGE_ERROR_CHECK_OUT_FIELD_CALENDAR_NULL, e.getMessage());
		}

		try {
			object.setCheckOut(new GregorianCalendar(2018, Calendar.AUGUST, 26, 9, 10, 11));
			this.service.saveCheckOut(object);
		} catch (AnExceptionHandler e) {
			assertEquals(Constants.MESSAGE_ERROR_CHECK_OUT_CALENDAR_IS_BEFORE, e.getMessage());
		}

		try {
			object.setCheckOut(new GregorianCalendar(2018, Calendar.AUGUST, 27, 9, 10, 11));
			object = this.service.saveCheckOut(object);
			assertNotNull("Verify that object have an id", object.getId());

			this.service.saveCheckOut(object);
		} catch (AnExceptionHandler e) {
			assertEquals(Constants.MESSAGE_ERROR_CHECK_OUT_VEHICLE_NOT_FOUND_1 + this.plateObject.toUpperCase()
			+ Constants.MESSAGE_ERROR_CHECK_OUT_VEHICLE_NOT_FOUND_2, e.getMessage());
		}

		try {
			object = this.service.saveCheckOut(null);
			assertNull("Verify that object have an id", object.getId());
		} catch (AnExceptionHandler e) {
			
		}
	}

	@Test
	@Rollback
	public void testSaveCheckOutMotorcycle600() {
		try {
			this.testSaveCheckInMotorcycle600();
			ParkingRecordDto object = new ParkingRecordDto();
			object.setId(this.idObject);
			object.setKeeperOut(Long.valueOf(1));
			object.setCheckOut(new GregorianCalendar(2018, Calendar.AUGUST, 27, 9, 10, 11));
			object = this.service.saveCheckOut(object);
			assertNotNull("Verify that object have an id", object.getId());
		} catch (AnExceptionHandler e) {
			e.printStackTrace();
		}
	}

	@Test
	@Rollback
	public void testSaveCheckOutMotorcycle125() {
		try {
			this.testSaveCheckInMotorcycle125();
			ParkingRecordDto object = new ParkingRecordDto();
			object.setId(this.idObject);
			object.setKeeperOut(Long.valueOf(1));
			object.setCheckOut(new GregorianCalendar(2018, Calendar.AUGUST, 27, 9, 10, 11));
			object = this.service.saveCheckOut(object);
			assertNotNull("Verify that object have an id", object.getId());
		} catch (AnExceptionHandler e) {
			e.printStackTrace();
		}
	}

	@Test
	@Rollback
	public void testSearchById() throws AnExceptionHandler {
		ParkingRecordDto object = this.service.searchById(null);
		assertNull("Verify that object have an id", object.getId());

		object = this.service.searchById(Long.valueOf(0));
		assertNull("Verify that object have an id", object.getId());

		this.testSaveCheckInCar();
		object = this.service.searchById(this.idObject);
		assertNotNull("Verify that object have an id", object.getId());
	}

	@Test
	@Rollback
	public void testSearchByPlate() throws AnExceptionHandler {
		ParkingRecordDto object = this.service.searchByPlate(null);
		assertNull("Verify that object have an id", object.getId());

		object = this.service.searchByPlate(this.plateObject);
		assertNull("Verify that object have an id", object.getId());

		this.testSaveCheckInCar();
		object = this.service.searchByPlate(this.plateObject);
		assertNotNull("Verify that object have an id", object.getId());
	}

	@Test
	@Rollback
	public void testSearchAllVehiclesParkedByPlate() throws AnExceptionHandler {
		int size = ((Collection<?>) this.service.searchAllVehiclesParkedByPlate(null)).size();
		assertEquals("Verify that list not have elements", 0, size);

		size = ((Collection<?>) this.service.searchAllVehiclesParkedByPlate("a")).size();
		assertEquals("Verify that list not have elements", 0, size);

		this.testSaveCheckInCar();
		size = ((Collection<?>) this.service.searchAllVehiclesParkedByPlate("a")).size();
		assertTrue("Verify that the list has some element", size > 0);
	}

	@Test
	@Rollback
	public void testGetAllParkedVehicles() throws AnExceptionHandler {
		int size = ((Collection<?>) this.service.getAllParkedVehicles()).size();
		assertEquals("Verify that list not have elements", 0, size);

		this.testSaveCheckInCar();
		size = ((Collection<?>) this.service.getAllParkedVehicles()).size();
		assertTrue("Verify that the list has some element", size > 0);
	}

	@Test
	@Rollback
	public void testGetAllRecords() throws AnExceptionHandler {
		int size = ((Collection<?>) this.service.getAllRecords()).size();
		assertEquals("Verify that list not have elements", 0, size);

		this.testSaveCheckInCar();
		size = ((Collection<?>) this.service.getAllRecords()).size();
		assertTrue("Verify that the list has some element", size > 0);
	}

	@Test
	@Rollback
	public void testValidationPlateAreParked() {
		try {
			this.testSaveCheckInCar();
			this.testSaveCheckInCar();
		} catch (AnExceptionHandler e) {
			assertEquals(Constants.MESSAGE_ERROR_CHECK_IN_PLATE_REGISTERED, e.getMessage());
		}
	}

	@Test
	@Rollback
	public void testValidationPlateStartedWithA() {
		try {
			VehicleDto vehicle = new VehicleDto();
			vehicle.setType(VehicleTypeEnum.CAR);
			vehicle.setPlate(this.plateObject);
			vehicle.setCylinder(1300);

			ParkingRecordDto object = new ParkingRecordDto();
			object.setCheckIn(new GregorianCalendar(2018, Calendar.AUGUST, 30, 07, 05, 30));
			object.setKeeperIn(Long.valueOf(1));
			object.setVehicle(vehicle);
			
			object = this.service.saveCheckIn(object);
		} catch (AnExceptionHandler e) {
			assertEquals(Constants.MESSAGE_ERROR_CHECK_IN_PLATE_INVALID, e.getMessage());
		}
	}

	@Test
	@Rollback
	public void testValidationExceededParking() {
		try {
			this.plateObject = "abc10";
			this.testSaveCheckInMotorcycle600();
			this.plateObject = "abc11";
			this.testSaveCheckInMotorcycle600();
			this.plateObject = "abc12";
			this.testSaveCheckInMotorcycle600();
			this.plateObject = "abc13";
			this.testSaveCheckInMotorcycle600();
			this.plateObject = "abc14";
			this.testSaveCheckInMotorcycle600();
			this.plateObject = "abc15";
			this.testSaveCheckInMotorcycle600();
			this.plateObject = "abc16";
			this.testSaveCheckInMotorcycle600();
			this.plateObject = "abc17";
			this.testSaveCheckInMotorcycle600();
			this.plateObject = "abc18";
			this.testSaveCheckInMotorcycle600();
			this.plateObject = "abc19";
			this.testSaveCheckInMotorcycle600();
			this.plateObject = "abc20";
			this.testSaveCheckInMotorcycle600();
		} catch (AnExceptionHandler e) {
			assertEquals(Constants.MESSAGE_ERROR_CHECK_IN_FULL_CAPACITY_1
					+ 10 + Constants.MESSAGE_ERROR_CHECK_IN_FULL_CAPACITY_2, e.getMessage());
		}
	}
}
