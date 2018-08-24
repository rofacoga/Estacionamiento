package co.com.ceiba.estacionamiento.utilities.exceptions;

public class DateCheckInIsAfterThanDateCheckOutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public DateCheckInIsAfterThanDateCheckOutException(String message) {
		super(message);
	}
}
