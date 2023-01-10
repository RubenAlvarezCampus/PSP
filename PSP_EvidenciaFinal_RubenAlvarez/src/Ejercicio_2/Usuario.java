package Ejercicio_2;

import java.util.concurrent.ThreadLocalRandom;

public class Usuario extends Thread{
	private Biblioteca biblioteca;
	private static int contador = 1;
	
	public Usuario(Biblioteca biblioteca) {
		super("Usuario "+contador);
		contador++;
		this.biblioteca=biblioteca;
		this.start();
	}

	@Override
	public void run() {
		while (biblioteca.hayLibrosDisponibles()==false);
		
		Libro libro = biblioteca.sacarLibro();
		
		int tiempo = ThreadLocalRandom.current().nextInt(2,11);
		System.out.println(this.getName()+" saca el "+libro.toString()+" durante "+(tiempo)+" segundos");
		
		try {
			sleep(tiempo*1000);
			System.out.println(this.getName()+" devuelve el "+libro.toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		biblioteca.devolverLibro(libro);
	}
}
