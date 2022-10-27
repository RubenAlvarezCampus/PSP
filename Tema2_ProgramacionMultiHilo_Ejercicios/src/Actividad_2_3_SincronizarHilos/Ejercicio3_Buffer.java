package Actividad_2_3_SincronizarHilos;

import java.util.Stack;

public class Ejercicio3_Buffer {
	private Stack<Ejercicio3_circunferencia> pila;

	public Ejercicio3_Buffer() {
		super();
		pila = new Stack<Ejercicio3_circunferencia>();
	}
	
	public synchronized void añadir(Ejercicio3_circunferencia circunferencia) {
		pila.push(circunferencia);
		notify();
	}
	
	public synchronized void sacar() {
		
		if (pila.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Ejercicio3_circunferencia circunferencia = pila.pop();
		circunferencia.mostar();
	}
}
