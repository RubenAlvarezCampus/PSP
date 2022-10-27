import java.time.LocalDate;
import java.time.LocalDateTime;

public class Ejercicio_4_Triangulo {
	public static void main(String[] args) {
		if (args.length==1) {
			long base= Long.parseLong(args[0]);
			System.out.println(LocalDateTime.now());
			System.out.println("");
			
			for (long y=base;y>0;y--) {
				for (long x=1;x<=y;x++) {
					System.out.print(x);
				}
				System.out.println("");
			}
			
			System.out.println("");
			System.out.println(LocalDateTime.now());
		}
		else {
			System.out.println("Argumentos incorrectos");
		}
	}
}
