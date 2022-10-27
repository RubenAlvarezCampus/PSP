package Repaso_Recursividad;

import java.util.Scanner;

public class Ejercicio_3 {

	public static int potencia(int num,int i) {
		if (i==0) {
			return 1;
		}
		else {
			return potencia(num,i-1)*num;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Dimne un numero: ");
		int num = sc.nextInt();
		System.out.print("Dimne la potencia: ");
		int i = sc.nextInt();
		
		System.out.println(potencia(num,i));
	}
}
