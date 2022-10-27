package Actividad_2_1_MultiHilo;

public class Ejercicio1{
	public static void main(String[] args) {
		Thread hilo = Thread.currentThread();
		System.out.println("ID= "+hilo.getId());
		System.out.println("Name= "+hilo.getName());
		System.out.println("Prioridad= "+hilo.getPriority());
		
		hilo.setName("Hilo :3");
		hilo.setPriority(7);
		try {
			hilo.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(hilo.toString());
	}
}
