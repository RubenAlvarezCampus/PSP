
public class Main {
	public static void main(String[] args) {
		int menu_principal = 0;
		do {
			System.out.println("------- Menu Principal --------");
			System.out.println("1 - Algoritmo Cesar");
			System.out.println("2 - MDAS");
			System.out.println("3 - SHA");
			System.out.println("4 - Salir");

			menu_principal = Utilidades.pedirEntero("Elige una opcion: ");
			switch (menu_principal) {
			case 1: {
				
				break;
			}
			case 2: {

				break;
			}
			case 3: {

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