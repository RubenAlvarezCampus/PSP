

import java.io.File;
import java.io.IOException;

public class Lanzador {
	public static void main(String[] args) {
		if (args.length!=4) {
			System.out.println("No hay 4 argumentos");
			System.exit(1);
		}
		else {
			//Examen 1
			ProcessBuilder proceso1 = new ProcessBuilder("java","Operaciones",args[0],args[1]);
			proceso1.redirectOutput(new File("examen1.txt"));
			
			//Examen 2
			ProcessBuilder proceso2 = new ProcessBuilder("java","Operaciones",args[2],args[3]);
			proceso2.redirectOutput(new File("examen2.txt"));
			
			//Ejecutamos los proccesos
			try {
				proceso1.start();
				proceso2.start();	
				System.out.println("Se ha iniciado con exito los dos proccesos");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}