package entity;

public class Avion extends Vehiculo {

	public Avion(int potencia, String nombre) {
		super(potencia, nombre);
	}

	@Override
	public int moverVehiculo(int metros) {
		return metros + this.getPotencia()*3;
	}
}
