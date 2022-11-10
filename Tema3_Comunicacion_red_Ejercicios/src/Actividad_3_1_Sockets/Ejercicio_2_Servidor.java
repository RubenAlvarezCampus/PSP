package Actividad_3_1_Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Ejercicio_2_Servidor {
	
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
			InputStream entrada = enchufeAlCliente.getInputStream();
			OutputStream salida = enchufeAlCliente.getOutputStream();
			String texto = "";
			
			//Recibimos el mensaje
			byte[] mensaje = new byte[100];
			entrada.read(mensaje);
			texto = new String(mensaje);
			
			//Comparamos el envio del servidor
			if (texto.trim().equals("1")) {
				salida.write(("La HORA atual es: "+genararHorar()).getBytes());
			}
			else if (texto.trim().equals("2")) {
				salida.write(("La FECHA atual es: "+genararFecha()).getBytes());
			}
			else {
				salida.write(("Opción Incorrecta").getBytes());
			}
			
			//Cerramos todos
			salida.close();
			entrada.close();
			enchufeAlCliente.close();
			servidor.close();
			
			System.out.println("Comunicación cerrada");
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
