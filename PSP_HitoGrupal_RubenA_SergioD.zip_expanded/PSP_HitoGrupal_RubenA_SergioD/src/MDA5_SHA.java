import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MDA5_SHA {
	public static void Menu_MDA5_SHA1(String tipo_cifrado) {
		int menu = 0;
		String nombre;
		
		String email;
		String password;
		String datos = "";
		String datos_2 = "";

		do {
			if (tipo_cifrado.equals("MD5")) {
				nombre = "MDA5";
			}
			else {
				nombre = "SHA";
			}
			System.out.println("------- "+nombre+" --------");
			System.out.println("1 - Crear Credenciales");
			System.out.println("2 - Verificar la identidad");
			System.out.println("3 - Volver");

			menu = Utilidades.pedirEntero("Elige una opcion: ");
			switch (menu) {
			case 1: {
				//Datos
				email = validar_correo();
				password = Utilidades.pedirTexto("Contraseña: ");
				String nombre_archivo = Utilidades.pedirTexto("Dime el nombre del archivo: ");
				
				//Cifrado de mensaje
				datos = getHash(email+password, tipo_cifrado);
				
				//Crear archivo
				File file = new File( nombre_archivo+".txt");
				
				try {
					//Escribir en el archivo el mensaje
					FileWriter fw = new FileWriter(file);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(datos);
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		            
				System.out.println("Mensaje Cigrado: " + datos);
				break;
			}
			case 2: {
				//Datos
				email = validar_correo();
				password = Utilidades.pedirTexto("Contraseña: ");
				String nombre_archivo = Utilidades.pedirTexto("Dime el nombre del ARCHIVO con las credenciales: ");
				
				//Cifrar Datos
				datos = getHash(email+password,tipo_cifrado);
				
				//Encontrar archivo
				File file = new File( nombre_archivo+".txt");
				
				try {
					//Leer Archivo
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					datos_2 = br.readLine();
					br.close();
					
					//Comparamos
					if (datos.equals(datos_2)) {
						System.out.println("**Identeidad CONFIRMADA, usuario verificado**");
					} else {
						System.out.println("**Los Datos NO coinciden, indentidad NO verificada**");
					}
					
				} catch (IOException e1) {
					System.out.println("Archivo no encontrado");
				}
				break;
			}
			case 3: {
				break;
			}
			default:
				System.out.println("**La opcion " + menu + " no es una opción valida**");
			}
		} while (menu != 3);
	}
	
	public static String getHash(String txt,String tipo_cifrado) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(tipo_cifrado);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
            
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
	
	public static String validar_correo() {
		Matcher mather;
		
		// Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		
		while (true) {
	        // El email a validar
	        String email = Utilidades.pedirTexto("Email: ");
	 
	        mather = pattern.matcher(email);
	 
	        if (mather.find() == true) {
	            return email;
	        } else {
	            System.out.println("El email ingresado es inválido.");
	        }
		}
    }
}
