import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Protocola_HTTP {

	public static void main(String[] args) {
		try {
			String urlStr = "https://www.google.es/";
			URL url = new URL(urlStr);
			URLConnection urlConn = url.openConnection();
			System.out.println("Información de " + urlStr);
			System.out.println("-----------------------");
			System.out.println("Codificación: ");
			System.out.println(urlConn.getContentEncoding());
			System.out.println("Longitud (int): " + urlConn.getContentLength());
			System.out.println("Longitud (long): " + urlConn.getContentLengthLong());

			System.out.println("Tipo (long): " + urlConn.getContentType());
			System.out.println("Fecha (EPOCHB): " + urlConn.getDate());
			System.out.println("Expira (EPOCH): " + urlConn.getExpiration());
			System.out.println("Todas las cabeceras para: " + urlStr);
			System.out.println("-----------------------");
			Map<String, List<String>> cabeceras = urlConn.getHeaderFields();
			Iterator<Map.Entry<String, List<String>>> itCab

					= cabeceras.entrySet().iterator();
			while (itCab.hasNext()) {
				Map.Entry<String, List<String>> unaCab = itCab.next();
				System.out.println("[" + unaCab.getKey());
				List<String> valCab = unaCab.getValue();
				boolean primerVal = true;
				for (String unValor : valCab) {
					if (!primerVal) {
						System.out.print("|");
					}
					System.out.print(unValor);
					primerVal = false;
				}
				System.out.println("]");
			}
		} catch (IOException ex) {
			System.out.printf("Error de E/S obteniendo contenidos de URL.in");
			ex.printStackTrace();
		}
	}
}
