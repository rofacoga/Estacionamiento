package co.com.ceiba.estacionamiento.utilities.exceptions;

public class ThePlateStartWithTheLetterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public ThePlateStartWithTheLetterException(String message) {
		super(message);
	}
}