import java.util.concurrent.ThreadLocalRandom;

public class Examinador implements Runnable {
	private Thread hilo;
	BufferExamenes buffer;
	
	public Thread getHilo() {
		return hilo;
	}
	
	public Examinador(String alumno, BufferExamenes generador) {
		// Construye el hilo. El nombre será el nombre del alumno.
		hilo = new Thread (this,alumno);
		// Establece el valor de la propiedad buffer.
		this.buffer = generador;
		// Inicia el hilo.
		hilo.start();
	}
	
	@Override
	public void run() {
		String codigoExamen = this.buffer.consumirExamen();	
		
		if (codigoExamen != null) {
			// Simula aquí un examen de 10 preguntas
			// cuyas respuestas se seleccionarán al azar
			// entre A, B, C, D o – (sin contestar).
			for (int i = 1; i<=10; i++) {
				int respuesta_random =ThreadLocalRandom.current().nextInt(1,6);
				String respuesta = null;
				
				switch (respuesta_random) {
					case 1: {
						respuesta = "A";
						break;
					}
					case 2: {
						respuesta = "B";
						break;
					}
					case 3: {
						respuesta = "C";
						break;
					}
					case 4: {
						respuesta = "D";
						break;
					}
					case 5: {
						respuesta = "-";
						break;
					}
				}
				System.out.println(codigoExamen+";"+this.hilo.getName()+"; Pregutna "+i+";"+respuesta);
			}
		}
		else {
		System.out.println("Agotado tiempo de espera y " +
		"no hay más exámenes");
		}
	}
}