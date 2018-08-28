package co.com.ceiba.estacionamiento.utilities.exceptions;

/**
 * 
 * @author roger.cordoba
 */
public class ParkingExceedsTheAllowedCapacityException extends AnExceptionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParkingExceedsTheAllowedCapacityException(String message) {
		super(message);
	}
}
