import java.util.LinkedList;
import java.util.Queue;

public class BufferExamenes {	
	private Queue<String> colaExamenes;
	
	public BufferExamenes() {
		colaExamenes = new LinkedList<String>();
	}
	
	public synchronized void fabricarNuevoExamen(String codigo) {
		// Añade el código pasado como argumento a la cola y libera el hilo que está intentando consumir
		// un nuevo examen.
		colaExamenes.add(codigo);
		notify();
	}
	public synchronized String consumirExamen() {	
		// Haz aquí una pausa hasta que se haya fabricado algún examen.
		if (colaExamenes.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Si la cola sigue sin estar vacía, saca un examen y
		// entrégalo como retorno de esta función.
		String examen = colaExamenes.remove();
		return examen;
	}
}