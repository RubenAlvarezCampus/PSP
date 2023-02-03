package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MusicalInterfaceRMI extends Remote{
	public ArrayList<Cancion>buscarTitulo(String titulo) throws RemoteException;
	public ArrayList<Cancion>buscarBanda(String banda) throws RemoteException;
	public ArrayList<Cancion>buscarAlbum(String album) throws RemoteException;
	public ArrayList<Cancion>buscarProducido(int year) throws RemoteException;
}
