package Servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChatRMI extends UnicastRemoteObject implements ChatInterfazRMI{

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private ArrayList<String> usuarios = new ArrayList<>();
	private ArrayList<mensaje> mensajes = new ArrayList<>();
	
	protected ChatRMI() throws RemoteException {
		super();
	}

	@Override
	public boolean Login(String usuario) throws RemoteException {
		for (String user : this.usuarios) {
			if (usuario.equals(user)) {
				return false;
			}
		}
		this.usuarios.add(usuario);
		return true;
	}

	@Override
	public void EnviarMensaje(String usuario, String mensaje) throws RemoteException {
		this.mensajes.add(new mensaje(usuario,LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute(), mensaje));
	}

	@Override
	public ArrayList<String> MostrarMensajes() throws RemoteException {
		ArrayList<String> resultado = new ArrayList<String>();
		
		for (mensaje mensaje : mensajes) {
			resultado.add(mensaje.time+"#"+mensaje.usuario+">"+mensaje.mensaje);
		}
		
		return resultado;
	}

	@Override
	public void Salir(String usuario) throws RemoteException {
		this.usuarios.remove(usuario); 
	}

}
