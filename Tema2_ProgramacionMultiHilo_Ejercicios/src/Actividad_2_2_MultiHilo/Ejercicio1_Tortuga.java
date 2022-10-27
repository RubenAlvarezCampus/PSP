package Actividad_2_2_MultiHilo;
import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio1_Tortuga extends Thread{
	private int casillas;
	private int num=0;
	
	public Ejercicio1_Tortuga(int casillas) {
		super("Liebre");
		this.casillas = casillas;
	}
	@Override
	public void run() {
		while (num<casillas) {
			int r = ThreadLocalRandom.current().nextInt(1,100);
			
			if (r<=50) {
				if ((num+3)>=casillas) {
					num=20;
				}
				else {
					num=num+3;
				}
			}
			else if (50<r && r<=70){
				if ((num-6)<=0) {
					num=1;
				}
				else {
					num=num-6;
				}
			}
			else {
				num++;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("La tortuga va por la casilla: "+num);
		}
		System.out.println("La tortuga llego a la meta");
	}
}
