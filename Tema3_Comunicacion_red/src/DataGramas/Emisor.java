package DataGramas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Emisor {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		try {
			DatagramSocket ds = new DatagramSocket();
			
			// Dirección IP del receptor
			InetAddress destino = InetAddress.getByName("localhost");
			String mensaje = "";
			
			while (!mensaje.equals("FIN")) {
				System.out.println("Escribe un mensaje: ");
				mensaje = lector.nextLine();
				int lon = mensaje.length();
				
				// Argumentos: mensaje en bytes, longitud mensaje, InetAddress del receptor,
				// puerto
				DatagramPacket paquete = new DatagramPacket(mensaje.getBytes(), lon, destino, 5000);
				
				// Enviamos el paquete a través del DatagramSocket
				ds.send(paquete);
				System.out.println("Enviado");
				
				byte[] datosRecibidos = new byte[100];
				DatagramPacket recibido = new DatagramPacket(datosRecibidos, 100);
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
