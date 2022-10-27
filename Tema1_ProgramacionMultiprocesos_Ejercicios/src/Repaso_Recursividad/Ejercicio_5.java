package Repaso_Recursividad;

public class Ejercicio_5 {

	public static int nips (int n) {
		if (n<1) {
			return 1;
		}
		else {
			return nips(n-1)+nips(n-2)+nips (n-3);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(nips(2));
	}
}
