package Actividad_2_3_SincronizarHilos;

import java.util.Scanner;

public class Ejercicio4_Principal_Juego {
	public static void main(String[] args) {
		/*Pedir valor por teclado*/
		 Scanner entradaEscaner = new Scanner (System.in);
		 System.out.print("Ingrese el numero de jugadores: ");
		 int jugadores = entradaEscaner.nextInt();
		 
		 /*Crear clases*/
		 Ejercicio4_NumeroOculto numero_oculto = new Ejercicio4_NumeroOculto(jugadores);
		 
		 for (int i = 1; i<=jugadores;i++) {
			 Ejercicio4_Jugador jugador = new Ejercicio4_Jugador(i, numero_oculto);
		 }
	}
}
