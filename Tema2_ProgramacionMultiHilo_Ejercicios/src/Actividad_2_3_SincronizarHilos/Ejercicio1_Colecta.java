package Actividad_2_3_SincronizarHilos;

public class Ejercicio1_Colecta {
private int colecta = 0;
	
	synchronized public int getColecta() {
		return colecta;
	}
	
	synchronized public void incrementa(int incremento) {
		this.colecta+=incremento;
	}
}
