package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MusicaInterfazProductor extends Remote{
	public void addMusica(Cancion cancion) throws RemoteException;
	public ArrayList<Cancion> getMusica() throws RemoteException;
}
