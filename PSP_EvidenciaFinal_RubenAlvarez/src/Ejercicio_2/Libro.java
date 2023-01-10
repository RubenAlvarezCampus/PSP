package Ejercicio_2;

public class Libro {
	private static int id;
	private String nombre;
	private String autor;
	
	public Libro(int id, String nombre, String autor) {
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", autor=" + autor + "]";
	}
}
