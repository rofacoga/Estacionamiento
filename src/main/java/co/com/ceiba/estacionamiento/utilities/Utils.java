package co.com.ceiba.estacionamiento.utilities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

public class Utils {

	private Utils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 
	 * @param costDayParking
	 * @param costHourParking
	 * @param totalHoursParking
	 * @return {@link BigInteger}
	 */
	public static BigInteger calculateTotalCostParking(Double costDayParking, Double costHourParking,
			Double totalHoursParking) {
		BigInteger totalCostDays = BigInteger.ZERO;
		BigInteger totalCostHours = BigInteger.ZERO;
		BigDecimal hoursToCollect = BigDecimal.ZERO;

		BigDecimal days = BigDecimal.valueOf(totalHoursParking / Constants.HOURS_OF_THE_DAY);
		Long integerPart = days.longValue();
		BigDecimal decimalPart = days.remainder(BigDecimal.ONE);

		if (decimalPart.compareTo(BigDecimal.valueOf(Constants.PERCENT_OF_NINE_HOURS_IN_A_DAY)) < 0) {

			hoursToCollect = BigDecimal.valueOf(decimalPart.doubleValue() * Constants.HOURS_OF_THE_DAY);

			BigDecimal decimalPartHour = hoursToCollect.remainder(BigDecimal.ONE);

			hoursToCollect = (decimalPartHour
					.compareTo(BigDecimal.valueOf(Constants.PERCENT_OF_ONE_HOUR_TOLERANCE_MINUTES)) < 0)
							? BigDecimal.valueOf(Math.floor(hoursToCollect.doubleValue()))
							: BigDecimal.valueOf(Math.ceil(hoursToCollect.doubleValue()));
			if (hoursToCollect.intValue() > 8) {
				hoursToCollect = BigDecimal.ZERO;
				integerPart++;
			}

		} else {
			integerPart++;
		}

		totalCostDays 	= BigInteger.valueOf(integerPart).multiply(BigDecimal.valueOf(costDayParking).toBigInteger());
		totalCostHours 	= hoursToCollect.multiply(BigDecimal.valueOf(costHourParking)).toBigInteger();

		return totalCostDays.add(totalCostHours);
	}

	/**
	 * 
	 * @param ini
	 * @param end
	 * @return
	 */
	public static Double calculateTotalHoursParking(Calendar ini, Calendar end) {
		return (double) (calculateMinutesBetweenTwoCalendar(ini, end) / Constants.MINUTES_OF_A_HOUR);
	}

	/**
	 * Calendar calendar1 = Calendar.getInstance(); Calendar calendar2 =
	 * Calendar.getInstance(); calendar1.set(2012, 04, 02); calendar2.set(2012, 04,
	 * 04); long milsecs1= calendar1.getTimeInMillis(); long milsecs2 =
	 * calendar2.getTimeInMillis(); long diff = milsecs2 - milsecs1; long dsecs =
	 * diff / 1000; long dminutes = diff / (60 * 1000); long dhours = diff / (60 *
	 * 60 * 1000); long ddays = diff / (24 * 60 * 60 * 1000);
	 * 
	 * System.out.println("Your Day Difference="+ddays);
	 * 
	 * @see more in: {@link https://code.i-harness.com/es/q/17bb3e}
	 *
	 * @param ini
	 * @param end
	 * @return
	 */
	public static Integer calculateMinutesBetweenTwoCalendar(Calendar ini, Calendar end) {
		long milsecs1 = ini.getTimeInMillis();
		long milsecs2 = end.getTimeInMillis();
		long diff = milsecs2 - milsecs1;
		long dminutes = diff / Constants.MILLISECONDS_OF_A_MINUTE;

		return (int) dminutes;
	}
}