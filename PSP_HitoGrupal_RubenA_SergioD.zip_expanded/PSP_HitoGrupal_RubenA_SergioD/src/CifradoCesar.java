import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CifradoCesar {
	public static void MenuCesar() {
		int menu = 0;
		String mensaje = "";
		int codigo;

		do {
			System.out.println("------- Algoritmo Cesar --------");
			System.out.println("1 - Cifrar");
			System.out.println("2 - Descifrar");
			System.out.println("3 - Volver");

			menu = Utilidades.pedirEntero("Elige una opcion: ");
			switch (menu) {
			case 1: {
				//Pedir datos
				mensaje = Utilidades.pedirTexto("Mensaje para cifrar: ");
				codigo = Utilidades.pedirEntero("Introduce el codigo: ");
				String nombre_archivo = Utilidades.pedirTexto("Dime el nombre del archivo: ");
				
				//Crear archivo
				File file = new File( nombre_archivo+".txt");
				//Cifrado de mensaje
				mensaje = cifradoCesar(mensaje, codigo);
				
				try {
					//Escribir en el archivo el mensaje
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(mensaje);
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		            
				System.out.println("Mensaje Cigrado: " + mensaje +", Con clave: "+codigo);
				break;
			}
			case 2: {
				//Pedir datos
				String nombre_archivo = Utilidades.pedirTexto("Dime el nombre del ARCHIVO: ");
				codigo = Utilidades.pedirEntero("Introduce el codigo: ");
				
				//Encontrar archivo
				File file = new File( nombre_archivo+".txt");
				
				try {
					//Leer Archivo
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					mensaje = br.readLine();
					br.close();
					
					//Descifrar Archivo
					mensaje = descifradoCesar(mensaje, codigo);
					System.out.println("Mensaje Descigrado: " + mensaje);
					
				} catch (IOException e1) {
					System.out.println("Archivo no encontrado");
				}
				break;
			}
			case 3: {
				System.out.println("**Volviendo**");
				break;
			}
			default:
				System.out.println("**La opcion " + menu + " no es una opción valida**");
			}
		} while (menu != 3);
	}

	public static String cifradoCesar(String texto, int codigo) {

		StringBuilder cifrado = new StringBuilder();
		codigo = codigo % 26;

		for (int i = 0; i < texto.length(); i++) {
			cifrado.append((char) (texto.charAt(i) + codigo));
		}
		return cifrado.toString();
	}

	public static String descifradoCesar(String texto, int codigo) {

		StringBuilder cifrado = new StringBuilder();
		codigo = codigo % 26;

		for (int i = 0; i < texto.length(); i++) {
			cifrado.append((char) (texto.charAt(i) - codigo));
		}
		return cifrado.toString();
	}

}
