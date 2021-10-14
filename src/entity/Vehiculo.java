package entity;

import entity_interface.Movible;

public abstract class Vehiculo implements Movible{

	private int id;
	private int potencia;
	private String nombre;
	
	public Vehiculo(int potencia, String nombre) {
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
	
	
	
}