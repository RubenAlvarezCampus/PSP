package Actividad_5_2_Ejercicio_1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AlmacenarCalveSecreta {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println("Paso 1: Se obtiene el generador de claves");
		KeyGenerator generador = KeyGenerator.getInstance("DES");
		System.out.println("Paso 2: Se obtiene la clave");
		SecretKey clave = generador.generateKey();
		System.out.println("Clave generada");

		try {
			ObjectOutputStream fichero_clave = new ObjectOutputStream(new FileOutputStream("clave.raw"));
			fichero_clave.writeObject(clave);
			fichero_clave.close();
			System.out.println("Clave guardada");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
