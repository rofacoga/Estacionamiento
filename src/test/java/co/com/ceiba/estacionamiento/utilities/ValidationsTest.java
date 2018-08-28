package co.com.ceiba.estacionamiento.utilities;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import co.com.ceiba.estacionamiento.utilities.Validations;
import co.com.ceiba.estacionamiento.utilities.exceptions.DayToEvaluateInvalidException;

public class ValidationsTest {

	@Test
	public void testDoesThePlateStartWithTheLetter() {
		assertTrue(Validations.doesThePlateStartWithTheLetter('a', "abc123"));
		assertFalse(Validations.doesThePlateStartWithTheLetter('a', "bcd123"));
	}

	@Test
	public void testIsTheCalendarDayTheDayOfTheWeek() {
		try {
			assertTrue(Validations.isTheCalendarDayTheDayOfTheWeek(
					new GregorianCalendar(1993, Calendar.MARCH, 30, 07, 55, 40), Calendar.TUESDAY));
			assertFalse(Validations.isTheCalendarDayTheDayOfTheWeek(
					new GregorianCalendar(2013, Calendar.MARCH, 30, 07, 55, 40), Calendar.TUESDAY));
			Validations.isTheCalendarDayTheDayOfTheWeek(new GregorianCalendar(2013, Calendar.MARCH, 30, 07, 55, 40),
					Calendar.ERA);

		} catch (DayToEvaluateInvalidException e) {
			assertEquals(Constants.MESSAGE_ERROR_DAY_NOT_VALID, e.getMessage());
		}
	}
}
