package Actividad_1_2_Multoproceso;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio_2 {

	public static void main(String[] args) {
		if(args.length!=1) {
			System.out.println("El numero de argumentos no es correcto");
			System.exit(1);
		}
		else {
			String ruta = args[0];
			File c_ruta = new File(ruta);
			
			if (c_ruta.exists()==false) {
				System.out.println("La ruta no existe");
				System.exit(2);
			}
			else if (c_ruta.isDirectory()==false) {
				System.out.println("La ruta no es un directorio");
				System.exit(3);
			}
			else {
				ProcessBuilder proceso = new ProcessBuilder("cmd","/C","dir",ruta);
				try {
					Process p = proceso.start();
					InputStream is = p.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					
					String linea;
					int numerada = 1;
					while ((linea=br.readLine())!=null) {
						System.out.println(numerada+"   "+linea);
						numerada++;
					}
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
