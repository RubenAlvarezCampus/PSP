
import java.io.File;
import java.io.IOException;

public class Lanzador {
	public static void main(String[] args) {
		ProcessBuilder proceso = new ProcessBuilder("java", "Principal");
		proceso.directory(new File (".\\bin"));
		proceso.redirectError(new File("errores.txt"));
		proceso.redirectOutput(new File("salida.txt"));
		proceso.redirectInput(new File("entrada.txt"));
		try {
			proceso.start();
			System.out.println("El proceso ha sido lanzado con éxito");
			System.out.println ("Examina los archivos errores.txt ysalida.txt");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
