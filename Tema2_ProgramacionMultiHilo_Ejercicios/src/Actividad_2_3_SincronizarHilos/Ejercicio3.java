package Actividad_2_3_SincronizarHilos;

public class Ejercicio3 {

	public static void main(String[] args) {
		Ejercicio3_pila pila = new Ejercicio3_pila();
		
		Ejercicio3_Productor Productor_1 = new Ejercicio3_Productor("Productor 1",pila);
		Ejercicio3_Productor Productor_2 = new Ejercicio3_Productor("Productor 2",pila);
		Ejercicio3_Productor Productor_3 = new Ejercicio3_Productor("Productor 3",pila);
		
		Ejercicio3_Consumidora Consumidor_1 = new Ejercicio3_Consumidora("Consumidor 1",pila);
		Ejercicio3_Consumidora Consumidor_2 = new Ejercicio3_Consumidora("Consumidor 2",pila);
	}
}
