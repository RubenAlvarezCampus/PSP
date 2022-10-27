package Actividad_2_2_MultiHilo;

public class Ejercicio2 {

	public static void main(String[] args) {
		int[] lista_cliente1 = {2,2,1,5,2,3};
		int[] lista_cliente2 = {1,3,5,1,1};
		
		Ejercicio2_Cliente cliente_1 = new Ejercicio2_Cliente("Ruben", lista_cliente1);
		Ejercicio2_Cliente cliente_2 = new Ejercicio2_Cliente("Samu", lista_cliente2);
		
		Ejercicio2_Cajera cajera_1 = new Ejercicio2_Cajera("Isma",cliente_1);
		Ejercicio2_Cajera cajera_2 = new Ejercicio2_Cajera("Pepe",cliente_2);
	}

}
