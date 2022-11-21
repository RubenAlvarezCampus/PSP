package Actividad_3_1_Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ejercicio_3_Cliente {
	public static void main(String[] args) {
		
		System.out.println(" APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");
		Scanner lector = new Scanner(System.in);
		try {
			DatagramSocket ds = new DatagramSocket();
			
			// Dirección IP del receptor
			InetAddress destino = InetAddress.getByName("localhost");
			String mensaje = "";
			
			while (!mensaje.equals("FIN")) {
				System.out.println("--------- Menu ---------");
				System.out.println("1 - Hora");
				System.out.println("2 - Fecha");
				System.out.print("Escribe un mensaje: ");
				mensaje = lector.nextLine();
				int lon = mensaje.length();
				
				// Argumentos: mensaje en bytes, longitud mensaje, InetAddress del receptor,
				// puerto
				DatagramPacket paquete = new DatagramPacket(mensaje.getBytes(), lon, destino, 5000);
				
				// Enviamos el paquete a través del DatagramSocket
				ds.send(paquete);
				System.out.println("Enviado");
				
				// Recibimos
				byte[] datosRecibidos = new byte[200];
				DatagramPacket recibido = new DatagramPacket(datosRecibidos, 200);
				ds.receive(recibido);
				String texto = new String(datosRecibidos).trim();

				System.out.println(texto);
			}
			// Cerramos el socket Datagram.
			ds.close();
			System.out.println("Socket Datagram cerrado");
			
		} catch (SocketException | UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		lector.close();
	}
}
