package pmp.project.src.main;

import java.util.ArrayList;

import pmp.project.src.drink.DrinkFactory;
import pmp.project.src.ingredient.IngredientType;
import pmp.project.src.machine.Component;
import pmp.project.src.machine.Component.ComponentType;
import pmp.project.src.machine.ComponentException;
import pmp.project.src.machine.MachineState;

/**
 * @author Przemyslaw Springer
 */

public class Main {

	public static void main(String[] args) throws ComponentException {

		final MachineState machineState = MachineState.on;
		final ComponentType stateIndicator = ComponentType.stateIndicator;
		stateIndicator.isOn(machineState);

		ArrayList<Component> tankList = new ArrayList<>();
		Component heater = new Component(ComponentType.heater);
		Component waterPump = new Component(ComponentType.liquidIngredientPump);
		Component sugarTank = new Component(ComponentType.ingredientTank, "sugar", IngredientType.powdery, 50);
		Component waterTank = new Component(ComponentType.ingredientTank, "water", IngredientType.liquid, 150);
		Component coffeeTank = new Component(ComponentType.ingredientTank, "coffee", IngredientType.powdery, 100);
		
		tankList.add(waterTank);
		tankList.add(sugarTank);
		tankList.add(coffeeTank);
		
		DrinkFactory drinkFactory = new DrinkFactory(tankList);
		
////Adding custom drink to list		
		drinkFactory.prepareDrink();
		drinkFactory.addIngredient(drinkFactory.getDrink(), coffeeTank.getIngredientInTank(), coffeeTank, coffeeTank.getType().pourIngredient(50));
		drinkFactory.addIngredient(drinkFactory.getDrink(), waterTank.getIngredientInTank(), waterTank, waterTank.getType().pourIngredient(100), heater.getType().heatLiquidIngredient(80), waterPump.getType().pumpLiquidIngredient(110));
		drinkFactory.addIngredient(drinkFactory.getDrink(), sugarTank.getIngredientInTank(), sugarTank, sugarTank.getType().pourIngredient(10));
		drinkFactory.addDrinkToList(drinkFactory.getDrink());
		System.out.println("Drink done: " + drinkFactory.getDrink());

////Preparing drink from list
//		drinkFactory.getDrinkFromList("Big black");
//		System.out.println("Drink done: " + drinkFactory.getDrink());

		System.out.println("\n");
		System.out.println("Drinks saved in the list: ");
		drinkFactory.getDrinkList().showDrinkRecipies();

	}
}