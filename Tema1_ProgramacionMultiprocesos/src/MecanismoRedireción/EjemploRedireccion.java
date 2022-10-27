package MecanismoRedireción;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EjemploRedireccion {
	public static void main(String[] args) {
		ProcessBuilder proceso = new ProcessBuilder("cmd","/C","dir");
		try {
			Process p =proceso.start();
			InputStream is = p.getInputStream();
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
