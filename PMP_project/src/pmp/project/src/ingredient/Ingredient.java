package pmp.project.src.ingredient;

/**
 * @author Przemyslaw Springer
 */

public class Ingredient {

	private int quantity;
	private String name;
	
	public Ingredient() {
		super();
	}
	
	public Ingredient(String name, int quantity) {
		doSetName(name);
		doSetQuantity(quantity);
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	private void doSetQuantity(int newQuantity) {
		this.quantity = newQuantity;
	}

	public String getName() {
		return this.name;
	}

	private void doSetName(String newName) {
		this.name = newName;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}
