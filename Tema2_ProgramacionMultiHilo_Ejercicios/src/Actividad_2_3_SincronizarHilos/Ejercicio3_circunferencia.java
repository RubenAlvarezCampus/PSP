package Actividad_2_3_SincronizarHilos;

public class Ejercicio3_Circunferencia {
	private int radio;

	public Ejercicio3_Circunferencia(int radio) {
		super();
		this.radio = radio;
	}
	
	public void mostrar() {
		System.out.println("El radio es: "+this.radio);
		System.out.println("Perimetro: "+(2 *radio* Math.PI));
		System.out.println("Area: "+(2 * Math.PI*Math.pow(radio,2)));
	}
}
