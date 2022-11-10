package Actividad_3_1_Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ejercicio_2_Cliente {
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
			
			//Opciones
			System.out.print("Indroduce una opción [1-Hora | 2-Fecha]: ");
			salida.write(lector.nextLine().getBytes());
			
			byte[] mensaje = new byte[100];
			entrada.read(mensaje);
			
			System.out.println("Servidor responde: " + new String(mensaje));
			
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
		}
		lector.close();
	}
}
