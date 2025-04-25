package ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.AsynchronousSocketChannel;
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
				// limpiamos buffer
				sc.nextLine();

			}
			// caso 2: Mostrar registros

			}
			// repetimos hasta que elijamos la opción 3
		} while (opcion != 3);
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

	public static void leeFichero() {
		
		
	
		try (BufferedReader br = new BufferedReader(new FileReader("src\\ejercicio8\\RegistroTemperaturas.txt"))) {
			// array datos
			String datos[];
			// línea donde guardamos la primera línea 1del fichero
			String linea = br.readLine();
			//variable temperatura máxima y mínima
			int tempMax;
			int tempMin;
			
			int tempMaxTotal=Integer.MIN_VALUE;
			int tempMinTotal=Integer.MAX_VALUE;
			
			// si la línea tiene algo
			while (linea != null) {
				
				// separamos la línea por espacios y lo guardamos en el array
				datos = linea.split(" ");
				//imnprimimos línea
				System.out.println(linea);
				//guardamos los datos casteandolos 
				tempMax=Integer.parseInt(datos[1]);
				tempMin=Integer.parseInt(datos[2]);
				//si la temperatura maxima es mayor que la total
				if(tempMax>tempMaxTotal) {
					//la guardamos
					tempMaxTotal=tempMax;
				}
				//si la temperatura mínima 
				if(tempMinTotal<tempMin) {
					//temp
					tempMinTotal=tempMin;
				}
				
				
				// pasamos a la siguiente línea y lo guardamos en la variable del mismo nombre
				linea = br.readLine();
			}
			

		} catch (FileNotFoundException e) {
			try (BufferedWriter bw = new BufferedWriter(
					new FileWriter("src\\ejercicio8\\RegistroTemperaturas.txt", true))) {

				bw.write("Fecha" + " - " + "Temperatura Máxima" + " - " + "Temperatura Mínima");

			} catch (IOException e1) {
				System.out.println("Error al leer el fichero");
			}
		} catch (IOException e) {
			System.out.println("Error al leer el fichero");
		}

	}

	public static void escribeFichero(String fecha, int tempMax, int tempMin) {

		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("src\\ejercicio8\\RegistroTemperaturas.txt", true))) {

			bw.write(fecha + " " + tempMax + " " + tempMin);

		} catch (IOException e2) {

		}

	}

}
