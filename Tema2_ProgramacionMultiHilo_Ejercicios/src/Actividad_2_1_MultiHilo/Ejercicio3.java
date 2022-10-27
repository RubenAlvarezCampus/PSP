package Actividad_2_1_MultiHilo;

public class Ejercicio3 {

	public static void main(String[] args) {
		System.out.println("-----Hilo 1-----");
		Ejercicio3_Hilo hilo1 = new Ejercicio3_Hilo(9);
		
		try {
			hilo1.getHilo().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		};
		
		System.out.println("-----Hilo 2-----");
		Ejercicio3_Hilo hilo2 = new Ejercicio3_Hilo(12);
	}
}
