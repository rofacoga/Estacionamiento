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

import co.com.ceiba.estacionamiento.service.dtos.VehicleTypeDto;
import co.com.ceiba.estacionamiento.service.services.VehicleTypeServiceInterface;

@Transactional
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class VehicleTypeServiceTest {
	@Autowired
	VehicleTypeServiceInterface service;

	private Long idType;

	@Test
	@Rollback
	public void testSaveType() {
		VehicleTypeDto type = new VehicleTypeDto();
		type.setType("motocicleta");
		type=this.service.saveType(type);

		assertNotNull("Verify that object have an id", type.getId());
		this.idType = type.getId();
	}

	@Test
	@Rollback
	public void testSearchById() {
		VehicleTypeDto type = this.service.searchById(null);
		assertNull("Verify that object not have an id", type.getId());

		this.testSaveType();
		type = this.service.searchById(this.idType);
		assertNotNull("Verify that object have an id", type.getId());
	}

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

}
