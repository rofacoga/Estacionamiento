package co.com.ceiba.estacionamiento.utilities;

public final class Constants {
	/**
	 * List of messages to errors possibles
	 */
	public static final String MESSAGE_ERROR_DAY_NOT_VALID = "It's not a valid day to evaluate!";
	public static final String MESSAGE_ERROR_CHECK_IN_PLATE_INVALID = "The license plate of the vehicle begins with the letter A, and can only enter the parking lot on Sundays and Mondays!";
	public static final String MESSAGE_ERROR_CHECK_IN_FULL_CAPACITY_1 = "The parking lot is full! The ";
	public static final String MESSAGE_ERROR_CHECK_IN_FULL_CAPACITY_2 = " quotas have already been occupied!";
	public static final String MESSAGE_ERROR_CHECK_IN_PLATE_REGISTERED = "The license plate of the vehicle is already registered in the parking lot!";
	public static final String MESSAGE_ERROR_CHECK_OUT_FIELD_CALENDAR_NULL = "The Calendar Check Out field is Empty!";
	public static final String MESSAGE_ERROR_CHECK_OUT_CALENDAR_IS_BEFORE = "The Calendar Out Date is before of Calendar In Date!";
	public static final String MESSAGE_ERROR_CHECK_OUT_VEHICLE_NOT_FOUND_1 = "The vehicle with license plate: ";
	public static final String MESSAGE_ERROR_CHECK_OUT_VEHICLE_NOT_FOUND_2 = ", not found in the parking lot!";
	public static final String MESSAGE_ERROR_LOGIN_INCORRECT_DATA = "You have entered an invalid username or password";
	public static final String MESSAGE_ERROR_CREATE_VEHICLE_PLATE_DUPLICATED = "There is already a vehicle with a license plate: ";

	/**
	 * minimum hours for the day
	 */
	public static final Integer HOURS_MIN_FOR_THE_DAY = 9;
	public static final Integer HOURS_OF_THE_DAY = 24;

	public static final Integer CANT_MAX_CARS = 20;
	public static final Double COST_HOUR_CARS = 1000.0;
	public static final Double COST_DAY_CARS = 8000.0;

	public static final Integer CANT_MAX_MOTORCYCLES = 10;
	public static final Integer CYLINDER_MAX_MOTOCYCLES = 500;
	public static final Double COST_HOUR_MOTORCYCLES = 500.0;
	public static final Double COST_DAY_MOTORCYCLES = 4000.0;
	public static final Double COST_SURCHARGE_MOTORCYCLES = 2000.0;

	/**
	 * (60 * 60 * 1000)
	 */
	public static final Integer MILLISECONDS_OF_A_HOUR = 3600000;
	/**
	 * (60 * 1000)
	 */
	public static final Integer MILLISECONDS_OF_A_MINUTE = 60000;
	public static final Integer MINUTES_OF_A_HOUR = 60;

	/**
	 * tolerance 15 minutes for exit park
	 */
	public static final Double PERCENT_OF_ONE_HOUR_TOLERANCE_MINUTES = 0.10;
	public static final Double PERCENT_OF_NINE_HOURS_IN_A_DAY = 0.375;

	private Constants() {
		throw new IllegalStateException("Contants Utility class");
	}

}
