package ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrincipalDatos {
	public static void main(String[] args) {

		// creamos obejeto escaner
		Scanner sc = new Scanner(System.in);
		// variable nombre
		String nombre;
		// variable edad
		int edad;

		// try catch , creamos el bufferwritter y le especificamos el paquete para que
		// cree solo. Lo ponemos en el try para que cierre al salir. Ponemos true al
		// final para que guarde todo y no solo sobreescriba
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio5\\Datos.txt"))) {

			// pedimos al usuario que introduzca un nombre
			System.out.println("Introduce tu nombre");
			// guardamos en cadena
			nombre = sc.nextLine();
			// pedimos edad
			System.out.println("Introduce tu edad");
			// guardamos edad
			edad = sc.nextInt();

			// guardamos la cadena en el fichero usando el método write
			bw.write(nombre + "\t" + edad);
			// salto de línea con el método newLine
			bw.newLine();

			// hacemos el flush este
			bw.flush();
			// capturamos la excepción
		} catch (IOException e) {
			// mensaje error
			System.out.println("No se puede leer el archivo");

		}
	}
}