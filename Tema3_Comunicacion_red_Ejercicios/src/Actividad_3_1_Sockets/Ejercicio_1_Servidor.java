package Actividad_3_1_Sockets;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Ejercicio_1_Servidor {
	
	public static String genararHorar() {
		LocalDateTime hora = LocalDateTime.now();	
		return hora.getHour()+":"+hora.getMinute()+":"+hora.getSecond();
	}
	
	public static void main(String[] args) {
		System.out.println(" APLICACIÓN DE SERVIDOR ");
		System.out.println("----------------------------------");
		try {
			ServerSocket servidor = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress("localhost",2000);
			
			// Vinculamos el servidor con la dirección establecida por el objeto
			// InetSocketAddress
			servidor.bind(direccion);
			System.out.println("Servidor creado y escuchando .... ");
			System.out.println("Dirección IP: " + direccion.getAddress());
			
			// Detiene el proceso hasta que un cliente solicite una conexión.
			Socket enchufeAlCliente = servidor.accept();
			System.out.println("Comunicación entrante");
			
			// Abrirmos los flujos de salida para las comunicaciones.
			OutputStream salida = enchufeAlCliente.getOutputStream();
			salida.write(("La hora atual es: "+genararHorar()).getBytes());
			
			salida.close();
			enchufeAlCliente.close();
			servidor.close();
			
			System.out.println("Comunicación cerrada");
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
