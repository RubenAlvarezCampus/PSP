package Servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
	public static void main(String[] args) {
		String host  = "localhost";
		int puerto = 5055;
		
		try {
			// Creamos registro de los objetos remotos
			Registry registro = LocateRegistry.createRegistry(puerto);
			
			// Crear un objeto de tipo OperacionesImplementacion
			MusicalRMI musicalRMI = new MusicalRMI();

			String URL = "rmi://" + host + ":" + puerto + "/ServicioMusica";

			// Registramos el nuevo objeto,
			registro.rebind(URL, musicalRMI);

			System.out.println("Registrado en " + host + ":" + puerto);
			
		} catch (RemoteException e) {
			System.out.println("No se ha podido registrar el servicio");
			System.out.println(e.getMessage());
		}
	}
}
