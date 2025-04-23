package ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class PrincipalAgenda {

	// creamos mapa a nivel clase
	public static TreeMap<String, Integer> agenda = new TreeMap<>();

	public static void main(String[] args) {
		// objeto escaner
		Scanner sc = new Scanner(System.in);
		// variable opción
		int opcion;
		// variable nombre
		String nombre;
		// variable número
		Integer num;

		// repetimos interacciones
		do {
			// mostramos menú llamando a la función
			mostrarMenu();

			// guardamos opcioón
			opcion = sc.nextInt();
			sc.nextLine();
			// switch
			switch (opcion) {

			case 1 -> {
				// pedimos número
				System.out.println("Introduce el nombre");
				nombre = sc.nextLine();
				System.out.println("Introduce el número");
				num = sc.nextInt();

				añadirContacto(nombre, num);
			}
			case 2 -> {
				System.out.println("Introduce el nombre a buscar");
				nombre = sc.nextLine();
				num = agenda.get(nombre);
				if (num == null) {
					System.out.println("El contacto no existe");
				} else {
					System.out.println(nombre + ": " + num);
				}

			}
			case 3 -> {

			}
			case 4 -> {

			}
			default -> {

			}
			}

			// hasta que elijamos salir (opción 4)
		} while (opcion != 4);
	}

	/**
	 * función mostrar menú
	 */
	public static void mostrarMenu() {
		System.out.println();
		System.out.println("Menú:");
		System.out.println("1. Nuevo contacto.");
		System.out.println("2. Buscar por nombre");
		System.out.println("3. Mostrar todos.");
		System.out.println("4. Salir. ");
		System.out.println();
		System.out.println("Introduce la opción deseada");
	}

	public static boolean añadirContacto(String nombre, int num) {
		boolean exito = false;

		if (agenda.size() < 20 && !agenda.containsKey(nombre)) {

			agenda.put(nombre, num);
			exito = true;
		}

		return exito;
	}

	/**
	 * Función que lee el fichero y si no existe crea un fichero vacío
	 */
	public static void leeFichero() {

		try (BufferedReader br = new BufferedReader(new FileReader("src\\ejercicio7\\Agenda.txt"))) {
			//array datos
			String datos[];
			//línea donde guardamos la primera línea del fichero
			String linea = br.readLine();
			//si la línea tiene algo
			while (linea != null) {
				//separamos la línea por espacios y lo guardamos en el array
				datos = linea.split(" ");
				//guardamos en el mapa los datos, haciendo un casteo con parseInt del número porque espera un integer en lugar de int
				agenda.put(datos[0], Integer.parseInt(datos[1]));
				//pasamos a la siguiente línea y lo guardamos en la variable del mismo nombre
				linea=br.readLine();
			}

		} catch (FileNotFoundException e) {
			//crea un fichero vacío en caso de que no exista
			try(BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio7\\Agenda.txt", true))) {
				
		
				
			} catch (IOException e1) {
				System.out.println("No se puede leer el fichero");
			}

		} catch (IOException e1) {
			System.out.println("No se puede leer el fichero");
		}

	}

}
