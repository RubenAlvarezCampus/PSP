package Actividad_3_2_Objetos_Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Ejercicio_1_Servidor {
	//ArrayList
	public static ArrayList<Ejercicio_1_Persona> personas = new ArrayList<>();
	
	public static void cargaInicial() {
		Ejercicio_1_Persona persona1 = new Ejercicio_1_Persona("Rubén","Álvarez",20);
		Ejercicio_1_Persona persona2 = new Ejercicio_1_Persona("Ismael","Plata",22);
		Ejercicio_1_Persona persona3 = new Ejercicio_1_Persona("Samuel","Arnaiz",26);
		
		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);
	}
	
	public static Ejercicio_1_Persona getPersona(int id) {
		for (Ejercicio_1_Persona persona : personas) {
			if (persona.getId()==id) {
				return persona;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		//Inicializamos personas
		cargaInicial();
		
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
			Socket enchufeAlPersona = servidor.accept();
			System.out.println("Comunicación entrante");
			
			// Abrirmos los flujos de salida para las comunicaciones.
			InputStream entrada = enchufeAlPersona.getInputStream();
			OutputStream salida = enchufeAlPersona.getOutputStream();
			String texto = "";
			
			//Recibimos el mensaje
			byte[] mensaje = new byte[100];
			entrada.read(mensaje);
			texto = new String(mensaje);
			
			Ejercicio_1_Persona persona = getPersona(Integer.parseInt(texto.trim()));
			
			ObjectOutputStream outOb = new ObjectOutputStream(enchufeAlPersona.getOutputStream());
			outOb.writeObject(persona); //enviando un objeto
			
			//Cerramos todos
			salida.close();
			entrada.close();
			enchufeAlPersona.close();
			servidor.close();
			
			System.out.println("Comunicación cerrada");
			
		} catch (SocketException | UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
