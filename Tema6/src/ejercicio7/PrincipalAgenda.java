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
	public static TreeMap<String, Long> agenda = new TreeMap<>();

	public static void main(String[] args) {
		// objeto escaner
		Scanner sc = new Scanner(System.in);
		// variable opción
		int opcion;
		// variable nombre
		String nombre;
		// variable número
		Long num;

		// repetimos interacciones
		do {
			// mostramos menú llamando a la función
			mostrarMenu();

			// guardamos opcioón
			opcion = sc.nextInt();
			sc.nextLine();
			// switch
			switch (opcion) {
			//caso 1: añadir nuevo contacto
			case 1 -> {
				// pedimos nombre del contacto
				System.out.println("Introduce el nombre");
				//guardamos nombre del contacto
				nombre = sc.nextLine();
				//pedimos número del contacto
				System.out.println("Introduce el número");
				//guardamos número
				num = sc.nextLong();
				//limpiamos buffer
				sc.nextLine();
				//añadimos el contacto al mapa
				añadirContacto(nombre, num);
			}
			//caso 2: buscar contacto por nobre
			case 2 -> {
				//pedimos nombre a buscar
				System.out.println("Introduce el nombre a buscar");
				//guardamos nombre
				nombre = sc.nextLine();
				//guardamos en número el número asociado al nombre en el mapa
				num = agenda.get(nombre);
				//si no existe el número porque no existe el nombre
				if (num == null) {
					//mensaje error
					System.out.println("El contacto no existe");
					//en caso de que exista
				} else {
					//imprimimos nombre y número
					System.out.println(nombre + ": " + num);
				}

			}
			//caso 3: mostrar todos los contactos de la agenda
			case 3 -> {
				//for each para recorrer el mapa. usamos el key para que tome las claves del mapa
				for (String contacto : agenda.keySet()) {
					//imprime contacto y su valor de agenda
					System.out.println(contacto + ": " + agenda.get(contacto));
				}

			}
			//caso 4 salir y escriber fichero
			case 4 -> {
				//llamamos a la función escribir fichero
				escribeFichero();
				//immprimimos mensaje de salida
				System.out.println("Guardando y Saliendo");

			}
			//caso default
			default -> {
				//mensaje error
				System.out.println("La opción introducida no existe");
			}
			}

			// hasta que elijamos salir (opción 4)
		} while (opcion != 4);
		//cerramos escaner
		sc.close();
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

	/**
	 * Función que añade contacto
	 * @param nombre contacto
	 * @param num contacto
	 * @return exito
	 */
	public static boolean añadirContacto(String nombre, Long num) {
		boolean exito = false;
		//si el tamaño es menor de 20 y no  contiene el nombre a guardar
		if (agenda.size() < 20 && !agenda.containsKey(nombre)) {
			//guarda nombre y número en el mapa
			agenda.put(nombre, num);
			//exito será true
			exito = true;
		}
		//devuelve éxito
		return exito;
	}

	/**
	 * Función que lee el fichero y si no existe crea un fichero vacío
	 */
	public static void leeFichero() {

		try (BufferedReader br = new BufferedReader(new FileReader("src\\ejercicio7\\Agenda.txt"))) {
			// array datos
			String datos[];
			// línea donde guardamos la primera línea 1del fichero
			String linea = br.readLine();
			// si la línea tiene algo
			while (linea != null) {
				// separamos la línea por espacios y lo guardamos en el array
				datos = linea.split(": ");
				// guardamos en el mapa los datos, haciendo un casteo con parseInt del número
				// porque espera un integer en lugar de int
				agenda.put(datos[0], Long.parseLong(datos[1]));
				// pasamos a la siguiente línea y lo guardamos en la variable del mismo nombre
				linea = br.readLine();
			}

		} catch (FileNotFoundException e) {
			// crea un fichero vacío en caso de que no exista
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio7\\Agenda.txt", true))) {

			} catch (IOException e1) {
				System.out.println("No se puede leer el fichero");
			}

		} catch (IOException e1) {
			System.out.println("No se puede leer el fichero");
		}

	}
/**
 * función que escribe los contactos del mapa en el fichero
 */
	public static void escribeFichero() {

		// crea un fichero vacío en caso de que no exista
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("src\\ejercicio7\\Agenda.txt", true))) {
			//for each para recorrer el mapa y nos quedamos con la clave de la agenda
			for (String contacto : agenda.keySet()) {
				//escribimos en el fichero contecto y el get del contacto, que será el número
				bw.write(contacto + ": " + agenda.get(contacto));
				//salto de línea
				bw.newLine();
				 
			}

		
		} catch (IOException e1) {
			System.out.println("No se puede leer el fichero");
		}

	}

}
