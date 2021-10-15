package entity;

public class Avion extends Vehiculo {
	
	private static final int ADD_POTENCIA = 3;

	public Avion(int potencia, String nombre) {
		super(potencia, nombre);
	}

	@Override
	public int moverVehiculo(int metros) {
		return metros + this.getPotencia()*ADD_POTENCIA;
	}
}
