package entity;

public class Barco extends Vehiculo {
	
	private static final int ADD_POTENCIA = 2;
	
	public Barco(int potencia, String nombre) {
		super(potencia, nombre);
	}

	@Override
	public int moverVehiculo(int metros) {
		return metros + this.getPotencia()*ADD_POTENCIA;
	}

}
