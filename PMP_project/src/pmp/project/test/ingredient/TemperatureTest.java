package pmp.project.test.ingredient;

import static org.junit.Assert.*;

import org.junit.Test;

import pmp.project.src.ingredient.Temperature;

/**
 * @author Przemyslaw Springer
 */

public class TemperatureTest {

	private static Temperature temperature;
	private static final int TEMPERATURE_VALUE = 35;
	
	@Test
	public void objectTemperatureValue() {
		temperature = new Temperature(TEMPERATURE_VALUE);
		assertSame(TEMPERATURE_VALUE, temperature.getTemperatureValue());
	}

}
