package co.com.ceiba.estacionamiento.utilities.exceptions;

/**
 * 
 * @author roger.cordoba
 */
public class DateCheckInIsAfterThanDateCheckOutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DateCheckInIsAfterThanDateCheckOutException(String message) {
		super(message);
	}
}
