package co.com.ceiba.estacionamiento.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.ceiba.estacionamiento.utilities.Validations;

public class ValidationsTest {

	@Test
	public void testDoesThePlateStartWithTheLetter() {
		assertTrue(Validations.doesThePlateStartWithTheLetter('a', "abc123"));
		assertFalse(Validations.doesThePlateStartWithTheLetter('a', "bcd123"));
	}

}
