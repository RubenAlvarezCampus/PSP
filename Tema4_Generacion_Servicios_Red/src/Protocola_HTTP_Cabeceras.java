import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Protocola_HTTP_Cabeceras {

	public static void main(String[] args) {
		try {
			String urlStr = "https://www.google.es/";
			URL url = new URL(urlStr);
			InputStream is = url.openConnection().getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Contenidos de " + urlStr);

			System.out.println("======================================");

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException ex) {
			System.out.println("Error de E/S obteniendo contenidos de URL");
			ex.printStackTrace();
		}
	}
}
