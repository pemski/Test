package pmp.project.src.drink;

import java.util.ArrayList;

import pmp.project.src.ingredient.Ingredient;

/**
 * @author Przemyslaw Springer
 */

public class Drink {

	private String name = "Drink";
	private ArrayList<Ingredient> ingredientList;

	public Drink() {
		this.ingredientList = new ArrayList<>();
	}

	public Drink(String name) {
		doSetName(name);
		this.ingredientList = new ArrayList<>();
	}

	public Drink(Drink drinkFromList) {
		doSetName(drinkFromList.getName());
		this.ingredientList = new ArrayList<>(drinkFromList.ingredientList);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Ingredient> getIngredientList () {
		return this.ingredientList;
	}

	private void doSetName(String newName) {
		this.name = newName;
	}

	@Override
	public String toString() {
		return getName() + " ingredients = " + this.ingredientList.toString();
	}

}
