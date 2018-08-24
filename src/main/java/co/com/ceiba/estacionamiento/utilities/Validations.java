package co.com.ceiba.estacionamiento.utilities;

import java.util.Calendar;

import co.com.ceiba.estacionamiento.utilities.exceptions.DayToEvaluateInvalidException;

public final class Validations {
	/**
	 * 
	 */
	private Validations() {
		throw new IllegalStateException("Validations Utility class");
	}

	/**
	 * 
	 * 
	 * @param letter, to execute the validate
	 * @param plate, the plate to get the first letter
	 * @return true, in case to first letter of the plate is equal to the incoming
	 *         letter false, otherwise
	 */
	public static Boolean doesThePlateStartWithTheLetter(Character letter, String plate) {
		return (letter == plate.toLowerCase().charAt(0));
	}

	/**
	 * 
	 * @param calendar
	 * @param dayCalendarToEvaluate, possible options are: Calendar.SUNDAY, Calendar.MONDAY, etc.
	 * @return
	 * @throws DayToEvaluateInvalidException
	 */
	public static Boolean isTheCalendarDayTheDayOfTheWeek(Calendar calendar, int dayCalendarToEvaluate ) throws DayToEvaluateInvalidException {
		if (dayCalendarToEvaluate<1||dayCalendarToEvaluate>7) {
			throw new DayToEvaluateInvalidException("");
		}
		return (calendar.get(Calendar.DAY_OF_WEEK) == dayCalendarToEvaluate);
	}
}
