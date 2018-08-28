package co.com.ceiba.estacionamiento.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.estacionamiento.service.dtos.VehicleDto;
import co.com.ceiba.estacionamiento.service.services.VehicleServiceInterface;
import co.com.ceiba.estacionamiento.utilities.VehicleTypeEnum;

@Transactional
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class VehicleServiceTest {
	@Autowired
	VehicleServiceInterface service;

	private Long idType;

	@Test
	@Rollback
	public void testSaveVehicle() {
		VehicleDto type = new VehicleDto();
		
		type.setPlate("abc123");
		type.setType(VehicleTypeEnum.CAR);
		type=this.service.saveVehicle(type);

		assertNotNull("Verify that object have an id", type.getId());
		this.idType = type.getId();

		type=this.service.saveVehicle(null);
		assertNull("Verify that object have an id", type.getId());
	}

	@Test
	@Rollback
	public void testSearchByPlate() {
		VehicleDto type = this.service.searchById(null);
		assertNull("Verify that object not have an id", type.getId());

		this.testSaveVehicle();
		type = this.service.searchById(this.idType);
		assertNotNull("Verify that object have an id", type.getId());
	}

	/**
	@Test
	@Rollback
	public void testGetAllTypes() {
		int size = ((Collection<?>) this.service.getAllTypes()).size();
		assertEquals("Verify that list not have elements", 0, size);

		this.testSaveType();
		size = ((Collection<?>) this.service.getAllTypes()).size();
		assertTrue("Verify that the list has some element", size > 0);
	}

	@Test
	@Rollback
	public void testDeleteType() {
		this.testSaveType();
		VehicleTypeDto type = this.service.searchById(this.idType);

		this.service.deleteType(type);
		int size = ((Collection<?>) this.service.getAllTypes()).size();
		assertEquals("Verify that list not have elements", 0, size);
	}
	*/
}
