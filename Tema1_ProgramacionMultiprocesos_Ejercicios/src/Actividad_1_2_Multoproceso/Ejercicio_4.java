package Actividad_1_2_Multoproceso;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio_4 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		String entrada = sc.next();
		ProcessBuilder proceso1 = new ProcessBuilder("java","Ejercicio_4_Triangulo",entrada);
		proceso1.directory(new File ("C:\\PSP\\Ejercicio\\bin"));
		proceso1.redirectOutput(new File("triangulo"+entrada+".txt"));
		proceso1.redirectError(new File("triangulo"+entrada+".txt"));
		
		entrada = sc.next();
		ProcessBuilder proceso2 = new ProcessBuilder("java","Ejercicio_4_Triangulo",entrada);
		proceso2.directory(new File ("C:\\PSP\\Ejercicio\\bin"));
		proceso2.redirectOutput(new File("triangulo"+entrada+".txt"));
		proceso2.redirectError(new File("triangulo"+entrada+".txt"));
		
		entrada = sc.next();
		ProcessBuilder proceso3 = new ProcessBuilder("java","Ejercicio_4_Triangulo",entrada);
		proceso3.directory(new File ("C:\\PSP\\Ejercicio\\bin"));
		proceso3.redirectOutput(new File("triangulo"+entrada+".txt"));
		proceso3.redirectError(new File("triangulo"+entrada+".txt"));
		
		try {
			proceso1.start();
			System.out.println("El primer archivo txt se creo con exito");
			proceso2.start();
			System.out.println("El Segundo archivo txt se creo con exito");
			proceso3.start();
			System.out.println("El Tercer archivo txt se creo con exito");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
