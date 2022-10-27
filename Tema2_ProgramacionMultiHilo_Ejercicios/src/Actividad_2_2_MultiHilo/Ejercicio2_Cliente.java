package Actividad_2_2_MultiHilo;

public class Ejercicio2_Cliente {
	/*Atributos*/
	private String nombre;
	private int[] lista;
	
	/*Constructor*/
	public Ejercicio2_Cliente(String nombre, int[] lista) {
		this.nombre = nombre;
		this.lista = lista;
	}

	/*Get y set*/
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getLista() {
		return lista;
	}

	public void setLista(int[] lista) {
		this.lista = lista;
	}
	
	
}
