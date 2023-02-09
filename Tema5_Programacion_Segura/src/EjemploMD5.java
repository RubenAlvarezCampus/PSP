import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EjemploMD5 {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String mensaje = "En un lugar de la Mancha, de cuyo nombre no quiero "
				+ "acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero,"
				+ "adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca que carnero,"
				+ "salpicón las más noches, duelos y quebrantos los sábados, lentejas los viernes, algún"
				+ "palomino de añadidura los domingos, consumían las tres partes de su hacienda.";

		// MessageDigest trabaja con cadenas de bytes:
		// debemos convertir los string en cadenas de bytes.
		byte[] bytesmensaje = mensaje.getBytes();
		// Creamos la instancia MessageDigest asociada al algoritmo hash.
		MessageDigest md = MessageDigest.getInstance("MD5");
		// Vamos actualizando el objeto con todos los mensajes
		// que queremos incluir en el resumen hash.
		md.update(bytesmensaje);
		// Ejecutamos el método digest para obtener el resumen.
		byte[] resumen = md.digest();
		System.out.println("Resumen hash: " + new String(resumen));
	}
}