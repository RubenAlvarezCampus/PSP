import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		
		System.out.println("Tabla del número: ");
		int n = lector.nextInt();
		System.out.println(n);
		
		for (int i = 1; i <= 10; i++) {
		System.out.println(n + " X " + i + " = " + (n * i));
		}
		lector.close();
		}
}
