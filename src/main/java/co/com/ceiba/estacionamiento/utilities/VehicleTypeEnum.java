package co.com.ceiba.estacionamiento.utilities;

/**
 * 
 * @author roger.cordoba
 */
public enum VehicleTypeEnum {
	CAR("AUTOMOVIL"),
	MOTORCYCLE("MOTOCICLETA");
	private String value;

	private VehicleTypeEnum(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
