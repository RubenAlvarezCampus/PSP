import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class EjemploDES {
	public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
		IllegalBlockSizeException, BadPaddingException {
		
		System.out.println("Probando sistema de encriptación con algoritmo DES");
		System.out.println("Paso 1: Se obtiene el generador de claves");
		KeyGenerator generador = KeyGenerator.getInstance("DES");
		System.out.println("Paso 2: Se obtiene la clave");
		SecretKey clave = generador.generateKey();
		System.out.println("Paso 3: Obtenemos el descifrador");
		Cipher descifrador = Cipher.getInstance("DES");
		System.out.println("Paso 4: Configuramos el descifrador");
		descifrador.init(Cipher.ENCRYPT_MODE, clave);
		String mensajeOriginal = "La cripta mágica";
		byte[] bytesMensajeOriginal = mensajeOriginal.getBytes();
		byte[] bytesMensajeCifrado = descifrador.doFinal(bytesMensajeOriginal);
		String mensajeCifrado = new String(bytesMensajeCifrado);
		System.out.println("Mensaje Original: " + mensajeOriginal);
		System.out.println("Mensaje Cifrado: " + mensajeCifrado);
		System.out.println("Desciframos el mensaje cifrado para comparar con original");
		descifrador.init(Cipher.DECRYPT_MODE, clave);
		byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
		System.out.println("Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
	}
}