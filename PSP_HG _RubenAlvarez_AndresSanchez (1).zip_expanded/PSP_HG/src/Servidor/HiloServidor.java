package Servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

import Datos.Juego;

public class HiloServidor extends Thread{
	private static int contador = 1;
	private Socket enchufeAlJuego;
	
	public HiloServidor(Socket enchufeAlJuego) {
		super("Hilo "+contador);
		this.enchufeAlJuego = enchufeAlJuego;
		contador++;
		this.start();
	}
	
	@Override
	public void run() {
		try {
			// Abrirmos los flujos de salida para las comunicaciones.
			InputStream entrada = enchufeAlJuego.getInputStream();
			String consulta = "";
			List<Juego> juegos = null;
			
			while (true) {
				//Recibimos el mensaje
				byte[] mensaje = new byte[100];
				entrada.read(mensaje);
				consulta = (new String(mensaje)).trim();
			
				if (consulta.equalsIgnoreCase("salir")) {
					//Cerramos todo
					entrada.close();
					enchufeAlJuego.close();
					System.out.println("");
					System.out.println("Cliente desconectado");
					return;
				}
				else {
					juegos = Datos.AccesoDatos.Consulta(consulta);
				}

				ObjectOutputStream outOb = new ObjectOutputStream(enchufeAlJuego.getOutputStream());
				outOb.writeObject(juegos); //enviando un objeto
			}
				
		} catch (IOException e) {
			System.out.println("");
			System.out.println("Cliente desconectado");
		}
	}
}
