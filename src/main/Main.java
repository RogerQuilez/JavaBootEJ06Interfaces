package main;

import java.util.LinkedList;
import java.util.List;

import utils.Utils;

import entity.Avion;
import entity.Barco;
import entity.Coche;
import entity.Moto;
import entity.Trayecto;
import entity.Vehiculo;

public class Main {

	
	public static void main(String[] args) {
		
		List<Vehiculo> vehiculos = getVehiculos();		
		List<Trayecto> trayectos = getTrayectos();
		
		añadirTrayectos(trayectos, vehiculos);

		List<Thread> threadList = getThreads(vehiculos);
		
		runThreads(threadList);
		
	}
	
	/**
	 * 
	 * @param threadList -> Lista con todos los hilos de los distintos trayectos
	 * Inicia los hilos
	 */
	private static void runThreads(List<Thread> threadList) {
		for (Thread t: threadList) {
			t.start();
		}		
	}

	/**
	 * 
	 * @param trayectos -> Lista de tipo Trayecto enviada por parámetro para conseguir los hilos
	 * @return -> Devuelve una lista con los hilos de los trayectos
	 */
	private static List<Thread> getThreads(List<Vehiculo> vehiculos) {
		List<Thread> threadList = new LinkedList<>();
		
		for (Vehiculo v: vehiculos) {
			Thread vehiculoT = new Thread(v.getEmpezarTrayecto());
			threadList.add(vehiculoT);
		}
		
		return threadList;
	}

	/**
	 * 
	 * @return -> Devuelve una lista de trayectos
	 */
	private static List<Trayecto> getTrayectos() {
		List<Trayecto> trayectos = new LinkedList<>();
		
		trayectos.add(new Trayecto("Galicia", 600));
		trayectos.add(new Trayecto("Asturias", 600));
		trayectos.add(new Trayecto("Formentera", 7000));
		trayectos.add(new Trayecto("Nueva York", 20000));
		
		return trayectos;
	}

	/**
	 * 
	 * @return -> Devuelve una lista de vehiculos
	 */
	public static List<Vehiculo> getVehiculos() {
		
		List<Vehiculo> vehiculos = new LinkedList<>();
		
		vehiculos.add(new Moto(Utils.generateRandomNumber(300, 100), "Kawasaki"));
		vehiculos.add(new Coche(Utils.generateRandomNumber(300, 100), "Ferrari"));
		vehiculos.add(new Barco(Utils.generateRandomNumber(800, 600), "Atlantico"));
		vehiculos.add(new Avion(Utils.generateRandomNumber(700, 300), "Vueling"));
		
		return vehiculos;
		
	}
	
	/**
	 * 
	 * @param trayectos --> Lista de trayectos
	 * @param vehiculos --> Lista de vehiculos
	 * Para cada trayecto le añadimos un vehiculo y viceversa
	 */
	public static void añadirTrayectos(List<Trayecto> trayectos, List<Vehiculo> vehiculos) {
		for (int i = 0; i < 4; i++) {
			vehiculos.get(i).setTrayecto(trayectos.get(i));
		}
	}
	
}
