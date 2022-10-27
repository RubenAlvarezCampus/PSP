package Actividad_1_2_Multoproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio_1 {

	public static void main(String[] args) {
		ProcessBuilder proceso = new ProcessBuilder("java", "Principal");
		try {
			Process p = proceso.start();
			InputStream is = p.getErrorStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			String linea;
			while ((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
