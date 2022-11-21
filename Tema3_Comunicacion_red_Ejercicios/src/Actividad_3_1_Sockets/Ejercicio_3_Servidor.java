package Actividad_3_1_Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Ejercicio_3_Servidor {
	
	public static String genararHorar() {
		LocalDateTime hora = LocalDateTime.now();	
		return hora.getHour()+":"+hora.getMinute()+":"+hora.getSecond();
	}

	public static String genararFecha() {
		Date fecha = new Date();	
		return new SimpleDateFormat("dd-MM-yyyy").format(fecha);
	}
	
	public static void main(String[] args) {
		System.out.println(" APLICACIÓN DE SERVIDOR ");
		System.out.println("----------------------------------");
		
		try {
			InetSocketAddress direccion = new InetSocketAddress("localhost", 5000);
			DatagramSocket ds = new DatagramSocket(direccion);
			
			System.out.println("Preparado para recibir");
			
			String texto = "";
			
			while (!texto.equals("FIN")) {

				byte[] mensaje = new byte[200];
				DatagramPacket menu = new DatagramPacket(mensaje, 200);
				ds.receive(menu);
				
				texto = new String(mensaje).trim();
				System.out.println("RECIBIDO DATAGRAMA DE: " + menu.getAddress() + " Puerto:" + menu.getPort());
				
				DatagramPacket respuesta;
				System.out.println("RECIBIDO: " + texto);
				String res;
				
				if (texto.equals("1")) {
					res = "La HORA atual es: "+genararHorar();

				}else if(texto.equals("2")) {
					res = "La FECHA atual es: "+genararFecha();
				}
				else if(texto.equals("FIN")) {
					res = "Cerrando el Programa ";
				}
				else {
					res = "Opción incorrecta, elige otra ";
				}
		
				respuesta = new DatagramPacket(res.getBytes(),res.length(),menu.getAddress(),menu.getPort());
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
