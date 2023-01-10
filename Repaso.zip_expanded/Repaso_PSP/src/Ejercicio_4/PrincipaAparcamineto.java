package Ejercicio_4;

public class PrincipaAparcamineto {

	public static void main(String[] args) {
		Aparcamiento aparcamiento = new Aparcamiento(3);
		
		Coche Coche_1 = new Coche("Coche_1",aparcamiento);
		Coche Coche_2 = new Coche("Coche_2",aparcamiento);
		Coche Coche_3 = new Coche("Coche_3",aparcamiento);
		Coche Coche_4 = new Coche("Coche_4",aparcamiento);
		Coche Coche_5 = new Coche("Coche_5",aparcamiento);
		
	}
}
