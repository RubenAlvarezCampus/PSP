package Actividad_3_2_Objetos_Sockets;

import java.io.Serializable;

public class Ejercicio_1_Persona implements Serializable{
	//Atributos
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private static int nextid;
	
	//Constructor
	public Ejercicio_1_Persona(String nombre, String apellido, int edad) {
		super();
		this.id = nextid;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		nextid++;
	}

	//Get y Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public static int getNextid() {
		return nextid;
	}

	public static void setNextid(int nextid) {
		Ejercicio_1_Persona.nextid = nextid;
	}

	//To String
	@Override
	public String toString() {
		return "Ejercicio_1_Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ "]";
	}
}
