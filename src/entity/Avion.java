package entity;

public class Avion extends Vehiculo {

	public Avion(int potencia, String nombre) {
		super(potencia, nombre);
	}

	@Override
	public String moverVehiculo(int metros) {
		return "Distancia recorrida: " + metros * this.getPotencia()*3;
	}
}
