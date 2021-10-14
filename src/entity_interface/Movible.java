package entity_interface;

public interface Movible {
	
	default public int moverVehiculo(int metros) {
		return metros;
	}
}
