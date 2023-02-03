package Servidor;

import java.io.Serializable;

public class Cancion implements Serializable{
	//Atributos
	private String titulo;
	private String banda;
	private String album;
	private int year;
	
	//Constructor
	public Cancion(String titulo, String banda, String album, int year) {
		this.titulo = titulo;
		this.banda = banda;
		this.album = album;
		this.year = year;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getBanda() {
		return banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", banda=" + banda + ", album=" + album + ", year=" + year + "]";
	};
	
}
