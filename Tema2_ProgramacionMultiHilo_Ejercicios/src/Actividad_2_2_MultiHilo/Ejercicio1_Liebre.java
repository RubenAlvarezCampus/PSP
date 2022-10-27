package Actividad_2_2_MultiHilo;

import java.util.concurrent.ThreadLocalRandom;

public class Ejercicio1_Liebre extends Thread{
	private int casillas;
	private int num=0;
	
	public Ejercicio1_Liebre(int casillas) {
		super("Liebre");
		this.casillas = casillas;
	}
	@Override
	public void run() {
		while (num<casillas) {
			int r = ThreadLocalRandom.current().nextInt(1,101);
			
			if (r<=20) {
				if ((num+9)>=casillas) {
					num=casillas;
				}
				else {
					num=num+9;
				}
			}
			else if (20<r && r<=40){
				if ((num-8)<=0) {
					num=1;
				}
				else {
					num=num-8;
				}
			}
			else if (40<r && r<=60){
				if ((num+8)>=casillas) {
					num=casillas;
				}
				else {
					num=num+8;
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("La liebre va por la casilla: "+num);
		}
		System.out.println("La liebre a llegado");
	}
}
