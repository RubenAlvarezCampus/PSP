package Cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import Datos.Juego;

public class Cliente {
	
	public static void main(String[] args) {
		System.out.println(" APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");
		Scanner input = new Scanner(System.in);
		
		try {
			//Comunicación con el servidor
			Socket cliente = new Socket();
			InetSocketAddress direccionServidor = new InetSocketAddress("localhost",2000);
			
			System.out.println("Esperando a que el servidor acepte la conexión");
			cliente.connect(direccionServidor);
			
			System.out.println("Comunicación establecida con el servidor");
			InputStream entrada = cliente.getInputStream();
			OutputStream salida = cliente.getOutputStream();
			String opcion;
			
			do {
				//Menu
				System.out.println("--------- Menu ---------");
				System.out.println("1 - Mostrar Todo");
				System.out.println("2 - Buscar por ID");
				System.out.println("3 - Genero");
				System.out.println("4 - Si hay Stock");
				System.out.println("5 - Salir");
				System.out.println("");
				System.out.print("Elige una opción: "); 
				opcion = input.nextLine();
				System.out.println("");
				
				String consulta = "";
				
				// Opcion elegida por el cliente
				switch (opcion) {
					case "1":
						//Mostrar todo
						consulta="Todo-Valor";
						break;
					case "2":
						//ID
						System.out.print("Dime el ID del juego: ");
						consulta = "ID-"+input.nextLine();
						break;
					case "3":
						//Genero
						System.out.print("Dime el genero del juego: ");
						consulta = "Genero-"+input.nextLine();
						break;
					case "4":
						//Juegos Stock
						consulta = "Stock-Valor";
						break;
					case "5":
						consulta = "salir";
						salida.write(consulta.getBytes());
						break;
					default:
						System.out.println("**Opción no valida**");
				}		
				
				if (consulta.length() != 0 && consulta!="salir") {
					salida.write(consulta.getBytes());
					
					ObjectInputStream inOb = new ObjectInputStream(cliente.getInputStream());
					ArrayList<Juego> juegos = (ArrayList<Juego>) inOb. readObject(); //recibiendo un objeto
					
					if (juegos.isEmpty()) {
						System.out.println("no hay ningun juego con esas condición");
					}
					else {
						for (Juego juego :juegos) {
							System.out.println(juego.toString());
						}
					}
				}
				
			} while (!opcion.equals("5"));
			
			//Cerramos todo
			salida.close();
			entrada.close();
			cliente.close();
			System.out.println("Comunicación cerrada");
			
		} catch (UnknownHostException e) {
			System.out.println("No se puede establecer comunicación con el servidor");
			System.out.println(e.getMessage());
			
		} catch (IOException e) {
			System.out.println("Error de E/S");
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
