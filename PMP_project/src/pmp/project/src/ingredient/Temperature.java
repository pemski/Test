package pmp.project.src.ingredient;

/**
 * @author Przemyslaw Springer
 */

public class Temperature {

	private int temperature;
	
	public Temperature(int temperature) {
		doSetTemperature(temperature);
	}
	
	public int getTemperatureValue() {
		return this.temperature;
	}
	
	private void doSetTemperature(int newTemperature) {
		this.temperature = newTemperature;
	}
	
}
