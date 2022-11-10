package Actividad_2_3_SincronizarHilos;

public class Ejercicio3_Consumidora extends Thread{
	
	private Ejercicio3_pila pila;
	
	public Ejercicio3_Consumidora(String name,Ejercicio3_pila lista) {
		super(name);
		this.pila = lista;
		this.start();
	}

	@Override
	public void run() {
		/*Añadir una circunferencia*/
		pila.sacar(this.getName());
	}
}
