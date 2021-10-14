package entity_interface;

public interface Movible {
	
	default public String moverVehiculo(int metros) {
		return "Distancia recorrida: " + metros + " Km's";
	}
}
