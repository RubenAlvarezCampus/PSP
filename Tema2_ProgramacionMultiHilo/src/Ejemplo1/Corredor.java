package Ejemplo1;

public class Corredor extends Thread{
	public Corredor(String nombre) {
		super(nombre);
		this.start();
	}

	@Override
	public void run() {
		for (int i=1;i<=5;i++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName()+" Va por el Kilometro "+i);
		}
		System.out.println(this.getName()+" ha llegado a a la meta");
	}
	
}
