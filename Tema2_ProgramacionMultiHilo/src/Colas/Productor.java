package Colas;

public class Productor implements Runnable{
	private static int contador = 0;
	private BufferFrases buffer;
	private Thread hilo;
	private String frase;
	
	public Productor(BufferFrases buffer, String frase) {
		contador++;
		this.buffer = buffer;
		this.frase=frase;
		hilo = new Thread(this, "Productor" + contador);
		hilo.start();
	}
	
	@Override
	public void run() {
		buffer.poner(frase);
	}
}
