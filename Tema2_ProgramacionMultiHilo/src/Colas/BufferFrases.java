package Colas;

import java.util.LinkedList;
import java.util.Queue;

public class BufferFrases {
	private Queue<String> cola;
	
	public BufferFrases() {
		cola = new LinkedList<String>();
	}
	
	public synchronized void poner(String frase) {
		cola.add(frase);
		notify();
	}
	
	public synchronized String sacar() {
		
		if (cola.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		String frase = cola.remove();
		return frase;
	}
}
