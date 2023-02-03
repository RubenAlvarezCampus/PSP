package Actividad_4_3_Java_RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MusicalRMI extends UnicastRemoteObject implements MusicalInterfaceRMI {
	
	//Atributos
	private ArrayList<Cancion> canciones = new ArrayList<>();
	private static final long serialVersionUID = 1L;

	//Contructor
	protected MusicalRMI() throws RemoteException {
		super();
		this.canciones.add(new Cancion("bzrp sesion #53", "bizarrap", "Single", 2023));
		this.canciones.add(new Cancion("Mi carro me lo robaron", "Manolo Escobar", "Canciones de pueblo MIX 2012", 2012));
		this.canciones.add(new Cancion("Thinking out loud", "Ed Sheeran", "+", 2015));
	}

	//Metodos
	@Override
	public ArrayList<Cancion> buscarTitulo(String titulo) {
		ArrayList<Cancion> resultados =  new ArrayList<>();
		
		for (Cancion cancion : this.canciones) {
			if (cancion.getTitulo().equals(titulo)) {
				resultados.add(cancion);
			}
		}
		return resultados;
	}

	@Override
	public ArrayList<Cancion> buscarBanda(String banda) {
		ArrayList<Cancion> resultados =  new ArrayList<>();
		
		for (Cancion cancion : this.canciones) {
			if (cancion.getBanda().equals(banda)) {
				resultados.add(cancion);
			}
		}
		return resultados;
	}

	@Override
	public ArrayList<Cancion> buscarAlbum(String album) {
		ArrayList<Cancion> resultados =  new ArrayList<>();
		
		for (Cancion cancion : this.canciones) {
			if (cancion.getAlbum().equals(album)) {
				resultados.add(cancion);
			}
		}
		return resultados;
	}

	@Override
	public ArrayList<Cancion> buscarProducido(int year) {
		ArrayList<Cancion> resultados = new ArrayList<>();
		
		for (Cancion cancion : this.canciones) {
			if (cancion.getYear() == year) {
				resultados.add(cancion);
			}
		}
		return resultados;
	}

}
