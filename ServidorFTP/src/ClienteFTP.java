import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ClienteFTP {
	public static void main(String[] args) {
		String user, password;
		Scanner sc = new Scanner(System.in);
		System.out.print("Usuario: ");
		user = sc.nextLine();
		System.out.print("Contraseña: ");
		password = sc.nextLine();

		// Creando nuestro objeto ClienteFTP
		FTPClient client = new FTPClient();
		// Datos para conectar al servidor FTP
		String ftp = "localhost";
		try {
			System.out.println("Nos conectamos");
			// Conactando al servidor
			client.connect(ftp);
			boolean loginOK = client.login(user, password);
			if (loginOK) {

				System.out.println("INFO: Login correcto");
				int opcion = 0;
				do {
					System.out.println("1 - Listar Archivos");
					System.out.println("2 - Subir archivo");
					System.out.println("3 - Descargar archivo");
					System.out.println("4 - Salir");
					opcion = Integer.parseInt(sc.nextLine());

					switch (opcion) {
					case 1: {
						FTPFile[] archivos = client.listFiles();
						for (FTPFile archivo : archivos) {
							System.out.println("Nombre: "+archivo.getName()+" Sice: "+archivo.getSize());
						}
;						break;
					}
					case 2: {
						String nombreSubida = sc.nextLine();
						client.setFileType(FTP.BINARY_FILE_TYPE); 
						client.enterLocalPassiveMode(); 
						FileInputStream fis = new FileInputStream(nombreSubida); 
						// Guardando el archivo en el servidor 
						boolean uploadFile = client.storeFile(nombreSubida,fis); 
						System.out.println("INFO: mensaje recibido al intentar subir un fichero"); System.out.println(client.getReplyString()); 
						if(uploadFile) { 
						 System.out.println("INFO: archivo subido correctamente"); }else { 
						 System.out.println("INFO: error al subir el archivo"); 
						}

						break;
					}
					case 3: {
						String nombreDescarga = sc.nextLine();
						client.setFileType(FTP.BINARY_FILE_TYPE);
						client.enterLocalPassiveMode();
						// Creamos objeto File con el nombre que tendra el archivo local
						File file = new File("archivoRecibido.txt");
						FileOutputStream out = new FileOutputStream(file);
						// Obtenemos el fichero del servidor nomina.txt
						client.retrieveFile(nombreDescarga, out);
						System.out.println("INFO: mensaje recibido al intentar descargar fichero");
						System.out.println(client.getReplyString());
						break;
					}
					case 4: {

						break;
					}
					default:

					}
				} while (opcion != 4);

			} else {
				System.out.println("ERROR: login rechazado");
				System.exit(-1);
			}
			System.out.println("INFO: conexion establecida, mensaje de bienvenida");
			System.out.println(client.getReplyString());
			System.out.println("INFO: directorio de trabajo");
			System.out.println(client.printWorkingDirectory());
			client.disconnect();
			System.out.println("INFO: cerramos la conexion con el servidor");
		} catch (IOException ioe) {
			System.out.println("Error al conectarnos al servidor");
		}
	}
}
