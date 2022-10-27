package Actividad_2_1_MultiHilo;

public class Ejercicio2_Hilo extends Thread{
	private int num;
	
	public Ejercicio2_Hilo(int num) {
		super();
		this.num = num;
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