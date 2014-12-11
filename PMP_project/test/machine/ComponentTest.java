package pmp.project.test.machine;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pmp.project.src.ingredient.Ingredient;
import pmp.project.src.ingredient.IngredientType;
import pmp.project.src.ingredient.LiquidIngredient;
import pmp.project.src.ingredient.PowderyIngredient;
import pmp.project.src.ingredient.Pressure;
import pmp.project.src.ingredient.Temperature;
import pmp.project.src.machine.Component;
import pmp.project.src.machine.Component.ComponentType;
import pmp.project.src.machine.ComponentException;

/**
 * @author Przemyslaw Springer
 */

public class ComponentTest {

	private static final String INGREDIENT_NAME = "ingredient";
	private static final int INGREDIENT_QUANTITY = 50;
	private IngredientType ingredientType = IngredientType.liquid;
	private ComponentType componentType = ComponentType.ingredientTank;
	private Ingredient ingredientInTank;
	private Component component;
	
	@Test
	public void objectComponentTypeValue() {
		component = new Component(componentType);
		assertSame(componentType, component.getType());
	}

	private void createComponentWithLiquidIng() {
		ingredientType = IngredientType.liquid;
		component = new Component(componentType, INGREDIENT_NAME, ingredientType, INGREDIENT_QUANTITY);
	}

	@Test
	public void ingredientShouldBeLiquid1() {
		createComponentWithLiquidIng();
		assertTrue(new LiquidIngredient().getClass().isInstance(component.getIngredientInTank()));
	}

	@Test
	public void ingredientShouldBeLiquid2() {
		createComponentWithLiquidIng();
		assertFalse(new PowderyIngredient().getClass().isInstance(component.getIngredientInTank()));
	}

	private void createComponentWithPowderyIng() {
		ingredientType = IngredientType.powdery;
		component = new Component(componentType, INGREDIENT_NAME, ingredientType, INGREDIENT_QUANTITY);
	}

	@Test
	public void ingredientShouldBePowdery1() {
		createComponentWithPowderyIng();
		assertTrue(new PowderyIngredient().getClass().isInstance(component.getIngredientInTank()));
	}
	
	@Test
	public void ingredientShouldBePowdery2() {
		createComponentWithPowderyIng();
		assertFalse(new LiquidIngredient().getClass().isInstance(component.getIngredientInTank()));
	}

	@Test
	public void ingredientInTankNameValue() {
		createComponentWithLiquidIng();
		assertSame(new LiquidIngredient(INGREDIENT_NAME, INGREDIENT_QUANTITY).getName(), component.getIngredientInTank().getName());
	}

	@Test
	public void ingredientInTankQuantityValue() {
		createComponentWithLiquidIng();
		assertSame(new LiquidIngredient(INGREDIENT_NAME, INGREDIENT_QUANTITY).getQuantity(), component.getIngredientInTank().getQuantity());
	}

	@Test
	public void heaterTemperatureValue() throws ComponentException {
		componentType = ComponentType.heater;
		component = new Component(componentType);
		int temperatureValue = 30;
		Temperature temperature = new Temperature(temperatureValue);
		assertSame(temperature.getTemperatureValue(), component.getType().heatLiquidIngredient(temperatureValue).getTemperatureValue());
	}

	@Test
	public void pumpPressureValue() throws ComponentException {
		componentType = ComponentType.liquidIngredientPump;
		component = new Component(componentType);
		int pressureValue = 30;
		Pressure pressure= new Pressure(pressureValue);
		assertSame(pressure.getPressureValue(), component.getType().pumpLiquidIngredient(pressureValue).getPressureValue());
	}

	@Test
	public void ingredientTankShouldPourIngredient() throws ComponentException {
		createComponentWithLiquidIng();
		assertSame(INGREDIENT_QUANTITY, component.getType().pourIngredient(INGREDIENT_QUANTITY));
	}
	
	@Test
	public void objectShouldHaveEnoughIngredient() throws ComponentException {
		createComponentWithLiquidIng();
		int desiredIngredient = 30;
		assertTrue(component.getType().isEnoughIngredient(component, desiredIngredient));
	}
	
}
