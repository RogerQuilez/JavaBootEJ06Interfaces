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

		List<Thread> threadList = getThreads(trayectos);
		
		runThreads(threadList);
		
	}
	
	private static void runThreads(List<Thread> threadList) {
		for (Thread t: threadList) {
			t.start();
		}		
	}

	private static List<Thread> getThreads(List<Trayecto> trayectos) {
		List<Thread> threadList = new LinkedList<>();
		
		for (Trayecto t: trayectos) {
			Thread trayectoT = new Thread(t.getThread());
			threadList.add(trayectoT);
		}
		
		return threadList;
	}

	private static List<Trayecto> getTrayectos() {
		List<Trayecto> trayectos = new LinkedList<>();
		
		trayectos.add(new Trayecto("Galicia", 600));
		trayectos.add(new Trayecto("Asturias", 600));
		trayectos.add(new Trayecto("Formentera", 7000));
		trayectos.add(new Trayecto("Nueva York", 8000));
		
		return trayectos;
	}

	public static List<Vehiculo> getVehiculos() {
		
		List<Vehiculo> vehiculos = new LinkedList<>();
		
		vehiculos.add(new Moto(Utils.generateRandomNumber(300, 100), "Kawasaki"));
		vehiculos.add(new Coche(Utils.generateRandomNumber(300, 100), "Ferrari"));
		vehiculos.add(new Barco(Utils.generateRandomNumber(800, 600), "Atlantico"));
		vehiculos.add(new Avion(Utils.generateRandomNumber(700, 300), "Vueling"));
		
		return vehiculos;
		
	}
	
	public static void añadirTrayectos(List<Trayecto> trayectos, List<Vehiculo> vehiculos) {
		for (int i = 0; i < 4; i++) {
			trayectos.get(i).setVehiculo(vehiculos.get(i));
			vehiculos.get(i).setTrayecto(trayectos.get(i));
		}
	}
	
	public static void printarDistanciaVehiculos(List<Vehiculo> vehiculos) {
		for (Vehiculo v: vehiculos) {
			System.out.println(v.getNombre() + " -> " + 
					v.moverVehiculo(Utils.generateRandomNumber(300, 100)));
		}
	}
	
}
