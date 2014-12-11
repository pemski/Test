package pmp.project.test.ingredient;

import static org.junit.Assert.*;

import org.junit.Test;

import pmp.project.src.ingredient.PowderyIngredient;

/**
 * @author Przemyslaw Springer
 */

public class PowderyIngredientTest {

	private static final String NAME = "Sugar";
	private static final int QUANTITY_VALUE = 30;
	private static PowderyIngredient powderyIngredient = new PowderyIngredient(NAME, QUANTITY_VALUE);
	
	@Test
	public void objectQuantityValue() {
		assertSame(QUANTITY_VALUE, powderyIngredient.getQuantity());
	}

	@Test
	public void objectNameValue() {
		assertSame(NAME, powderyIngredient.getName());
	}
	
}
