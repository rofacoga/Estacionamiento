package co.com.ceiba.estacionamiento.utilities;

public final class Constants {
	/**
	 * minimum hours for the day
	 */
	public static final Integer HOURS_MIN_FOR_THE_DAY 	= 9;
	public static final Integer HOURS_OF_THE_DAY 		= 24;

	public static final Integer CANT_MAX_VEHICLES 	= 20;
	public static final Double 	COST_HOUR_VEHICLES 	= 1000.0;
	public static final Double 	COST_DAY_VEHICLES 	= 8000.0;

	public static final Integer CANT_MAX_MOTORCYCLES 		= 5;
	public static final Double 	COST_HOUR_MOTORCYCLES 		= 500.0;
	public static final Double 	COST_DAY_MOTORCYCLES 		= 4000.0;
	public static final Double 	COST_SURCHARGE_MOTORCYCLES 	= 2000.0;
	public static final Integer CYLINDER_MAX_MOTOCYCLES 	= 500;

	/**
	 * (60 * 1000)
	 */
	public static final Integer MILLISECONDS_OF_A_MINUTE 	= 60000;
	public static final Integer MINUTES_OF_A_HOUR 			= 60;

	/**
	 * tolerance 15 minutes for exit park 
	 */
	public static final Double PERCENT_OF_ONE_HOUR_TOLERANCE_MINUTES = 0.10;
	public static final Double PERCENT_OF_NINE_HOURS_IN_A_DAY = 0.375;

	private Constants() {
		throw new IllegalStateException("Contants Utility class");
	}

}
