package Sinconizacion_hilos;

public class HilosCooperantes {

	private static final int NUM_HILOS = 10;
	private static final int CUENTA_TOTAL = 100000;

	public static void main(String[] args) {
		Contador c = new Contador();
		
		// Creamos un vector para guardas los hilos que creemos
		Thread[] hilos = new Thread[NUM_HILOS];
		for (int i = 0; i < NUM_HILOS; i++) {
			HiloContador hC = new HiloContador(i, CUENTA_TOTAL / NUM_HILOS, c);
			Thread th = new Thread(hC);
			th.start();
			hilos[i] = th;
		}
		
		// Recorremos el vector de hilos y con join esperamos a que todos terminen
		for (Thread h : hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {}
		}
		System.out.printf("Cuenta global: %s\n", c.getCuenta());
	}

}
