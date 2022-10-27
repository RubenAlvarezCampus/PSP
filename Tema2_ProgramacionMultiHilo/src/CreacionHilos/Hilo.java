package CreacionHilos;

import java.util.Scanner;

public class Hilo extends Thread{
	@Override
	public void run() {
		System.out.println("Hola soy un hilo");
		Scanner scan = new Scanner(System.in);
		System.out.println("Dime un texto");
		String texto = scan.nextLine();
	}
}
