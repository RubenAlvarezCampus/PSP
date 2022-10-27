package Actividad_1_1_Multiprocesos;

import java.io.IOException;

public class Ejercicio3 {

	public static void main(String[] args) {
		ProcessBuilder proceso = new ProcessBuilder("notepad","C:\\PSP\\prueba.txt");
		boolean salir = true;
		try {
			Process p = proceso.start();
			while (salir==true) {
				Thread.sleep(3000);
				if (p.isAlive()==true) {
					System.out.println("Esta vivo? "+p.isAlive());
				}
				else {
					System.out.println("Esta vivo? "+p.isAlive());
					System.out.println("El proceso a finalizado");
					break;
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
