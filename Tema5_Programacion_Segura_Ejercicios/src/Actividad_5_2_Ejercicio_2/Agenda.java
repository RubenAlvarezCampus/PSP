package Actividad_5_2_Ejercicio_2;

import java.io.Serializable;
import java.util.ArrayList;

import javax.crypto.SecretKey;

public class Agenda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Contacto> contactos = new ArrayList<>();
	private SecretKey clave;
	
	public Agenda(SecretKey clave) {
		this.clave = clave;
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}
	
}
