package Ejercicio_3;

public class Hilo implements Runnable{
	private int[] nums;
	private Thread hilo;
	
	public Hilo(String nombre, int[] nums) {
		this.nums = nums;
		this.hilo = new Thread(this,nombre);
		this.hilo.start();
	}
	
	@Override
	public void run() {
		int total = 0;
		
		for (int num : nums) {
			total+=num;
		}
		
		System.out.println(total);
	}
}
