package Ejemplo1;

public class Principal {

	public static void main(String[] args) {
		Corredor juan = new Corredor("Juan");
		Corredor pepe = new Corredor("Pepe");
		Corredor isma = new Corredor("Isma");
		
		try {
			juan.join();
			pepe.join();
			isma.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("FIN");
	}
}
