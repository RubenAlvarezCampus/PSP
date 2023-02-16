package Actividad_5_2_Ejercicio_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import Utilidades.Utilidades;

public class Principal {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		Agenda agenda;
		File fichero = new File("agenda.dat");

		if (fichero.exists()) {
			agenda = leerFichero();
		} else {
			KeyGenerator generador = KeyGenerator.getInstance("DES");
			SecretKey clave = generador.generateKey();
			agenda = new Agenda(clave);
			agenda = crearFichero(agenda);
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
				consultarContacto(agenda);
				break;
			case 4: 
				listadoContactos(agenda);
				break;
			case 5: 
				System.out.println("**Saliendo del programa**");
				crearFichero(agenda);
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
		System.out.println("4- Listado de contactos");
		System.out.println("5- Terminar programa");
	}
	
	public static void nuevoContacto(Agenda agenda) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		byte[] nombre = cifrar(Utilidades.pedirTexto("Nombre: "), agenda.getClave());
		byte[] telefono = cifrar(Utilidades.pedirEntero("Telefono: ")+"", agenda.getClave());
		

		agenda.getContactos().add(new Contacto(nombre,telefono));
	}
	
	public static void borrarContacto(Agenda agenda) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		String nombre = Utilidades.pedirTexto("Nombre: ");
		
		for (Contacto contacto: agenda.getContactos()) {
			if (new String(descifrar(contacto.getNombre(),agenda.getClave())).equals(nombre)) {
				agenda.getContactos().remove(contacto);
				System.out.println("**Contacto eliminado correctamente**");
				return;
			}
		}
		System.out.println("**Contacto no encontrado**");
	}
	
	public static void consultarContacto(Agenda agenda) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		String nombre = Utilidades.pedirTexto("Nombre: ");
		
		for (Contacto contacto : agenda.getContactos()) {
			if (new String(descifrar(contacto.getNombre(),agenda.getClave())).equals(nombre)) {
				System.out.println("-----------------------");
				System.out.println("Nombre: "+new String(descifrar(contacto.getNombre(),agenda.getClave())));
				System.out.println("Telefono: "+new String(descifrar(contacto.getTelefono(),agenda.getClave())));
				System.out.println("-----------------------");
				return;
			}
		}
	}
	
	public static void listadoContactos (Agenda agenda) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		for (Contacto contacto : agenda.getContactos()) {
			System.out.println("-----------------------");
			System.out.println("Nombre: "+new String(descifrar(contacto.getNombre(),agenda.getClave())));
			System.out.println("Telefono: "+new String(descifrar(contacto.getTelefono(),agenda.getClave())));
			System.out.println("-----------------------");
		}
	}

	public static Agenda crearFichero(Agenda agenda) {
		try {
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
			fichero_agenda.close();
			return agenda;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] cifrar (String texto, SecretKey clave) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cifrador = Cipher.getInstance("DES");
		cifrador.init(Cipher.ENCRYPT_MODE, clave);
		
		byte[] bytesMensajeOriginal =texto.getBytes();
		byte[] bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal);
		
		return bytesMensajeCifrado;
	}
	
	public static byte[] descifrar (byte[] texto, SecretKey clave) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher descifrador = Cipher.getInstance("DES");
		descifrador.init(Cipher.DECRYPT_MODE, clave);
		
		byte[] bytesMensajeDescifrado = descifrador.doFinal(texto);
		return bytesMensajeDescifrado;
	}
}
