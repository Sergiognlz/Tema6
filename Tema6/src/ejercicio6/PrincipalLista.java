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
		//creamos lista números y guardamos la lista que nos devulve
		List<Integer>listaNumeros=ListaFunciones.guardaLista();

		// ordenamos la lista
		Collections.sort(listaNumeros);
		//llamamos a la función 
		ListaFunciones.escribeLista(listaNumeros);

	}
}
