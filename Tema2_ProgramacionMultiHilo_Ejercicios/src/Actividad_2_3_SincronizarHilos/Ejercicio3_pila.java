package Actividad_2_3_SincronizarHilos;

import java.util.Stack;

public class Ejercicio3_pila {
	private Stack<Ejercicio3_Circunferencia> pila;

	public Ejercicio3_pila() {
		super();
		pila = new Stack<Ejercicio3_Circunferencia>();
	}
	
	public synchronized void añadir(Ejercicio3_Circunferencia circunferencia,String name) {
		pila.push(circunferencia);
		System.out.println("El hilo "+name+" ha añadido una circunferencia");
		notify();
	}
	
	public synchronized void sacar(String name) {
		
		if (pila.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Ejercicio3_Circunferencia circunferencia = pila.pop();
		System.out.println("El hilo "+name+" ha sacado una circunferencia");
		circunferencia.mostrar();
	}
}
