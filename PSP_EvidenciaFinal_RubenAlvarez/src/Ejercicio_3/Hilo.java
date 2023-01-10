package Ejercicio_3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Hilo implements Runnable {
	private Thread hilo;
	private static int numCliente = 1;
	private Socket enchufeAlCliente;

	public Hilo(Socket cliente) {
		hilo = new Thread(this, "Cliente " + numCliente);
		numCliente++;
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
			byte[] mensaje = new byte[100];
			entrada.read(mensaje);
			texto = new String(mensaje);
			System.out.println(hilo.getName()+" dice: " + texto);

			int numero = Integer.parseInt(texto.trim());
			int total = 1;

			for (int i = numero; i >= 1; i--) {
				total = total*i;
			}

			// Resultado 
			salida.write(("El factorial es: "+total).getBytes());

			entrada.close();
			salida.close();
			enchufeAlCliente.close();
			System.out.println("Comunicación cerrada "+hilo.getName());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
