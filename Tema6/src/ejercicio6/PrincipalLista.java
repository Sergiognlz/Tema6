package ejercicio6;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrincipalLista {
	public static void main(String[] args) {

		// variable número
		int num;
		// creamos lista
		List<Integer> listaNumeros = new ArrayList<>();

		// try catch con el scanner y el filereader con la dirección del la lista1.
		try (Scanner sc = new Scanner(new FileReader("src\\ejercicio6\\Lista1.txt"))) {
			// mientras haya números seguirá repitiendo
			while (sc.hasNextInt()) {
				// guardamos el número que leemos en la variable num
				num = sc.nextInt();
				// añadimos el número a la lista
				listaNumeros.add(num);
			}
			// ordenamos la lista
			Collections.sort(listaNumeros);

			// recogemos la excepción en caso de que no encuentre el fichero
		} catch (FileNotFoundException e) {
			// mensaje error
			System.out.println("Fichero no encontrado");

			// try catch con el buffer de escritura y la dirección de la lista 2, añadimos
			// el append con el true para que concatene
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio6\\Lista2.txt", true))) {
				// for each para recorrer la lista
				for (int numero : listaNumeros) {
					// guardamos el número en el fichero pasándolo a String
					bw.write(String.valueOf(numero));
					// añadimos salto de línea
					bw.newLine();

				}
				
				bw.flush();
				// capturamos la excepción en caso que no se pueda leer
			} catch (IOException e1) {
				// mensaje de error
				System.out.println("No se puede leer el fichero");
			}

		}

	}
}
