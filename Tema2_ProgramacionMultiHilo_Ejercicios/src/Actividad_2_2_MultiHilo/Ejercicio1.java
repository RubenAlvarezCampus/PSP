package Actividad_2_2_MultiHilo;

public class Ejercicio1 {
	public static void main(String[] args) {
		Ejercicio1_Tortuga hilo1 = new Ejercicio1_Tortuga(20);
		Ejercicio1_Liebre hilo2 = new Ejercicio1_Liebre(20);
		
		hilo1.start();
		hilo2.start();
	}
}
