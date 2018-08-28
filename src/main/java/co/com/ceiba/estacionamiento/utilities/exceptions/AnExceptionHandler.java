package co.com.ceiba.estacionamiento.utilities.exceptions;

/**
 * 
 * @author roger.cordoba
 */
public class AnExceptionHandler extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public AnExceptionHandler() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AnExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AnExceptionHandler(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public AnExceptionHandler(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AnExceptionHandler(Throwable cause) {
		super(cause);
	}
}
