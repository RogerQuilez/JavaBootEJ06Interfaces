package entity;

import entity_interface.Movible;

public abstract class Vehiculo implements Movible{

	private static int countId;
	private int id;
	private int potencia;
	private String nombre;
	private Trayecto trayecto;
	
	public Vehiculo(int potencia, String nombre) {
		this.id = ++Vehiculo.countId;
		this.potencia = potencia;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getPotencia() {
		return potencia;
	}
	
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static int getCountId() {
		return countId;
	}

	public static void setCountId(int countId) {
		Vehiculo.countId = countId;
	}

	public Trayecto getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(Trayecto trayecto) {
		this.trayecto = trayecto;
	}
	
}
