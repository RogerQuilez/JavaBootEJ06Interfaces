package entity;

import utils.Utils;

public class Trayecto {
	
	private int recorrido;
	private int distancia;
	private String nombreDestino;
	private Vehiculo vehiculo;
	
	public Trayecto(String nombreDestino, int distancia) {
		this.nombreDestino = nombreDestino;
		this.distancia = distancia;
	}
	
	/**
	 * Objeto Runnable que contiene el método run donde indicamos el recorrido del vehiculo, 
	 * desde el inicio hasta el fin
	 */
	private Runnable empezarTrayecto = () -> {
		
		System.out.println("Empezando el trayecto " + this.nombreDestino
			+ " con " + this.vehiculo.getNombre() + "! "
				+ this.distancia + "km's para finalizar");
		
		recorrido();
		
		System.out.println("Trayecto " + this.nombreDestino + " Finalizado!");
		
	};
	
	/**
	 * Printa la distancia recorrida y la que le queda por recorrer cada 1 segundo
	 */
	private void recorrido() {
		
		while (recorrido < distancia) {
			
			recorrido += this.vehiculo.moverVehiculo(Utils.generateRandomNumber(100, 200));
			
			printarTrayecto();
			
		}
	}

	/**
	 * 
	 * @param recorrido -> Km recorridos del viaje
	 * @param distancia -> Km que quedan para acabar el viaje
	 * Printa los kilometros recorridos y los que quedan por recorrer del trayecto
	 */
	private void printarTrayecto() {		
		
		if (this.distancia - this.recorrido >= 0) {
			
			System.out.println("Distancia recorrida de " + this.vehiculo.getNombre() + " del trayecto " 
			+ this.nombreDestino
				+ ": " + this.recorrido
					+ "km's, quedan " + (this.distancia - this.recorrido) 
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
		if (this.vehiculo instanceof Moto || this.vehiculo instanceof Coche) {
			return 5000;
		} else if (this.vehiculo instanceof Barco) {
			return 8000;
		} else {
			return 1000;
		}
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Runnable getEmpezarTrayecto() {
		return empezarTrayecto;
	}

	public void setEmpezarTrayecto(Runnable empezarTrayecto) {
		this.empezarTrayecto = empezarTrayecto;
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

	public int getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}
	
}
