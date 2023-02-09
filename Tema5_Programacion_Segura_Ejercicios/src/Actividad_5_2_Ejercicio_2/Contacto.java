package Actividad_5_2_Ejercicio_2;

import java.io.Serializable;
import java.util.Arrays;

public class Contacto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// Atributos
	public byte[] nombre;
	public byte[] telefono;

	// Constructor
	public Contacto(byte[] nombre, byte[] telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public byte[] getNombre() {
		return nombre;
	}

	public void setNombre(byte[] nombre) {
		this.nombre = nombre;
	}

	public byte[] getTelefono() {
		return telefono;
	}

	public void setTelefono(byte[] telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + Arrays.toString(nombre) + ", telefono=" + Arrays.toString(telefono) + "]";
	}

}
