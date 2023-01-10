

public class MostrarDatos {

	public static void main(String[] args) {
		if (args.length!=2) {
			System.out.println("No hay 2 argumentos");
			System.exit(1);
		}
	
		try {
			Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.out.println("El segundo argumento no es un entero");
			System.exit(1);
		}
		
		System.out.println("Nombre: "+args[0]);
		System.out.println("Fecha de nacimiento: "+args[1]);
	}
}
