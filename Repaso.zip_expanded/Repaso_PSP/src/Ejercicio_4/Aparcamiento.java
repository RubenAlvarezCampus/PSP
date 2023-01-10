package Ejercicio_4;

public class Aparcamiento {
	private int plazasOcupadas;
	private int plazasDisponibles;
	
	public Aparcamiento(int plazasDisponibles) {
		this.plazasOcupadas = 0;
		this.plazasDisponibles = plazasDisponibles;
	}
	
	public synchronized boolean hayPlazasDisponibles() {
		if (this.plazasDisponibles>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public synchronized void aumentarPlazasDisponibles() {
		this.plazasDisponibles++;
		this.plazasOcupadas--;
		System.out.println("Plazas Disponibles: "+this.plazasDisponibles);
		notifyAll();
	}
	
	public synchronized void disminuirPlazasDisponibles() {
		while (hayPlazasDisponibles()==false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.plazasDisponibles--;
		this.plazasOcupadas++;
		
	}
}
