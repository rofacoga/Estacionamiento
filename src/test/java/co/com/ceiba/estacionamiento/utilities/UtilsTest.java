package co.com.ceiba.estacionamiento.utilities;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testCalculateTotalCostParking() {
		assertEquals(BigInteger.valueOf(500), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 0.93)[0]);
		assertEquals(BigInteger.valueOf(3500), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 7.0)[0]);
		assertEquals(BigInteger.valueOf(4000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 23.0)[0]);

		assertEquals(BigInteger.valueOf(4500), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 24.5)[0]);
		assertEquals(BigInteger.valueOf(4000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 24.08)[0]);
		assertEquals(BigInteger.valueOf(6000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 28.0)[0]);
		assertEquals(BigInteger.valueOf(8000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 32.0)[0]);

		assertEquals(BigInteger.valueOf(8000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 32.1)[0]);
		assertEquals(BigInteger.valueOf(8000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 33.0)[0]);
		assertEquals(BigInteger.valueOf(8000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 47.0)[0]);
		assertEquals(BigInteger.valueOf(8000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 48.0)[0]);

		assertEquals(BigInteger.valueOf(8500), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES,
				Constants.COST_HOUR_MOTORCYCLES, 48.1)[0]);
	}

	@Test
	public void testCalculateTotalHoursParking() {
		assertEquals(Double.valueOf(0.5),
				Utils.calculateTotalHoursParking(new GregorianCalendar(2010, Calendar.MAY, 22, 22, 11, 55),
						new GregorianCalendar(2010, Calendar.MAY, 22, 22, 41, 55)));
	}

	@Test
	public void testCalculateMinutesBetweenTwoCalendar() {
		assertEquals(Double.valueOf(50),
				Utils.calculateMinutesBetweenTwoCalendar(new GregorianCalendar(2010, Calendar.MAY, 22, 22, 11, 0),
						new GregorianCalendar(2010, Calendar.MAY, 22, 23, 1, 01)));
		assertEquals(Double.valueOf(30),
				Utils.calculateMinutesBetweenTwoCalendar(new GregorianCalendar(2010, Calendar.MAY, 22, 22, 11, 55),
						new GregorianCalendar(2010, Calendar.MAY, 22, 22, 41, 55)));
	}
}
