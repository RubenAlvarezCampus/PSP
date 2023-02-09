package Actividad_5_2_Ejercicio_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import Utilidades.Utilidades;

public class Principal {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Agenda agenda;
		File fichero = new File("agenda.dat");

		if (fichero.exists()) {
			agenda = leerFichero();
		} else {
			KeyGenerator generador = KeyGenerator.getInstance("DES");
			SecretKey clave = generador.generateKey();
			agenda = crearFichero(clave);
		}

		int opcion = 0;
		do {
			mostrarMenu();
			
			opcion = Utilidades.pedirEntero("Elegie una opción: ");
			switch (opcion) {
			case 1: 
				nuevoContacto(agenda);
				break;
			case 2: 
				borrarContacto(agenda);
				break;
			case 3: 
				break;
			case 4: 

				break;
			case 5: 

				break;
			default:
				System.out.println("Valor invalido: " + opcion);
			}
		} while (opcion != 5);
	}

	public static void mostrarMenu() {
		System.out.println("----- Menu -----");
		System.out.println("1- Añadir nuevo contacto");
		System.out.println("2- Borrar contacto");
		System.out.println("3- Consultar contacto");
		System.out.println("5- Listado de contactos");
		System.out.println("4- Terminar programa");
	}
	
	public static void nuevoContacto(Agenda agenda) {
		byte[] nombre = Utilidades.pedirTexto("Nombre: ").getBytes();
		byte[] telefono = Utilidades.pedirTexto("Telefono: ").getBytes()	;
		
		agenda.getContactos().add(new Contacto(nombre,telefono));
	}
	
	public static void borrarContacto(Agenda agenda) {
		String nombre = Utilidades.pedirTexto("Nombre: ");
		
		for (Contacto contacto: agenda.getContactos()) {
			if (contacto.getNombre().equals(nombre)) {
				agenda.getContactos().remove(contacto);
			}
		}
	}

	public static Agenda crearFichero(SecretKey clave) {
		try {
			Agenda agenda = new Agenda(clave);
			ObjectOutputStream fichero_agenda = new ObjectOutputStream(new FileOutputStream("agenda.dat"));

			fichero_agenda.writeObject(agenda);
			fichero_agenda.close();

			return agenda;
		} catch (Exception e) {

		}
		return null;
	}

	public static Agenda leerFichero() {
		try {
			ObjectInputStream fichero_agenda = new ObjectInputStream(new FileInputStream("agenda.dat"));
			Agenda agenda = (Agenda) fichero_agenda.readObject();
			return agenda;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
