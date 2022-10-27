package Actividad_1_1_Multiprocesos;

import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) {
		if (args.length==0) {
			System.out.println("No hay argumentos");
			System.exit(1);
		}
		else {
			ProcessBuilder proceso = new ProcessBuilder(args);
			try {
				Process p = proceso.start();
				p.waitFor();
				//Devuelve el comando
				System.out.println("Comando ejecutado: "+proceso.command());
				//Devuelve el codigo de finalizacion
				System.out.println("Codigo de finalización: "+p.exitValue());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
