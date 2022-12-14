package Actividad_2_3_SincronizarHilos;

import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio1_HilosColectores implements Runnable{
	private int numHilo,contador = 0;
	private final Ejercicio1_Colecta colecta;

	Ejercicio1_HilosColectores(int numHilo,Ejercicio1_Colecta c) {
		this.colecta = c;
		this.numHilo = numHilo;
	}

	@Override
	public void run() {
		while (this.colecta.getColecta()<=2000) {
			int espera_aleatoria=ThreadLocalRandom.current().nextInt(100,501);
			int aumento_aleatorio=ThreadLocalRandom.current().nextInt(5,51);
			
			try {
				Thread.sleep(espera_aleatoria);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (this.colecta.getColecta()>=2000) {
				break;
			}
			
			this.colecta.incrementa(aumento_aleatorio);
			contador+=aumento_aleatorio;
		}
		System.out.printf("Hilo %d terminado, cuenta: %d\n", numHilo, this.contador);
	}
}
