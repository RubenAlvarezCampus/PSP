package Actividad_1_1_Multiprocesos;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) {
		ProcessBuilder proceso = new ProcessBuilder("notepad","prueba.txt");
		File directorio = new File("C:\\PSP");
		proceso.directory(directorio);
		System.out.println("Mi ruta es: "+directorio.toString());
		try {
			Process p = proceso.start();
			System.out.println("Pid: "+p.pid());
			Thread.sleep(2000);
			System.out.println("Esta vivo? "+p.isAlive());
			if (p.isAlive()==true) {
				p.destroy();
				System.out.println("Terminamos el proceso de forma manual");
			}
			else {
				System.out.println("El proceso esta finalizado");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
