package main;

import java.util.LinkedList;
import java.util.List;

import entity.Avion;
import entity.Barco;
import entity.Coche;
import entity.Moto;
import entity.Vehiculo;

public class Main {

	
	public static void main(String[] args) {
		
		List<Vehiculo> vehiculos = getVehiculos();		
		
		printarDistanciaVehiculos(vehiculos);
		
	}
	
	public static List<Vehiculo> getVehiculos() {
		
		List<Vehiculo> vehiculos = new LinkedList<>();
		vehiculos.add(new Moto(generateRandomNumber(300, 100), "Kawasaki"));
		vehiculos.add(new Coche(generateRandomNumber(300, 100), "Ferrari"));
		vehiculos.add(new Barco(generateRandomNumber(800, 600), "Atlantico"));
		vehiculos.add(new Avion(generateRandomNumber(700, 300), "Vueling"));
		
		return vehiculos;
		
	}
	
	public static void printarDistanciaVehiculos(List<Vehiculo> vehiculos) {
		for (Vehiculo v: vehiculos) {
			String unidad = v instanceof Barco ? "Nudos" : "Km";
			System.out.println(v.getNombre() + " -> " + 
					v.moverVehiculo(generateRandomNumber(300, 100)) + " " + unidad);
		}
	}
	
	public static int generateRandomNumber(int min, int max) {
		return (int)(Math.random() * ((min - max) + 1)) + min;
	}
	
}
