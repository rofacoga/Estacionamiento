package co.com.ceiba.estacionamiento.utils;

public class Validations {
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
}
