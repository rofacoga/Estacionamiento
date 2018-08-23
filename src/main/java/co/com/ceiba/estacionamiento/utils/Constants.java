package co.com.ceiba.estacionamiento.utils;

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



	private Constants() {
		throw new IllegalStateException("Contants Utility class");
	}

}
