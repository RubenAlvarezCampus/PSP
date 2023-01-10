package Ejercicio_2;

import java.util.LinkedList;
import java.util.Queue;

public class Biblioteca {
	private Queue<Libro> libros;

	public Biblioteca() {
		this.libros =  new LinkedList<Libro>();
		this.libros.add(new Libro(1,"Nacidos de la bruma","Ruben Alvarez"));
	}
	
	public synchronized boolean hayLibrosDisponibles() {
		if (libros.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
	
	public synchronized Libro sacarLibro() {
		Libro libro = libros.remove();
		return libro;
	}
	
	public synchronized void devolverLibro(Libro libro) {
		libros.add(libro);
		notifyAll();
	}
}
