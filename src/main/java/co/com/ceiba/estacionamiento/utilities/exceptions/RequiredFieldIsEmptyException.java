package co.com.ceiba.estacionamiento.utilities.exceptions;

/**
 * 
 * @author roger.cordoba
 */
public class RequiredFieldIsEmptyException extends AnExceptionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequiredFieldIsEmptyException(String message) {
		super(message);
	}

}