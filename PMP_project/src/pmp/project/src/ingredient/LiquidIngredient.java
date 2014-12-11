package pmp.project.src.ingredient;

/**
 * @author Przemyslaw Springer
 */

public class LiquidIngredient extends Ingredient {

	private Temperature temperature;
	private Pressure pressure;
	
	public LiquidIngredient() {
		super();
	}
	
	public LiquidIngredient(String name, int quantity) {
		super(name, quantity);
	}
	
	public LiquidIngredient(String name, int quantity, Temperature temperature, Pressure pressure) {
		super(name, quantity);
		doSetTemperature(temperature);
		doSetPressure(pressure);
	}
	
	public Temperature getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public Pressure getPressure() {
		return this.pressure;
	}

	public void setPressure(Pressure pressure) {
		this.pressure = pressure;
	}
	
	private void doSetTemperature(Temperature newTemperature) {
		this.temperature = newTemperature;
	}
	
	private void doSetPressure(Pressure newPressure) {
		this.pressure = newPressure;
	}

	@Override
	public String toString() {
		return "[" + getName() + ", " + getQuantity() + " ml, " + getTemperature().getTemperatureValue() + " *C, "
				+ getPressure().getPressureValue() + "]";
	}
	
}
