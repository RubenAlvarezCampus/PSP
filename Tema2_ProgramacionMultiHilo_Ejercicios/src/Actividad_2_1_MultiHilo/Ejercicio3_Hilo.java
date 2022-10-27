package Actividad_2_1_MultiHilo;

public class Ejercicio3_Hilo implements Runnable{
	private int num;
	private Thread hilo;
	
	public Ejercicio3_Hilo(int num) {
		hilo = new Thread(this);
		this.num = num;
		hilo.start();
	}
	
	public Thread getHilo() {
		return hilo;
	}

	@Override
	public void run() {
		int num1=0;
		int num2=1;
		int resultado;
		
		for (int i=0;i<num;i++) {
			System.out.println(num1);
			
			resultado=num1+num2;
			num1=num2;
			num2=resultado;
		}
	}
}