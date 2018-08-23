package co.com.ceiba.estacionamiento.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidationsTest {

	@Test
	public void testDoesThePlateStartWithTheLetter() {
		assertTrue(Validations.doesThePlateStartWithTheLetter('a', "abc123"));
		assertFalse(Validations.doesThePlateStartWithTheLetter('a', "bcd123"));
	}

}
