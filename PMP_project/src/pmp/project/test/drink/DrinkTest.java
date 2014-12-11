package pmp.project.test.drink;

import static org.junit.Assert.*;

import org.junit.Test;

import pmp.project.src.drink.Drink;
import pmp.project.src.ingredient.Ingredient;

/**
 * @author Przemyslaw Springer
 */

public class DrinkTest {

	private String name = "Drink";
	private Drink drink;
	
	@Test
	public void objectNameValue() {
		drink = new Drink(name);
		assertSame(name, drink.getName());
	}

	@Test
	public void aasd() {
		Drink drinkFromList = new Drink();
		drink = new Drink(drinkFromList);
		assertSame(drinkFromList.getName(), drink.getName());
	}

	public Boolean listCompare(Drink drink, Drink drinkFromList) {
		for(Ingredient ing : drinkFromList.getIngredientList()) {
			if (drink.getIngredientList().contains(ing))
				continue;
			return false;
		}
		return true;
	}
	
	@Test
	public void asd() {
		Drink drinkFromList = new Drink();
		drinkFromList.getIngredientList().add(new Ingredient("sugar", 50));
		drink = new Drink(drinkFromList);
		drink.getIngredientList().add(new Ingredient());
		assertTrue(listCompare(drink, drinkFromList));
	}
	
}
