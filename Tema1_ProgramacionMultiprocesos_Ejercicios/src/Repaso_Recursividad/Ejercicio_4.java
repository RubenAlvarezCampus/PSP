package Repaso_Recursividad;

import java.util.Scanner;

public class Ejercicio_4 {
	public static int busqueda(int num,int[] lista,int p_inicial,int p_final) {
		int medio=(p_inicial+p_final)/2;
		
		if (num==lista[medio]) {
			return medio;
		}
		else if (p_final==p_inicial){
			System.out.println("En la lista no esta ese numero");
			return 0;
		}
		else if (num<lista[medio]) {
			return busqueda(num,lista,p_inicial,medio-1);
		}
		else {
			return busqueda(num,lista,medio+1,p_final);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] lista = {10,20,30,40,50};
		
		System.out.print("Dimne un numero: ");
		int num = sc.nextInt();
		
		System.out.println(busqueda(num,lista,0,lista.length));

	}
}
