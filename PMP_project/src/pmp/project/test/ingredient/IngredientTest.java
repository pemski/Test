package pmp.project.test.ingredient;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import pmp.project.src.ingredient.Ingredient;

/**
 * @author Przemyslaw Springer
 */

public class IngredientTest {

	private static final int QUANTITY = 30;
	private static final String NAME = "coffee";
	private static final Ingredient ingredient = new Ingredient(NAME, QUANTITY);
	
	@Test
	public void objectQuantityValue() {
		assertSame(QUANTITY, ingredient.getQuantity());
	}
	
	@Test
	public void objectNameValue() {
		assertSame(NAME, ingredient.getName());
	}
}
