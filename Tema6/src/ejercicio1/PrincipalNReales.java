package ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*Crea con un editor el fichero de texto NumerosReales.txt en un paquete dentro del proyecto. 
 * Escribe en él una serie de números reales separados por espacios simples. 
 * Implementar un programa que acceda a NumerosReales.txt, lea los números y calcule la suma y la media aritmética, 
 * mostrando los resultados por pantalla.*/

public class PrincipalNReales {
	public static void main(String[] args) {
		// creamos variable número
		double num;
		// creamos variable suma
		double suma = 0;
		// creamos contador
		int cont = 0;
		// variable media
		double media = 0;
		
		// try creamos objeto escaner y le pasamos el filereader con la dirección del
		try (Scanner sc = new Scanner(new FileReader("src\\ejercicio1\\NumerosReales.txt"))) {

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

			// capturamos la excepción
		} catch (FileNotFoundException e) {
			// mensaje de error
			System.out.println("El fichero no existe");

		}

	}
}
