package Ejercicio_3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {
	public static void main(String[] args) {
		System.out.println(" APLICACIÓN DE SERVIDOR ");
		System.out.println("----------------------------------");
		try {
			ServerSocket servidor = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress("localhost", 2000);
			
			servidor.bind(direccion);
			System.out.println("Servidor creado y escuchando .... ");
			System.out.println("Dirección IP: " + direccion.getAddress());


			while (true) {
				Socket enchufeAlCliente = servidor.accept();
				System.out.println("Comunicación entrante");
				new Hilo(enchufeAlCliente);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
