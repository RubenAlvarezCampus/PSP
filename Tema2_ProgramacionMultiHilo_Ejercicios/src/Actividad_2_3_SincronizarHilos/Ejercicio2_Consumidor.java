package Actividad_2_3_SincronizarHilos;

import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio2_Consumidor implements Runnable{
	private static int numHilo = 0;
	private final Ejercicio2_Colecta colecta;
	Thread hilo;

	public Ejercicio2_Consumidor(Ejercicio2_Colecta c) {
		super();
		numHilo++;
		this.colecta = c;
		
		hilo = new Thread(this, "Consumidores " + numHilo);
		hilo.start();
	}

	@Override
	public void run() {
		while (true){
			int espera_aleatoria=ThreadLocalRandom.current().nextInt(20,301);
			int dinero_aleatorio=ThreadLocalRandom.current().nextInt(100,400);
			
			try {
				Thread.sleep(espera_aleatoria);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.colecta.decrementar(dinero_aleatorio,hilo.getName());
		}
	}
}
