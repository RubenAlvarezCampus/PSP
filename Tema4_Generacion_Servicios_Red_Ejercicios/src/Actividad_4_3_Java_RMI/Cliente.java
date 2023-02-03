package Actividad_4_3_Java_RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import Utilidades.Utilidades;

public class Cliente {
	public static void main(String[] args) {
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry("localhost", 5055);
			System.out.println("Hemos obtenido el registro");
			String URL = "rmi://localhost:5055/ServicioMusica";
			MusicalRMI musicalRMI = new MusicalRMI();
			registry.lookup(URL);

			System.out.println("Hemos obtenido el objeto remoto");
			
			int menu = 0;
			do {
				System.out.println("---- Menu ----");
				System.out.println("1 - Buscar por titulo");
				System.out.println("2 - Buscar por banda");
				System.out.println("3 - Buscar por albun");
				System.out.println("4 - Buscar por año");
				System.out.println("4 - Salir");
				
				menu = Utilidades.pedirEntero("Elige una opcion: ");
				
				switch (menu) {
				case 1: {
					mostrar(musicalRMI.buscarTitulo(Utilidades.pedirTexto("Dime el titulo: ")));
					break;
				}
				case 2: {
					mostrar(musicalRMI.buscarBanda(Utilidades.pedirTexto("Dime la banda: ")));
					break;
				}
				case 3: {
					mostrar(musicalRMI.buscarAlbum(Utilidades.pedirTexto("Dime el album: ")));
					break;
				}
				case 4: {
					mostrar(musicalRMI.buscarProducido(Utilidades.pedirEntero("Dime el año: ")));
					break;
				}
				case 5: {
					System.out.println("**Saliendo de la aplicacion**");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + menu);
				}
			}while(menu!=5);
			
		} catch (RemoteException | NotBoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void mostrar(ArrayList<Cancion> canciones) {
		for (Cancion cancion : canciones) {
			System.out.println(cancion.toString());
		}
	}
}