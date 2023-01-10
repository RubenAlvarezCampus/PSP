package Ejercicio_6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class servidor {
	public static void main(String[] args) {
		try {
			InetSocketAddress direccion = new InetSocketAddress("localhost", 5000);
			DatagramSocket ds = new DatagramSocket(direccion);
			System.out.println("Preparado para recibir");

			String texto = "";
			byte[] mensaje = new byte[100];
			DatagramPacket carta = new DatagramPacket(mensaje, 100);
			ds.receive(carta);
			texto = new String(mensaje).trim();
			
			System.out.println("RECIBIDO DATAGRAMA DE: " + carta.getAddress() + "Puerto: " + carta.getPort());
			System.out.println("RECIBIDO: " + texto);
			
			//Comprobar si es primo
			int numero = Integer.parseInt(texto.trim());
			int divididos = 2;
			
			for (int i=1;i<=numero;i++) {
				if (numero % i == 0) {
					divididos--;
				}
			}
			
			//Resultado
			String res;
			if (divididos == 0) {
				res = "ES primo";
			} else {
				res = "NO es primo";
			}
			
			DatagramPacket respuesta = new DatagramPacket(res.getBytes(), res.length(), carta.getAddress(),carta.getPort());
			ds.send(respuesta);
			
			ds.close();
			System.out.println("Socket Datagram cerrado");
		} catch (SocketException | UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
