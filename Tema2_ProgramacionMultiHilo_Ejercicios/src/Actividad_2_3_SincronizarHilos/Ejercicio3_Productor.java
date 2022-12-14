package Actividad_2_3_SincronizarHilos;

import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio3_Productor extends Thread{
	
	private Ejercicio3_pila pila;
	
	public Ejercicio3_Productor(String name,Ejercicio3_pila lista) {
		super(name);
		this.pila = lista;
		this.start();
	}

	@Override
	public void run() {
		
		int num = ThreadLocalRandom.current().nextInt(1,51);
		Ejercicio3_Circunferencia circunferencia = new Ejercicio3_Circunferencia(num);
		pila.añadir(circunferencia,this.getName());
	}
}
