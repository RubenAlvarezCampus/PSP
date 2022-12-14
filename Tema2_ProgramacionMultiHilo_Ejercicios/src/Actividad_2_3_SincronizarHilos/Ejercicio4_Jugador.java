package Actividad_2_3_SincronizarHilos;

public class Ejercicio4_Jugador extends Thread{
	/*Atributos*/
	private int id;
	private Ejercicio4_NumeroOculto numero_oculto;
	
	/*Constructor*/
	public Ejercicio4_Jugador(int id, Ejercicio4_NumeroOculto numero_oculto) {
		super();
		this.id = id;
		this.numero_oculto = numero_oculto;
		this.start();
	}
	
	@Override
	public void run() {
		while (numero_oculto.ver_juego()) {
			numero_oculto.jugada(id);
		}	
	}
}
