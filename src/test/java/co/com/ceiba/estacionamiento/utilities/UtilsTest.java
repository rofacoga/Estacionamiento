package co.com.ceiba.estacionamiento.utilities;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testCalculateTotalCostParking() {
		assertEquals(BigInteger.valueOf(500), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES,  0.93)[0]);
		assertEquals(BigInteger.valueOf(3500), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES, 7.0)[0]);
		assertEquals(BigInteger.valueOf(4000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES, 23.0)[0]);

		assertEquals(BigInteger.valueOf(4500), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES, 24.5)[0]);
		assertEquals(BigInteger.valueOf(4000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES, 24.08)[0]);
		assertEquals(BigInteger.valueOf(6000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES, 28.0)[0]);
		assertEquals(BigInteger.valueOf(8000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES, 32.0)[0]);

		assertEquals(BigInteger.valueOf(8000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES, 32.1)[0]);
		assertEquals(BigInteger.valueOf(8000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES, 33.0)[0]);
		assertEquals(BigInteger.valueOf(8000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES, 47.0)[0]);
		assertEquals(BigInteger.valueOf(8000), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES, 48.0)[0]);

		assertEquals(BigInteger.valueOf(8500), Utils.calculateTotalCostParking(Constants.COST_DAY_MOTORCYCLES, Constants.COST_HOUR_MOTORCYCLES, 48.1)[0]);
	}

//	@Test
//	public void testCalculateTotalHoursParking() {
//		fail("Not yet implemented"); // TODO
//	}

//	@Test
//	public void testCalculateMinutesBetweenTwoCalendar() {
//		fail("Not yet implemented"); // TODO
//	}

}
