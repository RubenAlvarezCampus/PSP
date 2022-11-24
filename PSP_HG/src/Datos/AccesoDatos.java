package Datos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

public class AccesoDatos {	
	
	public static List<Juego> Consulta(String consulta) {
		List<Juego> juegos = ImportarCSV();
		ArrayList<Juego> resultados = new ArrayList<Juego>();
		
		String[] consultas = consulta.split("-");
		
		if (consultas[0].equalsIgnoreCase("ID")) {	
			for (Juego juego : juegos) {
				if (Integer.parseInt(consultas[1]) == juego.getId()) {
					resultados.add(juego);
				}	
			}
		}
		else if (consultas[0].equalsIgnoreCase("Genero")) {	
			for (Juego juego : juegos) {
				if (consultas[1].equalsIgnoreCase(juego.getGenero())) {
					resultados.add(juego);
				}	
			}
		}
		else if (consultas[0].equalsIgnoreCase("Stock")) {	
			for (Juego juego : juegos) {
				if (juego.isStock()==true) {
					resultados.add(juego);
				}	
			}
		} else {
			
		}
		
		return resultados;
	}
	
	public static List<Juego> ImportarCSV() {
		List<Juego> juegos = new ArrayList<Juego>();
        
        CsvReader leerJuegos;
		try {
			leerJuegos = new CsvReader("juegos.csv");
			
			while(leerJuegos.readRecord()) {
                int id = Integer.parseInt(leerJuegos.get(0));
                String titulo = leerJuegos.get(1);
                String genero = leerJuegos.get(2);
                float precio = Float.parseFloat(leerJuegos.get(3));
                String formato = leerJuegos.get(4);
                String plataforma = leerJuegos.get(5);
                int valoracion = Integer.parseInt(leerJuegos.get(6));
                boolean stock = Boolean.parseBoolean(leerJuegos.get(7));
                
                juegos.add(new Juego(id,titulo,genero,precio,formato,plataforma,valoracion,stock));           
            } 
			
            leerJuegos.close();
            
		} catch (FileNotFoundException e) {
			System.out.println("Error, falta el archivo juegos.csv");
			// juegos = null;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        return juegos;
    }
}
