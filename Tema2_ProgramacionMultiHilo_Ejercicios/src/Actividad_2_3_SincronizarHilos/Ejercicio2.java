package Actividad_2_3_SincronizarHilos;

public class Ejercicio2 {

	private static final int NUM_RECOLECTORES = 2;
	private static final int NUM_CONSUMIDORES = 1;
	
	public static void main(String[] args) {
		Ejercicio2_Colecta colecta = new Ejercicio2_Colecta();
		
		for (int i = 0; i < NUM_RECOLECTORES; i++) {
			Ejercicio2_Recolectores Recolecor = new Ejercicio2_Recolectores(colecta);
		}
		
		for (int i = 0; i < NUM_CONSUMIDORES; i++) {
			Ejercicio2_Consumidor Consumidor = new Ejercicio2_Consumidor(colecta);
		}
	}
}
