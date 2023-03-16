package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ChatInterfazRMI extends Remote{
	public boolean Login(String usuario) throws RemoteException;
	public void EnviarMensaje(String usuario,String mensaje) throws RemoteException;
	public ArrayList<String>MostrarMensajes() throws RemoteException;
	public void Salir (String usuario) throws RemoteException;
}
