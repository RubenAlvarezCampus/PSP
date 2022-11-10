package Actividad_3_1_Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ejercicio_1_Cliente {
public static void main(String[] args) {
		
		System.out.println(" APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");
		
		try {
			Socket cliente = new Socket();
			InetSocketAddress direccionServidor = new InetSocketAddress("localhost",2000);
			
			System.out.println("Esperando a que el servidor acepte la conexión");
			cliente.connect(direccionServidor);
			
			System.out.println("Comunicación establecida con el servidor");
			InputStream entrada = cliente.getInputStream();
				
			byte[] mensaje = new byte[100];
			entrada.read(mensaje);
			
			System.out.println("Servidor responde: " + new String(mensaje));
		
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
	}
}
