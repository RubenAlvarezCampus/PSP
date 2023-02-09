package Actividad_5_2_Ejercicio_1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class AlgoritmoAES {

	public static void main(String[] args) {
		try {
			ObjectInputStream fichero_clave = new ObjectInputStream(new FileInputStream("clave.raw"));
			SecretKey clave = (SecretKey) fichero_clave.readObject();
			
			Cipher descifrador = Cipher.getInstance("DES");
			descifrador.init(Cipher.ENCRYPT_MODE, clave);
			
			String mensajeOriginal = "Esto es un mensaje";
			byte[] bytesMensajeOriginal = mensajeOriginal.getBytes();
			byte[] bytesMensajeCifrado = descifrador.doFinal(bytesMensajeOriginal);
			
			String mensajeCifrado = new String(bytesMensajeCifrado);
			
			System.out.println("Mensaje Original: " + mensajeOriginal);
			System.out.println("Mensaje Cifrado: " + mensajeCifrado);
			
			System.out.println("");
			descifrador.init(Cipher.DECRYPT_MODE, clave);
			
			byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
			System.out.println("Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
		}
		catch (Exception e) {
			System.out.println("Archivo no encontrado");
		}
	}

}
