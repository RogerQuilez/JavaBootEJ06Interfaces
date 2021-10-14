package entity;

public class Trayecto {
	
	private int recorrido;
	private int distancia;
	private String nombreDestino;
	
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

	public int getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}
	
}
