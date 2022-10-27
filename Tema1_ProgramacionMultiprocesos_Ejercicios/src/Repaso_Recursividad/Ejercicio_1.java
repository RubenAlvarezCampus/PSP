package Repaso_Recursividad;

import java.util.Scanner;

public class Ejercicio_1 {

	public static int suma(int num) {
		if (num==1) {
			return 1;
		}
		else {
			return suma(num-1)+num;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Dimne un numero: ");
		System.out.println(suma(sc.nextInt()));
	}
}
