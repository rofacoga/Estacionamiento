package co.com.ceiba.estacionamiento.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.services.VehicleServiceInterface;
import co.com.ceiba.estacionamiento.utilities.Constants;
import co.com.ceiba.estacionamiento.utilities.VehicleTypeEnum;
import co.com.ceiba.estacionamiento.utilities.exceptions.AnExceptionHandler;

@Transactional
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class VehicleServiceTest {
	@Autowired
	VehicleServiceInterface service;

	private Long idType;

	@Test
	@Rollback
	public void testSaveVehicle() throws AnExceptionHandler {
		VehicleDto vehicle = new VehicleDto();
		vehicle.setPlate("abc123");
		vehicle.setType(VehicleTypeEnum.MOTORCYCLE);
		vehicle.setCylinder(600);
		vehicle=this.service.saveVehicle(vehicle);

		assertNotNull("Verify that object have an id", vehicle.getId());
		this.idType = vehicle.getId();

		vehicle=this.service.saveVehicle(null);
		assertNull("Verify that object have an id", vehicle.getId());
	}

	@Test
	@Rollback
	public void testSearchByPlate() throws AnExceptionHandler {
		VehicleDto type = this.service.searchByPlate("abc123");
		assertNull("Verify that object not have an id", type.getId());

		this.testSaveVehicle();
		type = this.service.searchByPlate("abc123");
		assertNotNull("Verify that object have an id", type.getId());
	}

	@Test
	@Rollback
	public void testGetAllVehicle() throws AnExceptionHandler {
		int size = ((Collection<?>) this.service.getAllVehicles()).size();
		assertEquals("Verify that list not have elements", 0, size);

		this.testSaveVehicle();
		size = ((Collection<?>) this.service.getAllVehicles()).size();
		assertTrue("Verify that the list has some element", size > 0);
	}

	@Test
	@Rollback
	public void testDeleteVehicle() throws AnExceptionHandler {
		this.testSaveVehicle();
		VehicleDto type = this.service.searchById(this.idType);

		this.service.deleteVehicle(type);
		int size = ((Collection<?>) this.service.getAllVehicles()).size();
		assertEquals("Verify that list not have elements", 0, size);
	}

	@Test
	@Rollback
	public void testSearchById() throws AnExceptionHandler {
		VehicleDto type = this.service.searchById(null);
		assertNull("Verify that object have an id", type.getId());

		type = this.service.searchById(Long.valueOf(0));
		assertNull("Verify that object have an id", type.getId());

		this.testSaveVehicle();
		type = this.service.searchById(this.idType);
		assertNotNull("Verify that object have an id", type.getId());
	}

	@Test
	@Rollback
	public void testValidationPlateDuplicated() {
		try {
			this.testSaveVehicle();
			this.testSaveVehicle();
		} catch (AnExceptionHandler e) {
			assertEquals(Constants.MESSAGE_ERROR_CREATE_VEHICLE_PLATE_DUPLICATED, e.getMessage());
		}
	}

	@Test
	@Rollback
	public void testSearchAllByPlate() throws AnExceptionHandler {
		int size = ((Collection<?>) this.service.searchAllByPlate("a")).size();
		assertEquals("Verify that list not have elements", 0, size);

		this.testSaveVehicle();
		size = ((Collection<?>) this.service.searchAllByPlate("a")).size();
		assertTrue("Verify that the list has some element", size > 0);
		
	}

}
