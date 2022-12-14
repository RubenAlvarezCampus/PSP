package Actividad_2_3_SincronizarHilos;

import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio4_NumeroOculto {
	/*Atributos*/
	private int jugadores;
	private int turno;
	private int numero_adivinar;
	private boolean juego;
	
	/*Constructor*/
	public Ejercicio4_NumeroOculto(int jugadores) {
		super();
		this.jugadores = jugadores;
		this.turno = 1;
		this.numero_adivinar = ThreadLocalRandom.current().nextInt(1,21);
		this.juego=true;
		
		System.out.println("Numero a adividar: "+this.numero_adivinar);
	}
	
	/*Get y set*/
	public int getTurno() {
		return turno;
	}

	/*Metodos*/
	synchronized public boolean ver_juego() {
		if (this.juego==true) {
			/*Despertamos a los hilos si sigue el juego*/
			notifyAll();
			return true;
		}
		return false;
	}
	
	synchronized void jugada(int id) {
		if (this.turno==id) {
			/*Es su turno*/
			
			/*Numero aleatorio*/
			int numero = ThreadLocalRandom.current().nextInt(1,21);
			System.out.println("El jugador "+id+" ha dicho "+numero);
			
			/*Aumentamos el turno*/
			if (this.turno==this.jugadores) {
				turno=1;
			} else {
				this.turno++;
			}
			
			/*Si lo a adivinado*/
			if (numero==this.numero_adivinar) {
				System.out.println("El jugador "+id+" ha ganado");
				this.juego=false;
			}
		}
		else {
			/*No es su turno*/
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
