package Actividad_2_3_SincronizarHilos;

public class Ejercicio1 {

	private static final int NUM_HILOS = 4;
	
	public static void main(String[] args) {
		Ejercicio1_Colecta colecta = new Ejercicio1_Colecta();
		
		Thread[] hilos = new Thread[NUM_HILOS];
		
		for (int i = 0; i < NUM_HILOS; i++) {
			Ejercicio1_HilosColectores Hc = new Ejercicio1_HilosColectores(i+1,colecta);
			Thread hilo = new Thread(Hc);
			hilo.start();
			hilos[i] = hilo;
		}
		
		for (Thread h : hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {}
		}
		System.out.println("TOTAL: "+colecta.getColecta());
	}

}
