package Depuracion;

import java.util.ArrayList;

public class Depuracion {

	public static void main(String[] args) {
		ArrayList<String> nombres = new ArrayList<>();
		nombres.add("Juan");
		nombres.add("Ana");
		nombres.add("Pedro");
		
		for(int i=0;i<nombres.size();i++) {
			System.out.println(nombres.get(i));
		}
	}

}
