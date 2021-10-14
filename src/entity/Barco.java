package entity;

public class Barco extends Vehiculo {
	
	public Barco(int potencia, String nombre) {
		super(potencia, nombre);
	}

	@Override
	public String moverVehiculo(int metros) {
		return "Distancia recorrida: " + metros + this.getPotencia()*2;
	}

}
