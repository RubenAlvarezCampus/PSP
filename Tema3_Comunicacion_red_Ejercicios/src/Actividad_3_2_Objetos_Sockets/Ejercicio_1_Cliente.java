package Actividad_3_2_Objetos_Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ejercicio_1_Cliente {
public static void main(String[] args) {
		
		System.out.println(" APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");
		Scanner lector = new Scanner(System.in);
		
		try {
			//Comunicación con el servidor
			Socket cliente = new Socket();
			InetSocketAddress direccionServidor = new InetSocketAddress("localhost",2000);
			
			System.out.println("Esperando a que el servidor acepte la conexión");
			cliente.connect(direccionServidor);
			
			System.out.println("Comunicación establecida con el servidor");
			InputStream entrada = cliente.getInputStream();
			OutputStream salida = cliente.getOutputStream();
			
			System.out.print("Indroduce un ID: ");
			salida.write(lector.nextLine().getBytes());
			
			ObjectInputStream inOb = new ObjectInputStream(cliente.getInputStream());
			Object objeto = inOb. readObject(); //recibiendo un objeto
			
			if (objeto == null) {
				System.out.println("no hay ninguna persona con ese ID");
			}
			else {
				System.out.println("Servidor responde: " + objeto.toString());
			}
			
			
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
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		lector.close();
	}
}
