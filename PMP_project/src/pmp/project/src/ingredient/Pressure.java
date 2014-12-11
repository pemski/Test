package pmp.project.src.ingredient;

/**
 * @author Przemyslaw Springer
 */

public class Pressure {

	private int pressure;
	
	public Pressure(int pressure) {
		doSetPressure(pressure);
	}
	
	public int getPressureValue() {
		return this.pressure;
	}
	
	private void doSetPressure(int newPressure) {
		this.pressure = newPressure;
	}
	
}
