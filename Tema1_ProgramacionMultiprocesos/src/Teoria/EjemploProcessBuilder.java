package Teoria;

import java.io.File;
import java.io.IOException;

public class EjemploProcessBuilder {
	public static void main(String[] args) {
		ProcessBuilder proceso = new ProcessBuilder("notepad","prueba.txt");
		File directorio = new File("C:\\PSP");
		File miDirectorio = proceso.directory();
		proceso.directory(directorio);
		try {
			Process p = proceso.start();
			long pid = p.pid();
			System.out.println(pid);
			System.out.println(p.isAlive());
			p.waitFor();
			System.out.println(p.isAlive());
			System.out.println("Fin del programa");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
