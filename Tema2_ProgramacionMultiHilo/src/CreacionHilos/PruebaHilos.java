package CreacionHilos;

public class PruebaHilos {
	
	public static void main (String [] args) {
		Hilo hilo1 = new Hilo();
		hilo1.start();
		
		try {
			hilo1.join(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Hilo().start();
		new Hilo().start();
	}
}
