package Sinconizacion_hilos;

public class HiloContador implements Runnable {
	private int numHilo, miParte, miCuenta = 0;
	private final Contador cont;

	public int getMiCuenta() {
		return miCuenta;
	}

	HiloContador(int numHilo, int miParte, Contador c) {
		this.numHilo = numHilo;
		this.miParte = miParte;
		this.cont = c;
	}

	@Override
	public void run() {
		for (int i = 0; i < miParte; i++) {
			this.cont.incrementa();
			miCuenta++;
		}
		System.out.printf("Hilo %d terminado, cuenta: %d\n", numHilo, getMiCuenta());
	}
}
