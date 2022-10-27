package Actividad_1_2_Multoproceso;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio_3 {
	
	public static void main(String[] args) {
		ProcessBuilder proceso = new ProcessBuilder("java","Ejercicio_3_Aleatorio");
		proceso.directory(new File ("C:\\PSP\\Ejercicio\\bin"));
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Generar aleatorio (N para finalizar):");
		String entrada = sc.next();
		
		while (!entrada.equalsIgnoreCase("N")) {
			try {
				Process p = proceso.start();
				InputStream is = p.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String linea = br.readLine();
				System.out.println(linea);
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print("Generar aleatorio (N para finalizar):");
			entrada = sc.next();
		}
	}
}
