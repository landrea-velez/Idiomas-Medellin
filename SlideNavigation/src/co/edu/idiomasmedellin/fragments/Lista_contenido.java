package co.edu.idiomasmedellin.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cipolat.slidenavigation.R;

public class Lista_contenido {

	/** 
	 * Donde se guardan las entradas de la lista.
	 */
	public static ArrayList<Lista_entrada> ENTRADAS_LISTA = new ArrayList<Lista_entrada>();

	/** 
	 * Donde se asigna el identificador a cada entrada de la lista
	 */
	public static Map<String, Lista_entrada> ENTRADAS_LISTA_HASHMAP = new HashMap<String, Lista_entrada>();

	/** 
	 * Creamos estáticamente las entradas
	 */
	static {	
		
		aniadirEntrada(new Lista_entrada("0", R.drawable.icono, "Los sustantivos"));
		aniadirEntrada(new Lista_entrada("1", R.drawable.icono, "Artículos A, An, The"));
		aniadirEntrada(new Lista_entrada("2", R.drawable.icono, "Adjetivos Calificativos Introducción"));
		aniadirEntrada(new Lista_entrada("3", R.drawable.icono, "Verbo TO BE y pronombres personales"));
		aniadirEntrada(new Lista_entrada("4", R.drawable.icono, "Verbo TO BE uso"));
		aniadirEntrada(new Lista_entrada("5", R.drawable.icono, "Preposiciones In, At, On"));
		aniadirEntrada(new Lista_entrada("6", R.drawable.icono, "This-That / These-Those"));
		aniadirEntrada(new Lista_entrada("7", R.drawable.icono, "Verbo TO BE en forma negativa"));
	}

	/** Añade una entrada a la lista
	 * @param entrada Elemento que añadimos a la lista
	 */
	private static void aniadirEntrada(Lista_entrada entrada) {
		ENTRADAS_LISTA.add(entrada);
		ENTRADAS_LISTA_HASHMAP.put(entrada.id, entrada);
	}

	/**
	 * Representa una entrada del contenido de la lista
	 */
	public static class Lista_entrada {
		public String id;
		public int idImagen; 
		public String textoEncima; 
		

		public Lista_entrada (String id, int idImagen, String textoEncima) { 
			this.id = id;
		    this.idImagen = idImagen; 
		    this.textoEncima = textoEncima; 
		   
		}
	}

}