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

	private Long idObject;

	@Test
	@Rollback
	public void testSave() throws AnExceptionHandler {
		VehicleDto object = new VehicleDto();
		object.setPlate("abc123");
		object.setType(VehicleTypeEnum.MOTORCYCLE);
		object.setCylinder(600);
		object=this.service.saveVehicle(object);

		assertNotNull("Verify that object have an id", object.getId());
		this.idObject = object.getId();

		object=this.service.saveVehicle(null);
		assertNull("Verify that object have an id", object.getId());
	}

	@Test
	@Rollback
	public void testSave2() throws AnExceptionHandler {
		VehicleDto object = new VehicleDto();
		object.setPlate("abc124");
		object.setType(VehicleTypeEnum.MOTORCYCLE);
		object.setCylinderGreaterThan500(false);
		object=this.service.saveVehicle(object);

		assertNotNull("Verify that object have an id", object.getId());
		this.idObject = object.getId();

		object=this.service.saveVehicle(null);
		assertNull("Verify that object have an id", object.getId());
	}

	@Test
	@Rollback
	public void testSearchByPlate() throws AnExceptionHandler {
		VehicleDto type = this.service.searchByPlate("abc123");
		assertNull("Verify that object not have an id", type.getId());

		this.testSave();
		type = this.service.searchByPlate("abc123");
		assertNotNull("Verify that object have an id", type.getId());
	}

	@Test
	@Rollback
	public void testGetAll() throws AnExceptionHandler {
		int size = ((Collection<?>) this.service.getAllVehicles()).size();
		assertEquals("Verify that list not have elements", 0, size);

		this.testSave();
		size = ((Collection<?>) this.service.getAllVehicles()).size();
		assertTrue("Verify that the list has some element", size > 0);
	}

	@Test
	@Rollback
	public void testDelete() throws AnExceptionHandler {
		this.testSave();
		VehicleDto type = this.service.searchById(this.idObject);

		this.service.deleteVehicle(type);
		int size = ((Collection<?>) this.service.getAllVehicles()).size();
		assertEquals("Verify that list not have elements", 0, size);

		VehicleDto objectNull = this.service.deleteVehicle(null);
		assertNull(objectNull.getId());
	}

	@Test
	@Rollback
	public void testSearchById() throws AnExceptionHandler {
		VehicleDto type = this.service.searchById(null);
		assertNull("Verify that object have an id", type.getId());

		type = this.service.searchById(Long.valueOf(0));
		assertNull("Verify that object have an id", type.getId());

		this.testSave();
		type = this.service.searchById(this.idObject);
		assertNotNull("Verify that object have an id", type.getId());
	}

	@Test
	@Rollback
	public void testValidationPlateDuplicated() {
		try {
			this.testSave();
			this.testSave2();
		} catch (AnExceptionHandler e) {
			assertEquals(Constants.MESSAGE_ERROR_CREATE_VEHICLE_PLATE_DUPLICATED, e.getMessage());
		}
	}

	@Test
	@Rollback
	public void testSearchAllByPlate() throws AnExceptionHandler {
		int size = ((Collection<?>) this.service.searchAllByPlate("a")).size();
		assertEquals("Verify that list not have elements", 0, size);

		this.testSave();
		size = ((Collection<?>) this.service.searchAllByPlate("a")).size();
		assertTrue("Verify that the list has some element", size > 0);
		
	}

}
