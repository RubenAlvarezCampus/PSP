package Actividad_2_1_MultiHilo;

public class Ejercicio2 {

	public static void main(String[] args) {
		Ejercicio2_Hilo hilo1 = new Ejercicio2_Hilo(9);
		Ejercicio2_Hilo hilo2 = new Ejercicio2_Hilo(12);
		
		System.out.println("-----Hilo 1-----");
		hilo1.start();
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----Hilo 2-----");
		hilo2.start();
	}
}
