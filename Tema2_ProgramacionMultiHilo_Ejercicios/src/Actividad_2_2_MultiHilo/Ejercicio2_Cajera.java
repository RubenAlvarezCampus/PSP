package Actividad_2_2_MultiHilo;

public class Ejercicio2_Cajera extends Thread{
	/*Atributos*/
	private String nombre;
	private Ejercicio2_Cliente cliente;
	private long tiempo_actual;
	
	/*Constructor*/
	public Ejercicio2_Cajera(String nombre, Ejercicio2_Cliente cliente) {
		super();
		this.nombre = nombre;
		this.cliente = cliente;
		this.tiempo_actual = System.currentTimeMillis();
		start();
	}
	
	/*Metodos*/
	private void esperarXsegundos (int segundos) {
		try {
			Thread.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private long TiempoTrascurrido(long tiempoProd) {
		return (tiempoProd - this.tiempo_actual)/1000;
	}
	
	@Override
	public void run() {
		super.run();
		
		for (int i=0;i<cliente.getLista().length;i++) {
			esperarXsegundos((cliente.getLista()[i])*1000);
			System.out.println("Cajera "+this.nombre+" ha procesado el producto "+(i+1)+" -> Tiempo: "+TiempoTrascurrido(System.currentTimeMillis())+" seg");
		}
		
		System.out.println("Cajera "+this.nombre+" HA TERMINADO CON "+cliente.getNombre()+" -> EN UN TIEMPO DE: "+TiempoTrascurrido(System.currentTimeMillis())+" seg");
	}
}
