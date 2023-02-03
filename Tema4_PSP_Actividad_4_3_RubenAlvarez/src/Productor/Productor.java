package Productor;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import Servidor.Cancion;
import Servidor.MusicaInterfazProductor;
import Servidor.MusicalInterfaceRMI;
import Servidor.MusicalRMI;

public class Productor {
	public static void main(String[] args) {
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry("localhost", 5055);
			System.out.println("Hemos obtenido el registro");
			String URL = "rmi://localhost:5055/ServicioMusica";
			MusicaInterfazProductor musicalRMI = (MusicaInterfazProductor) registry.lookup(URL);

			System.out.println("Hemos obtenido el objeto remoto");
			
			int menu = 0;
			do {
				System.out.println("---- Menu ----");
				System.out.println("1 - Añadir Cancion");
				System.out.println("2 - Mostrar Canciones");
				System.out.println("3 - Salir");
				
				menu = Utilidades.pedirEntero("Elige una opcion: ");
				
				switch (menu) {
				case 1: {
					Cancion cancion = new Cancion(
							Utilidades.pedirTexto("Titulo: "),
							Utilidades.pedirTexto("Banda: "),
							Utilidades.pedirTexto("Album: "),
							Utilidades.pedirEntero("Año: ")
					);
					musicalRMI.addMusica(cancion);
					break;
				}
				case 2: {
					for (Cancion cancion : musicalRMI.getMusica()) {
						System.out.println(cancion.toString());
					}
					break;
				}
				case 3: {
					System.out.println("**Saliendo de la aplicacion**");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + menu);
				}
			}while(menu!=3);
			
		} catch (RemoteException | NotBoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.exit(1);
	}
}