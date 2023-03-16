package Cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Servidor.ChatInterfazRMI;

public class Cliente {
	public static void main(String[] args) {
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry("localhost", 5055);
			System.out.println("Hemos obtenido el registro");
			String URL = "rmi://localhost:5055/Chat";
			ChatInterfazRMI ChatRMI = (ChatInterfazRMI) registry.lookup(URL);

			System.out.println("Hemos obtenido el objeto remoto");
			
			int menu = 0;
			do {
				System.out.println("---- Menu ----");
				System.out.println("1 - Acceder al chat");
				System.out.println("2 - Salir");
				
				menu = Utilidades.pedirEntero("Elige una opcion: ");
				
				switch (menu) {
				case 1: {
					String usuario = Utilidades.pedirTexto("Usuario: ");
					
					if (ChatRMI.Login(usuario)){
						int menu_chat;
						
						do {
							System.out.println("---- Menu ----");
							System.out.println("1 - Enviar Mensaje");
							System.out.println("2 - Mostrar Mensaje");
							System.out.println("3 - Salir");
							
							menu_chat = Utilidades.pedirEntero("Elige una opcion: ");
							
							switch (menu_chat) {
							case 1: {
								String mensaje = Utilidades.pedirTexto("Mensaje: ");
								ChatRMI.EnviarMensaje(usuario, mensaje);
								break;
							}
							case 2: {
								for (String mensaje : ChatRMI.MostrarMensajes()) {
									System.out.println(mensaje);
								}
								break;
							}	
							case 3: {
								System.out.println("**Saliendo**");
								ChatRMI.Salir(usuario);
								break;
							}	
							default:
								System.out.println("Opcion no valida");
							}
						}while(menu_chat!=3);
						
					} else {
						System.out.println("Usuario conectado, elige otro nombre");
					}
					
					break;
				}
				case 2: {
					System.out.println("**Saliendo de la aplicacion**");
					break;
				}	
				default:
					System.out.println("Opcion no valida");
				}
			}while(menu!=2);
			
		} catch (RemoteException | NotBoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.exit(1);
	}
}