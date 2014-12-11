package pmp.project.test.ingredient;

import static org.junit.Assert.*;

import org.junit.Test;

import pmp.project.src.ingredient.Pressure;

/**
 * @author Przemyslaw Springer
 */

public class PressureTest {

	private static final int PRESSURE_VALUE = 80;
	private static Pressure pressure = new Pressure(PRESSURE_VALUE);
	
	@Test
	public void objectPressureValue() {
		assertSame(PRESSURE_VALUE, pressure.getPressureValue());
	}

}
