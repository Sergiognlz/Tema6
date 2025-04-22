package ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EnterosPrincipal {
	/*
	 * Crear con un editor el fichero de texto Enteros.txt en la carpeta del
	 * proyecto y escribe en él una serie de números enteros separados por
	 * secuencias de espacios y tabuladores, incluso en líneas distintas, tal como:
	 */

	public static void main(String[] args) {

		// creamos variable número
		double num;
		// creamos variable suma
		double suma = 0;
		// creamos contador
		int cont = 0;
		// variable media
		double media = 0;
		// try
		try {
			// creamos objeto escaner y le pasamos el filereader con la dirección del
			// fichero
			Scanner sc = new Scanner(new FileReader("src\\ejercicio2\\Enteros.txt"));

			// comprobamos que el fichero tiene números y va avanzando por entre los números
			while (sc.hasNextDouble()) {
				// guardamos el número en la variable num
				num = sc.nextDouble();
				// sumamos al total el número
				suma += num;
				// incrementamos contador
				cont++;
			}
			// calculamos la media
			media = suma / cont;

			// imprimimos suma
			System.out.println("Suma números: " + suma);
			// imprimimos media
			System.out.println("Media números: " + media);

			// cerramos escaner
			sc.close();

			// capturamos la excepción
		} catch (FileNotFoundException e) {
			// mensaje de error
			System.out.println("El fichero no existe");
		}

	}
}
