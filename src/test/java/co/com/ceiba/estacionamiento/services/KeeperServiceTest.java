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

import co.com.ceiba.estacionamiento.service.dtos.KeeperDto;
import co.com.ceiba.estacionamiento.service.services.KeeperServiceInterface;
import co.com.ceiba.estacionamiento.utilities.Constants;
import co.com.ceiba.estacionamiento.utilities.exceptions.AnExceptionHandler;

@Transactional
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class KeeperServiceTest {
	@Autowired
	KeeperServiceInterface service;

	private Long idObject;

	@Test
	@Rollback
	public void testSave() {
		KeeperDto object = new KeeperDto();
		object.setDni("1234567890");
		object.setFirstName("jose");
		object.setLastName("Milan");
		object.setEmail("exa@domain.com");
		object.setMobileNumber("3216549870");
		object.setUsername("jm");
		object.setPassword("12jm");
		object=this.service.saveKeeper(object);

		assertNotNull("Verify that object have an id", object.getId());
		this.idObject = object.getId();

		object=this.service.saveKeeper(null);
		assertNull("Verify that object have an id", object.getId());
	}

	@Test
	@Rollback
	public void testDeleteById() {
		KeeperDto object = this.service.deleteKeeperById(null);
		assertNull(object.getId());

		object = this.service.deleteKeeperById(Long.valueOf(0));
		assertNull(object.getId());

		this.testSave();
		object = this.service.deleteKeeperById(this.idObject);
		assertNotNull(object.getId());
	}

	@Test
	@Rollback
	public void testDelete() {
		KeeperDto object = this.service.searchById(Long.valueOf(1));

		this.service.deleteKeeper(object);
		int size = ((Collection<?>) this.service.getAllKeepers()).size();
		assertEquals("Verify that list not have elements", 0, size);
	}

	@Test
	@Rollback
	public void testGetAll() {
		int size = ((Collection<?>) this.service.getAllKeepers()).size();
		assertTrue("Verify that the list has some element", size > 0);

		this.service.deleteKeeperById(Long.valueOf(1));
		size = ((Collection<?>) this.service.getAllKeepers()).size();
		assertEquals("Verify that list not have elements", 0, size);
	}

	@Test
	@Rollback
	public void testSearchById() {
		KeeperDto object = this.service.searchById(null);
		assertNull("Verify that object have an id", object.getId());

		object = this.service.searchById(Long.valueOf(0));
		assertNull("Verify that object have an id", object.getId());

		this.testSave();
		object = this.service.searchById(this.idObject);
		assertNotNull("Verify that object have an id", object.getId());
	}

	@Test
	@Rollback
	public void testLogin() {
		try {
			KeeperDto object = this.service.login("jd", "12345ceiba");
			assertNotNull(object.getId());

			this.service.login("jd", "12345.ceiba");
		} catch (AnExceptionHandler e) {
			assertEquals(Constants.MESSAGE_ERROR_LOGIN_INCORRECT_DATA, e.getMessage());
		}

		try {
			this.service.login(null, null);
		} catch (AnExceptionHandler e) {
			assertEquals(Constants.MESSAGE_ERROR_LOGIN_INCORRECT_DATA, e.getMessage());
		}
	}

}
