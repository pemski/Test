package pmp.project.src.ingredient;

/**
 * @author Przemyslaw Springer
 */

public class PowderyIngredient extends Ingredient {
	
	public PowderyIngredient() {
		super();
	}
	
	public PowderyIngredient(String name, int quantity) {
		super(name, quantity);
	}
	
	@Override
	public String toString() {
		return "[" + getName() + ", " + getQuantity() + " g]";
	}
}
