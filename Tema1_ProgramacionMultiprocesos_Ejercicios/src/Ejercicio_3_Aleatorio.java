import java.util.Random;

public class Ejercicio_3_Aleatorio {
	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(11);
		System.out.println("Aleatorio: "+num);
	}
}
