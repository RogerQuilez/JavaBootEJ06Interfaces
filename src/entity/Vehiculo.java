package entity;

import entity_interface.Movible;
import utils.Utils;

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
	
	/**
	 * Objeto Runnable que contiene el método run donde indicamos el recorrido del vehiculo, 
	 * desde el inicio hasta el fin
	 */
	private Runnable empezarTrayecto = () -> {
		
		System.out.println("Empezando el trayecto " + this.trayecto.getNombreDestino() 
			+ " con " + this.nombre + "! "
				+ this.trayecto.getDistancia() + "km's para finalizar");
		
		recorrido();
		
		System.out.println("Trayecto " + this.trayecto.getNombreDestino() + " Finalizado!");
		
	};
	
	/**
	 * Printa la distancia recorrida y la que le queda por recorrer cada 1 segundo
	 */
	private void recorrido() {
		
		int recorrido = this.trayecto.getRecorrido();
		int distancia = this.trayecto.getDistancia();
		
		while (recorrido < distancia) {
			
			recorrido += this.moverVehiculo(Utils.generateRandomNumber(100, 200));
			
			printarTrayecto(recorrido, distancia);
			
		}
	}

	/**
	 * 
	 * @param recorrido -> Km recorridos del viaje
	 * @param distancia -> Km que quedan para acabar el viaje
	 * Printa los kilometros recorridos y los que quedan por recorrer del trayecto
	 */
	private void printarTrayecto(int recorrido, int distancia) {		
		
		if (distancia - recorrido >= 0) {
			
			System.out.println("Distancia recorrida de " + this.nombre + " del trayecto " 
			+ this.trayecto.getNombreDestino() 
				+ ": " + recorrido
					+ "km's, quedan " + (distancia - recorrido) 
						+ "km's");
			
			try {
				Thread.sleep(getInterval());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @return -> Devuelve el intervalo de tiempo que tardara en volver a ejecutarse el 
	 * hilo dependiendo de su instancia
	 */
	private int getInterval() {
		if (this instanceof Moto || this instanceof Coche) {
			return 5000;
		} else if (this instanceof Barco) {
			return 8000;
		} else {
			return 1000;
		}
	}
	
	public Runnable getEmpezarTrayecto() {
		return empezarTrayecto;
	}

	public void setEmpezarTrayecto(Runnable empezarTrayecto) {
		this.empezarTrayecto = empezarTrayecto;
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
