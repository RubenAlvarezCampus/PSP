import java.net.InetAddress;
import java.net.UnknownHostException;

public class EjemploInetAddress {
	
	public static void main(String[] args) {
		
		try {
			
			InetAddress local = InetAddress.getByName("192.168.1.22");
			System.out.println(local.getHostAddress());
			System.out.println(local.getHostName());
			System.out.println(local.isLoopbackAddress());
			
			InetAddress google = InetAddress.getByName("www.google.es");
			System.out.println(google.getHostAddress());
			System.out.println(google.getHostName());
			System.out.println(google.isLoopbackAddress());
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
