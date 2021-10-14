package entity;

public class Barco extends Vehiculo {
	
	public Barco(int potencia, String nombre) {
		super(potencia, nombre);
	}

	@Override
	public int moverVehiculo(int metros) {
		return metros + this.getPotencia()*2;
	}

}
