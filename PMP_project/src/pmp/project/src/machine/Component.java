package pmp.project.src.machine;

import pmp.project.src.ingredient.Ingredient;
import pmp.project.src.ingredient.IngredientType;
import pmp.project.src.ingredient.LiquidIngredient;
import pmp.project.src.ingredient.PowderyIngredient;
import pmp.project.src.ingredient.Pressure;
import pmp.project.src.ingredient.Temperature;

/**
 * @author Przemyslaw Springer
 */
public class Component {
	private ComponentType componentType;
	private Ingredient ingredientInTank;

	public Component(ComponentType type) {
		this.componentType = type;
	}

	public Component(ComponentType type, String ingredientName, IngredientType ingType, int quantity) {
		this.componentType = type;
		if (ingType == IngredientType.liquid)
			this.ingredientInTank = new LiquidIngredient(ingredientName, quantity);
		if (ingType == IngredientType.powdery)
			this.ingredientInTank = new PowderyIngredient(ingredientName, quantity);
	}
	
	public ComponentType getType() {
		return this.componentType;
	}
	
	public Ingredient getIngredientInTank() {
		return this.ingredientInTank;
	}

	public enum ComponentType {

		stateIndicator {
			@Override
			public void isOn(MachineState state) throws ComponentException {
				if (state != MachineState.on)
					throwException(this.stateExceptionMessage);
			}
		},

		heater {
			@Override
			public Temperature heatLiquidIngredient(int temperature) {
				return new Temperature(temperature);
			}
		},

		liquidIngredientPump {
			@Override
			public Pressure pumpLiquidIngredient(int pressure) {
				return new Pressure(pressure);
			}
		},

		ingredientTank {
			@Override
			public int pourIngredient(int quantity) {
				return quantity;
			}

			@Override
			public boolean isEnoughIngredient(Component comp, int desiredQuantity) throws ComponentException {
				if (comp.ingredientInTank.getQuantity() >= desiredQuantity) {
					comp.ingredientInTank.setQuantity(comp.ingredientInTank.getQuantity() - desiredQuantity);
					return true;
				}
				throwException("Not enough " + comp.ingredientInTank.getName());
				return false;
			}
		};

		public String operationExceptionMessage = name() + " can't do that operation!";
		public String stateExceptionMessage = "The machine is turned off!";

		public void throwException(String message) throws ComponentException {
			throw new ComponentException(message);
		}

		public Temperature heatLiquidIngredient(int temperature) throws ComponentException {
			throwException(this.operationExceptionMessage);
			return null;
		}

		public Pressure pumpLiquidIngredient(int pressure) throws ComponentException {
			throwException(this.operationExceptionMessage);
			return null;
		}

		public int pourIngredient(int quantity) throws ComponentException {
			throwException(this.operationExceptionMessage);
			return 0;
		}

		public boolean isEnoughIngredient(Component comp, int q) throws ComponentException {
			throwException(this.operationExceptionMessage);
			return false;
		}

		public void isOn(MachineState state) throws ComponentException {
			throwException(this.operationExceptionMessage);
		}

		public int getQuantity() throws ComponentException {
			throwException(this.operationExceptionMessage);
			return 0;
		}

		public void setQuantity(int q) throws ComponentException {
			throwException(this.operationExceptionMessage);
		}
	}
}