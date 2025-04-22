package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrincipalCadenas {
	public static void main(String[] args) {

		// creamos obejeto escaner
		Scanner sc = new Scanner(System.in);
		// variable cadena
		String cadena;

		// try catch , creamos el bufferwritter y le especificamos el paquete para que
		// cree solo. Lo ponemos en el try para que cierre al salir. Ponemos true al
		// final para que guarde todo y no solo sobreescriba
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio4\\fichero.txt", true))) {

			// pedimos al usuario que introduzca una cadena
			System.out.println("Introduce una cadena. FIN para salir");
			// guardamos en cadena
			cadena = sc.nextLine();

			// mientras la cadena no sea fin seguirá pidiendo
			while (!cadena.equalsIgnoreCase("FIN")) {
				// guardamos la cadena en el fichero usando el método write
				bw.write(cadena);
				// salto de línea con el método newLine
				bw.newLine();

				// pedimos al usuario que introduzca una cadena
				System.out.println("Introduce una cadena. FIN para salir");
				// guardamos en cadena
				cadena = sc.nextLine();
			}
			//hacemos el flush este
			bw.flush();
			// capturamos la excepción
		} catch (IOException e) {
			// mensaje error
			System.out.println("No se puede leer el archivo");

		}
		System.out.println("Fin de Programa");
	}
}
