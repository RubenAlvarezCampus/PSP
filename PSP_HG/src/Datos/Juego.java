package Datos;

import java.io.Serializable;

public class Juego implements Serializable{
	
	//Atributos
	private int id;
	private String titulo;
	private String genero;
	private float precio;
	private String formato;
	private String plataforma;
	private int valoracion;
	private boolean stock;
	
	//Constructor
	public Juego(int id, String titulo, String genero, float precio, String formato, String plataforma, int valoracion, boolean stock) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.precio = precio;
		this.formato = formato;
		this.plataforma = plataforma;
		this.valoracion = valoracion;
		this.stock = stock;
	}

	//ToString
	@Override
	public String toString() {
		return "Juego [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", precio=" + precio + ", formato="
				+ formato + ", plataforma=" + plataforma + ", valoracion=" + valoracion + ", stock=" + stock + "]";
	}

	//Get y Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}
	
}
