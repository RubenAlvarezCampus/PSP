package DataGramas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Receptor {

	public static void main(String[] args) {
		try {
			InetSocketAddress direccion = new InetSocketAddress("localhost", 5000);
			DatagramSocket ds = new DatagramSocket(direccion);
			
			System.out.println("Preparado para recibir");
			
			String texto = "";
			int contador = 0;
			
			while (!texto.equals("FIN")) {
				contador++;
				
				byte[] mensaje = new byte[100];
				DatagramPacket carta = new DatagramPacket(mensaje, 100);
				ds.receive(carta);
				texto = new String(mensaje).trim();
				System.out.println("RECIBIDO DATAGRAMA DE: " + carta.getAddress() + " Puerto:" + carta.getPort());

				System.out.println("RECIBIDO: " + texto);
				String res = "Recibido mensaje nº " + contador;
				DatagramPacket respuesta = new DatagramPacket(res.getBytes(), res.length()+1,carta.getAddress(), carta.getPort());

				ds.send(respuesta);
			}
			ds.close();
			System.out.println("Socket Datagram cerrado");
		} catch (SocketException | UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
