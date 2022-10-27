public class Saludo {
	public static void main(String args[]) {
		System.out.println("Parametros: "+args.length);
		if (args.length==0) {
			System.out.println("No hay argumentos");
			System.exit(1);
		}

		System.out.println("----Con For----");
		for (int i=0;i<args.length;i++) {
			System.out.println("Hola "+args[i]);
		}

		System.out.println("----Con Foreach----");
		for (String nombre:args) {
			System.out.println("Hola "+nombre);
		}
	}
}