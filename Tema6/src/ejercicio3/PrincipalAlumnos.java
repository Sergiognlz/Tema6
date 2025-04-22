package ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrincipalAlumnos {
	public static void main(String[] args) {
		// variable línea
		String linea;
		// array datos
		String datos[];
		// variable nombres
		String nombres ="";
		// variable suma edades
		double sumaEdades = 0;
		// variable suma edades
		int sumaAlt = 0;
		// variable media edades
		double mediaEdades = 0;
		// variable media alturas
		double mediaAlt = 0;
		// variable contador para la media
		int cont = 0;

		// try con el buffer dentro para que se cierre cuando acabe el try catch
		try (BufferedReader br = new BufferedReader(new FileReader("src\\ejercicio3\\Alumnos.txt"));) {

			// guardamos la primera línea con el método readLine
			linea = br.readLine();
			// mientras haya líneas seguirá repitiendo el bucle
			while (linea != null) {

				// guardamos en el array datos el split(la separación) de la cadena línea por
				// los espacios.
				datos = linea.split(" ");
				// concatenamos en nombre los datos de la posición 0, los nombres
				nombres += datos[0] + ", ";
				// concatenamos los números en suma edades y hacemos una especie de casteo de
				// las edades (porque están en tipo string)
				sumaEdades += Integer.parseInt(datos[1]);
				// concatenamos los números en suma alturas y hacemos una especie de casteo de
				// las edades (porque están en tipo string)
				sumaAlt += Double.parseDouble(datos[2]);
				// incrementamos contador
				cont++;
				//volvemos a leer para que pase a la siguiente línea
				linea = br.readLine();
			}
			//calculamos las medias de edades
			mediaEdades=sumaEdades/cont;
			//media alturas
			mediaAlt=sumaAlt/cont;
			
			System.out.println("Nombres: "+nombres);
			System.out.println("Edades media : "+mediaEdades);
			System.out.println("Alturas media: "+mediaAlt);
			
			// capturamos la excepción
		} catch (FileNotFoundException e) {
			// mensaje error
			System.out.println("El fichero no existe");
			// capturamos excepción
		} catch (IOException e1) {
			// mensaje error
			System.out.println("No se puede leer el fichero");
		}

	}

}
