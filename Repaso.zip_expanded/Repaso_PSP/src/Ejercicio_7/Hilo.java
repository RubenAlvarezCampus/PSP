package Ejercicio_7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Hilo implements Runnable {
	private Thread hilo;
	private static int numCliente = 0;
	private Socket enchufeAlCliente;

	public Hilo(Socket cliente) {
		numCliente++;
		hilo = new Thread(this, "Cliente" + numCliente);
		this.enchufeAlCliente = cliente;
		hilo.start();
	}

	@Override
	public void run() {
		try {
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
			System.out.println("Cliente "+numCliente+" dice: " + texto);

			// Comprobar si es primo
			int numero = Integer.parseInt(texto.trim());
			int divididos = 2;

			for (int i = 1; i <= numero; i++) {
				if (numero % i == 0) {
					divididos--;
				}
			}

			// Resultado
			if (divididos == 0) {
				salida.write("Es primo".getBytes());
			} else {
				salida.write(("No es primo").getBytes());
			}

			entrada.close();
			salida.close();
			enchufeAlCliente.close();
			System.out.println("Comunicación cerrada Cliente "+numCliente);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
