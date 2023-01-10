package Ejercicio_2;

public class Hilo extends Thread{
	private int[] nums;
	
	public Hilo(String nombre, int[] nums) {
		super(nombre);
		this.nums = nums;
		this.start();
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
