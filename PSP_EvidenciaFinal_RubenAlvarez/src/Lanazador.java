

import java.io.File;
import java.io.IOException;

public class Lanazador {
	public static void main(String[] args) {
		
		ProcessBuilder proceso1 = new ProcessBuilder("java","MostrarDatos","Ruben","2002");
		proceso1.directory(new File (".\\bin"));
		proceso1.redirectOutput(new File("datos1.txt"));
		proceso1.redirectError(new File("erroresDatos1.txt"));
		
		ProcessBuilder proceso2 = new ProcessBuilder("java","MostrarDatos","Samuel","hol204");
		proceso2.directory(new File (".\\bin"));
		proceso2.redirectOutput(new File("datos2.txt"));
		proceso2.redirectError(new File("erroresDatos2.txt"));
		
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
