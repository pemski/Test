package pmp.project.test.ingredient;

import static org.junit.Assert.*;

import org.junit.Test;

import pmp.project.src.ingredient.Ingredient;
import pmp.project.src.ingredient.LiquidIngredient;
import pmp.project.src.ingredient.Pressure;
import pmp.project.src.ingredient.Temperature;

/**
 * @author Przemyslaw Springer
 */

public class LiquidIngredientTest extends Ingredient {

	private static final String NAME = "Water";
	private static final int QUANTITY_VALUE = 30;
	private static final int TEMPERATURE_VALUE = 30;
	private static final int PRESSURE_VALUE = 30;
	private static Temperature temperature = new Temperature(TEMPERATURE_VALUE);
	private static Pressure pressure = new Pressure(PRESSURE_VALUE);
	private static LiquidIngredient liquidIngredient = new LiquidIngredient(NAME, QUANTITY_VALUE, temperature, pressure);

	@Test
	public void objectQuantityValue() {
		assertSame(QUANTITY_VALUE, liquidIngredient.getQuantity());
	}
	
	@Test
	public void objectTemperatureValue() {
		assertSame(TEMPERATURE_VALUE, liquidIngredient.getTemperature().getTemperatureValue());
	}

	@Test
	public void objectPressureValue() {
		assertSame(PRESSURE_VALUE, liquidIngredient.getPressure().getPressureValue());
	}
	
	@Test
	public void objectNameValue() {
		assertSame(NAME, liquidIngredient.getName());
	}
	
}
