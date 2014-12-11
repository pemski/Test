package pmp.project.src.drink;

import java.util.HashMap;

import pmp.project.src.ingredient.LiquidIngredient;
import pmp.project.src.ingredient.PowderyIngredient;
import pmp.project.src.ingredient.Pressure;
import pmp.project.src.ingredient.Temperature;

/**
 * @author Przemyslaw Springer
 */

public class DrinkList {

	private HashMap<String, Drink> drinks;
	private Drink drink;
	
	public DrinkList() {
		this.drinks = new HashMap<>();
		
		this.drink = new Drink("Small black");
		this.drink.getIngredientList().add(new PowderyIngredient("coffee", 30));
		this.drink.getIngredientList().add(new LiquidIngredient("water", 80, new Temperature(90), new Pressure(150)));
		this.drink.getIngredientList().add(new PowderyIngredient("sugar", 10));
		this.drinks.putIfAbsent(this.drink.getName(), this.drink);
		
		this.drink = new Drink("Big black");
		this.drink.getIngredientList().add(new PowderyIngredient("coffee", 50));
		this.drink.getIngredientList().add(new LiquidIngredient("water", 140, new Temperature(90), new Pressure(150)));
		this.drink.getIngredientList().add(new PowderyIngredient("sugar", 10));
		this.drinks.putIfAbsent(this.drink.getName(), this.drink);
	}
	
	public void showDrinkRecipies() {
		for (HashMap.Entry<String, Drink> entry : this.drinks.entrySet()) {
		    Object value = entry.getValue();
		    System.out.println(value);
		}
	}
	
	public HashMap<String, Drink> getDrinks() {
		return this.drinks;
	}
	
}
