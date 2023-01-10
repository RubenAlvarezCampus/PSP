package Ejercicio_4;

import java.util.concurrent.ThreadLocalRandom;

public class Coche extends Thread{
	private Aparcamiento aparcamiento;
	
	public Coche(String nombre,Aparcamiento aparcamiento) {
		super(nombre);
		this.aparcamiento = aparcamiento;
		this.start();
	}
	
	@Override
	public void run() {
		aparcamiento.disminuirPlazasDisponibles();
		int tiempo = ThreadLocalRandom.current().nextInt(5,11);
		System.out.println(this.getName()+" entra durante "+(tiempo)+" segundos");
		
		try {
			Coche.sleep(tiempo*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("");
		System.out.println(this.getName()+" saliendo ");
		aparcamiento.aumentarPlazasDisponibles();
	}
}
