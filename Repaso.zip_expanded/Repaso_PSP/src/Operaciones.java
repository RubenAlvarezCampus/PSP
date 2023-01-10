

public class Operaciones {
	public static void main(String[] args) {
		Float num1 = Float.parseFloat(args[0]);
		Float num2 = Float.parseFloat(args[1]);
		
		System.out.println(num1+" + "+num2+" = "+(num1+num2));
		System.out.println(num1+" - "+num2+" = "+(num1-num2));
		System.out.println(num1+" * "+num2+" = "+(num1*num2));
		if (num2!=0) {
			System.out.println(num1+" / "+num2+" = "+(num1/num2));
		}
		else {
			System.out.println("No ser puede dividir entre 0");
		}
	}
}
