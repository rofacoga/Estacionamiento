import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 */

/**
 * @author roger.cordoba
 *
 */
public class PruebaEjecucionTest {

	@SuppressWarnings("static-access")
	@Test
	public void sumarDosNumerosEnterosTest() {
		PruebaEjecucion pruebaEjecucion = new PruebaEjecucion();
		assertEquals( 2, pruebaEjecucion.sumarDosNumerosEnteros(1, 1) );
	}
}
