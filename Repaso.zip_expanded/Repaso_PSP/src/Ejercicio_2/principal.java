package Ejercicio_2;

public class principal {
	public static void main(String[] args) {
		int[] lista_1 = {3,5,6,7,6};
		int[] lista_2 = {5,40,28,30};
		
		Hilo hilo_1 = new Hilo("Hilo_1",lista_1);
		Hilo hilo_2 = new Hilo("Hilo_2",lista_2);
	}
}
