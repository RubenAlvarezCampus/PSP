package Repaso_Recursividad;

import java.util.Scanner;

public class Ejercicio_2 {

	public static void comprendidos(int num1,int num2) {
		if (num1==num2) {
			System.out.println(num1);
		}
		else if (num1<num2 ) {
			System.out.println(num1);
			comprendidos(num1+1,num2);
		}
		else {
			System.out.println(num1);
			comprendidos(num1-1,num2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Dimne un numero: ");
		int num1 = sc.nextInt();
		System.out.print("Dimne otro numero: ");
		int num2 = sc.nextInt();
		
		comprendidos(num1,num2);
	}
}
