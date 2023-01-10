package Ejercicio_5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {
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
			
			// Abrirmos los flujos de entrada y salida para las comunicaciones.
			InputStream entrada = enchufeAlCliente.getInputStream();
			OutputStream salida = enchufeAlCliente.getOutputStream();
			String texto = "";
			
			// Con la funcion trim eliminamos los espacios en blanco en ambos extremos del
			// string
			byte[] mensaje = new byte[100];
			// Lee mensaje del cliente (array de bytes)
			entrada.read(mensaje);
			texto = new String(mensaje);
			System.out.println("Cliente dice: " + texto);
			
			//Comprobar si es primo
			int numero = Integer.parseInt(texto.trim());
			int divididos = 2;
			
			for (int i=1;i<=numero;i++) {
				System.out.println(i);
				if (numero % i == 0) {
					divididos--;
				}
			}
			
			//Resultado
			if (divididos == 0) {
				salida.write("Es primo".getBytes());
			} else {
				salida.write(("No es primo").getBytes());
			}
			
			entrada.close();
			salida.close();
			enchufeAlCliente.close();
			servidor.close();
			System.out.println("Comunicación cerrada");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
