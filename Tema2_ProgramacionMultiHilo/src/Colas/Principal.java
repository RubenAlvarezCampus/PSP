package Colas;

public class Principal {
	public static void main(String[] args) {
		BufferFrases buffer = new BufferFrases();
		new Productor(buffer,"Buenos dias");
		new Consumidor(buffer);
		new Productor(buffer,"Buenos tardes");
		new Consumidor(buffer);
		new Productor(buffer,"Buenos noches");
		new Consumidor(buffer);
		new Productor(buffer,"Fin");
		new Consumidor(buffer);
	}
}
