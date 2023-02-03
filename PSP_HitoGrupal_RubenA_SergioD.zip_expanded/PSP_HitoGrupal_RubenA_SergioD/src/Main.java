
public class Main {
	public static void main(String[] args) {
		int menu_principal = 0;
		String tipo_cifrado = "";
		do {
			System.out.println("------- Menu Principal --------");
			System.out.println("1 - Algoritmo Cesar");
			System.out.println("2 - MDA5");
			System.out.println("3 - SHA");
			System.out.println("4 - Salir");

			menu_principal = Utilidades.pedirEntero("Elige una opcion: ");
			switch (menu_principal) {
			case 1: {
				CifradoCesar.MenuCesar();
				break;
			}
			case 2: {
				tipo_cifrado = "MD5";
				MDA5_SHA.Menu_MDA5_SHA1(tipo_cifrado);
				break;
			}
			case 3: {
				tipo_cifrado = "SHA1";
				MDA5_SHA.Menu_MDA5_SHA1(tipo_cifrado);
				break;
			}
			case 4: {
				System.out.println("**Saliedo del programa, gracias por su tiempo**");
				break;
			}
			default:
				System.out.println("**La opcion "+menu_principal+" no es una opción valida**");
			}
		} while (menu_principal != 4);
	}
}