package pmp.project.src.drink;

import java.util.ArrayList;

import pmp.project.src.ingredient.Ingredient;
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

public class DrinkFactory {

	private Drink drink;
	private DrinkList drinkList;
	private ArrayList<Component> ingredientTanksList;

	public DrinkFactory(ArrayList<Component> tankList) {
		super();
		this.drinkList = new DrinkList();
		this.ingredientTanksList = tankList;
	}

	public void prepareDrink() {
		this.drink = new Drink();
	}

	public void prepareDrink(String name) {
		this.drink = new Drink(name);
	}
	
	public void prepareDrink(Drink drinkFromList) {
		this.drink = new Drink(drinkFromList);
	}

	public void addIngredient(Drink newDrink, Ingredient ingredient, Component tank, int desiredQuantity) throws ComponentException {
		if (ComponentType.ingredientTank.isEnoughIngredient(tank, desiredQuantity))
			newDrink.getIngredientList().add(new PowderyIngredient(ingredient.getName(), desiredQuantity));
		System.out.println(ingredient.getName() + " " + tank.getIngredientInTank().getQuantity());
	}

	public void addIngredient(Drink newDrink, Ingredient ingredient, Component comp, int desiredQuantity, Temperature temperature, Pressure pressure) throws ComponentException {
		if (ComponentType.ingredientTank.isEnoughIngredient(comp, desiredQuantity))
			newDrink.getIngredientList().add(new LiquidIngredient(ingredient.getName(), desiredQuantity, temperature, pressure));
		System.out.println(ingredient.getName() + " " + comp.getIngredientInTank().getQuantity());
	}
	
	public void addDrinkToList(Drink addedDrink) {
		this.drinkList.getDrinks().putIfAbsent(addedDrink.getName(), addedDrink);
	}
	
	public Drink getDrinkFromList(String name) throws ComponentException {
		Drink recipe = new Drink(this.drinkList.getDrinks().get(name));
		prepareDrink();
		for(Ingredient item: recipe.getIngredientList()) {
			if (item instanceof LiquidIngredient) {
				for(Component tank: this.ingredientTanksList) {
					if ((tank.getIngredientInTank().getClass()).isInstance(item) & tank.getIngredientInTank().getName()==item.getName()) {
						addIngredient(this.drink, item, tank, item.getQuantity(), ((LiquidIngredient) item).getTemperature(), ((LiquidIngredient) item).getPressure());
						break;
					}
				}
			}
			if (item instanceof PowderyIngredient) {
				for(Component tank: this.ingredientTanksList) {
					if ((tank.getIngredientInTank().getClass()).isInstance(item) & tank.getIngredientInTank().getName()==item.getName()) {
						addIngredient(this.drink, item, tank, item.getQuantity());
						break;
					}
				}
			}
		}
		this.drink.setName(recipe.getName());
		return this.drink;
	}
	
	public Drink getDrink() {
		return this.drink;
	}
	
	public DrinkList getDrinkList() {
		return this.drinkList;
	}
}
