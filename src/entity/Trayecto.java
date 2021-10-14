package entity;

import utils.Utils;

public class Trayecto {
	
	private int recorrido;
	private int distancia;
	private String nombreDestino;
	private Vehiculo vehiculo;
	
	/**
	 * Objeto Runnable que contiene el método run donde indicamos el recorrido del vehiculo, desde el inicio hasta el fin
	 */
	private Runnable thread = () -> {
		
		System.out.println("Empezando el trayecto " + this.nombreDestino + " con " + this.vehiculo.getNombre() + "! "
				+ this.distancia + "km's para finalizar");
		
		recorrido();
		
		System.out.println("Trayecto " + this.nombreDestino + " Finalizado!");
		
	};

	/**
	 * Printa la distancia recorrida y la que le queda por recorrer cada 1 segundo
	 */
	private void recorrido() {
		while (this.recorrido < this.distancia) {
			
			this.recorrido += vehiculo.moverVehiculo(Utils.generateRandomNumber(100, 200));
			
			if (this.distancia - this.recorrido >= 0) {
				
				System.out.println("Distancia recorrida de " + this.vehiculo.getNombre() + " del trayecto " + this.getNombreDestino() 
					+ ": " + this.recorrido 
						+ "km's, quedan " + (this.distancia - this.recorrido) + "km's");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public Trayecto(String nombreDestino, int distancia) {
		this.nombreDestino = nombreDestino;
		this.distancia = distancia;
	}
	
	public int getDistancia() {
		return distancia;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public String getNombreDestino() {
		return nombreDestino;
	}
	
	public void setNombreDestino(String nombreDestino) {
		this.nombreDestino = nombreDestino;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Runnable getThread() {
		return thread;
	}

	public void setThread(Runnable thread) {
		this.thread = thread;
	}

	public int getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}
	
}
