
public class CifradoCesar {
	public static void MenuCesar() {
		int menu = 0;
		String mensaje;
		
		do {
			System.out.println("------- Algoritmo Cesar --------");
			System.out.println("1 - Cifrar");
			System.out.println("2 - Descifrar");
			System.out.println("3 - Volver");
			
			menu = Utilidades.pedirEntero("Elige una opcion: ");
			switch (menu) {
			case 1: {
				mensaje = Utilidades.pedirTexto("Mensaje para cifrar: ");
				break;
			}
			case 2: {

				break;
			}
			case 3: {
				break;
			}
			default:
				System.out.println("**La opcion "+menu+" no es una opción valida**");
			}
		} while (menu != 4);
	}
}
