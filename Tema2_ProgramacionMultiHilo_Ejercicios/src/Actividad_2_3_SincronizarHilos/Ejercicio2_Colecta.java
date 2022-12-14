package Actividad_2_3_SincronizarHilos;

public class Ejercicio2_Colecta {
private int colecta = 0;
	
	synchronized public int getColecta() {
		return colecta;
	}
	
	synchronized public void incrementa(int incremento,String nombre) {
		while ((this.colecta+incremento)>2000) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.colecta+=incremento;
		System.out.println("Hilo "+nombre+", ha añadido: "+incremento+", TOTAL="+this.colecta);
		notifyAll();
	}
	
	synchronized public void decrementar(int decremento,String nombre) {
		while ((this.colecta-decremento)<0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.colecta-=decremento;
		System.out.println("Hilo "+nombre+", ha reducido en: "+decremento+", TOTAL="+this.colecta);
		notifyAll();
	}
}
