


import java.util.Scanner;

public class Utilidades {
	
public static String pedirTexto(String mensaje) {
		
		//Definir variables
		String texto = "";
		boolean error = false;
		
		//Crear Scanner
		Scanner sc = new Scanner(System.in);
		
		//Repetir hasta que no de error (Introducir texto)
		do {
			//Definimos error
			error = false;
			try {
				//Mensaje
				System.out.print(mensaje);
				//Pedimos un numero por linea y los transformamos a entero
				texto = sc.nextLine();
			}
			//Si da error
			catch(Exception e) {
				//Mostrar mensaje
				System.out.println("Valor incorrecto, introduce de nuevo");
				error=true;
			}
		}
		while(error); //Repetir hasta que error=false
				
		//Devolvemos el entero
		return texto;
	}


	public static char pedirChar(String mensaje) {
		
		//Definir variables
		char caracter = ' ';
		boolean error = false;
		
		//Crear Scanner
		Scanner sc = new Scanner(System.in);
		
		//Repetir hasta que no de error (Introducir texto)
		do {
			//Definimos error
			error = false;
			try {
				//Mensaje
				System.out.print(mensaje);
				//Pedimos un numero por linea y los transformamos a entero
				String texto = sc.nextLine();
				caracter = texto.charAt(0);
			}
			//Si da error
			catch(Exception e) {
				//Mostrar mensaje
				System.out.println("Valor incorrecto, introduce de nuevo");
				error=true;
			}
		}
		while(error); //Repetir hasta que error=false
				
		//Devolvemos el entero
		return caracter;
	}


	public static int pedirEntero(String mensaje) {
		
		//Definir variables
		int entero = 0;
		boolean error = false;
		
		//Crear Scanner
		Scanner sc = new Scanner(System.in);
		
		//Repetir hasta que no de error (Introducir numero)
		do {
			//Definimos error
			error = false;
			try {
				//Mensaje
				System.out.print(mensaje);
				//Pedimos un numero por linea y los transformamos a entero
				entero = Integer.parseInt(sc.nextLine());
			}
			//Si da error
			catch(Exception e) {
				//Mostrar mensaje
				System.out.println("Valor incorrecto, introduce de nuevo");
				error=true;
			}
		}
		while(error); //Repetir hasta que error=false
				
		//Devolvemos el entero
		return entero;
	}
	
	
	
	public static double pedirDouble(String mensaje) {
		
		//Definir variables
		double num = 0;
		boolean error = false;
		
		//Crear Scanner
		Scanner sc = new Scanner(System.in);
		
		//Repetir hasta que no de error (Introducir numero)
		do {
			//Definimos error
			error = false;
			try {
				//Mensaje
				System.out.print(mensaje);
				//Pedimos un numero por linea y los transformamos a entero
				num = Double.parseDouble(sc.nextLine());
			}
			//Si da error
			catch(Exception e) {
				//Mostrar mensaje
				System.out.println("Valor incorrecto, introduce de nuevo");
				error=true;
			}
		}
		while(error); //Repetir hasta que error=false
				
		//Devolvemos el entero
		return num;
	}
	
	
	
	public static boolean pedirBoolean(String mensaje) {
		
		//Definir variables
		boolean valor = true;
		boolean error = false;
		
		//Crear Scanner
		Scanner sc = new Scanner(System.in);
		
		//Repetir hasta que no de error (Introducir numero)
		do {
			//Definimos error
			error = false;
			try {
				//Mensaje
				System.out.print(mensaje);
				//Pedimos un numero por linea y los transformamos a entero
				valor = Boolean.parseBoolean(sc.nextLine());
			}
			//Si da error
			catch(Exception e) {
				//Mostrar mensaje
				System.out.println("Valor incorrecto, introduce de nuevo");
				error=true;
			}
		}
		while(error); //Repetir hasta que error=false
				
		//Devolvemos el entero
		return valor;
	}
}
