package ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrincipalTemperaturas {
	public static void main(String[] args) {

		// objeto escaner
		Scanner sc = new Scanner(System.in);
		// variable opción
		int opcion;

		// variable fecha
		String fecha;

		// variable temperatura máxima
		int tempMax;
		// variable temperatura mínima
		int tempMin;

		// do while para repetir las iteraciones
		do {
			// mostramos menú llamando a la función
			mostrarMenu();
			// guardamos opción
			opcion = sc.nextInt();
			// limpiamos buffer
			sc.nextLine();
			// switch de la opción elegida
			switch (opcion) {
			// caso 1: registrar nueva temperatura
			case 1 -> {
				// pedimos fecha
				System.out.println("Introduce la fecha del registro");
				// guardamos
				fecha = sc.nextLine();

				// repetimos petición de temperaturas hasta que sean correctas
				do {
					// pedimos temperatura
					System.out.println("Introduce temperatura máxima");
					// guardamos
					tempMax = sc.nextInt();
					// pedimos temperatura
					System.out.println("Introduce temperatura mínima");
					// guardamos
					tempMin = sc.nextInt();
					// mientras la temperatura máxima sea menor que la mínima seguirá pidiéndolas
				} while (tempMax < tempMin);
				
				//llamamos a la función escribe fichero y le pasamos los datos por parámetros
				escribeFichero(fecha, tempMax, tempMin);
				// limpiamos buffer
				sc.nextLine();

			}
			// caso 2: Mostrar registros
			case 2 -> {
				//llamamos a la función muestraFichero para que lea el archivo y nos imprima su contenido
				muestraFichero();

			}
			// caso 3: salir
			case 3 -> {
				//mensaje salida
				System.out.println("Saliendo del programa");
			}
			// default
			default -> {
				//mensaje error
				System.out.println("La opción introducida no existe");
			}
			}
			// repetimos hasta que elijamos la opción 3
		} while (opcion != 3);
		// cerramos escaner
		sc.close();
	}

	/**
	 * función que muestra menú
	 */
	public static void mostrarMenu() {

		System.out.println();
		System.out.println("MENÚ:");
		System.out.println("1. Registra nueva temperatura.");
		System.out.println("2. Mostrar historial de registros");
		System.out.println("3. Salir");
		System.out.println();
		System.out.println("Introduce la opción deseada");

	}

	/**
	 * función que lee el fichero e imprime las líneas, al final imprime el total.
	 * Si no existe un fichero lo crea escribiendo en él el encabezado
	 */
	public static void muestraFichero() {

		try (BufferedReader br = new BufferedReader(new FileReader("src\\ejercicio8\\RegistroTemperaturas.txt"))) {
			// array datos
			String datos[];
			// línea donde guardamos la primera línea 1del fichero
			String linea=	br.readLine();; 
			// variable temperatura máxima y mínima
			int tempMax;
			int tempMin;

			//creamos variables donde guardar temperaturas máximas y mínimas y las inicializamos al máximo y al mínimo posible
			int tempMaxTotal = Integer.MIN_VALUE;
			int tempMinTotal = Integer.MAX_VALUE;
			
			//saltamos la línea para que no lea el encabezado
			linea = br.readLine();
			
			//imprimimos encabezado
			System.out.println("Fecha" + " - " + "Temperatura Máxima" + " - " + "Temperatura Mínima");
			
			// si la línea tiene algo
			while (linea != null) {

				// separamos la línea por espacios y lo guardamos en el array
				datos = linea.split(" ");

				// guardamos los datos casteandolos
				tempMax = Integer.parseInt(datos[1]);
				tempMin = Integer.parseInt(datos[2]);
				// si la temperatura maxima es mayor que la total
				if (tempMax > tempMaxTotal) {
					// la guardamos
					tempMaxTotal = tempMax;
				}
				// si la temperatura mínima
				if (tempMin < tempMinTotal) {
					// temperatura min total será igual a temperatura mínima
					tempMinTotal = tempMin;
				}

				// imnprimimos línea
				System.out.println(linea);
				// pasamos a la siguiente línea y lo guardamos en la variable del mismo nombre
				linea = br.readLine();
			}
			//imprimimos temperaturas máxima y mínima
			System.out.println("Temperatura Máxima: " + tempMaxTotal);
			System.out.println("Temperatura Mínima: " + tempMinTotal);
			
			//si el fichero no existe capturamos excepción
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		//si el fichero no se puede leer capturamos excepción
		} catch (IOException e) {
			System.out.println("Error al leer el fichero");
		}

	}

	/**
	 * función que escribe en el fichero los datos que le pasamos por parámetro
	 * 
	 * @param fecha
	 * @param tempMax
	 * @param tempMin
	 */
	public static void escribeFichero(String fecha, int tempMax, int tempMin) {
		//llamos a la función leer fichero para ver si existe
		leeFichero();
		//buffer de escritura dentro de un try catch
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("src\\ejercicio8\\RegistroTemperaturas.txt", true))) {
			//escribimos en el archivo los datos recogidos
			bw.write(fecha + " " + tempMax + " " + tempMin);
			//saltdo de línea
			bw.newLine();
			//si no se puede leer el archivo capturamos la excepción
		} catch (IOException e2) {
			//mensaje error
			System.out.println("Error al leer el archivo");
		}

	}
/**
 * función que lee el fichero y si no existe ninguno lo crea junto con el encabezado
 */
	public static void leeFichero() {
		//buffer de lectura en un try
		try (BufferedReader br = new BufferedReader(new FileReader("src\\ejercicio8\\RegistroTemperaturas.txt"))) {
			
		//si no lo encuentra captura la excepción	
		} catch (FileNotFoundException e) {
			// si no existe el fichero lo creará creando buffer de escritura
			try (BufferedWriter bw = new BufferedWriter(
					new FileWriter("src\\ejercicio8\\RegistroTemperaturas.txt", true))) {
				// escribirá el encabezado
				bw.write("Fecha" + " - " + "Temperatura Máxima" + " - " + "Temperatura Mínima");
				//salto línea
				bw.newLine();
				//si no lo puede leer captura excepción
			} catch (IOException e1) {
				//mensaje error
				System.out.println("Error al leer el fichero");
			}
			//si no lo puede leer captura la excepción
		} catch (IOException e) {
			System.out.println("Error al leer el fichero");
		}
	}
}
