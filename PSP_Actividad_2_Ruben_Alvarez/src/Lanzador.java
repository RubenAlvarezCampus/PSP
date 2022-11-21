import java.io.File;
import java.io.IOException;

public class Lanzador {
	public static void main(String[] args) {
		if (args.length!=6) {
			System.out.println("No hay 6 argumentos");
			System.exit(1);
		}
		else {
			//Examen 1
			ProcessBuilder proceso1 = new ProcessBuilder("java","Principal",args[0],args[1],args[2]);
			proceso1.redirectOutput(new File("examen1.txt"));
			
			//Examen 2
			ProcessBuilder proceso2 = new ProcessBuilder("java","Principal",args[3],args[4],args[5]);
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
