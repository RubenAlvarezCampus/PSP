package Servidor;

public class mensaje {
	public String usuario;
	public String time;
	public String mensaje;
	
	public mensaje(String usuario, String time, String mensaje) {
		this.usuario = usuario;
		this.time = time;
		this.mensaje = mensaje;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
