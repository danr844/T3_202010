package model.logic;



import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.Comparendo;
import model.data_structures.Node;
import stdrando


/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ArregloDinamico<Comparendo> datos;
	private Node<Comparendo> primero;
	private int numeroNodos;
	private Node<Comparendo> ultimo;
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		primero = null;
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico<Comparendo>(capacidad);
	}
	public static  boolean   less(Comparendo a, Comparendo a2)  
	{  
		return a.compareTo((Comparendo) a2) < 0;  
	}   

	public ArregloDinamico<Comparendo> copiarComparendos(){
		ArregloDinamico<Comparendo> arreglonuevo = new ArregloDinamico<>(datos.darTamano());
		for(int i = 0; i<datos.darTamano(); i++)
		{
			arreglonuevo.agregar(datos.darElemento(i));
		}
		return arreglonuevo;
	}



	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param <T>
	 * @param dato
	 */
	//	public <T> void agregar(Comparendo dato)
	//	{	
	//		if(primero== null){
	//			primero  = new Node <Comparendo>();
	//			primero.cambiarDato(dato);
	//			numeroNodos++;
	//			ultimo = primero;
	//		}
	//		else{
	//			Node<Comparendo> nodo= new Node<Comparendo>();
	//			nodo.cambiarDato(dato);
	//			ultimo.cambiarSiguiente(nodo);
	//			ultimo = nodo;
	//			numeroNodos++;
	//		
	//		}
	//			
	//	}
	public int darNumeroNodos(){
		return numeroNodos;
	}

	public Node<Comparendo> darUltimoNodo(){
		return ultimo;
	}

	public List<Double> cargarInfo(){
		List<Double> geo = new ArrayList<Double>();

		try {

			Gson gson = new Gson();

			String path = "./data/comparendos_dei_2018_small.geojson";
			JsonReader reader;

			List<String> lista = new ArrayList<String>();

			reader = new JsonReader(new FileReader(path));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray ja = elem.getAsJsonObject().get("features").getAsJsonArray();
			for(JsonElement e: ja) {
				int id = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();
				String fecha = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();
				String medio = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				String Clasevehi= e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				String tipoServicio = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				String Infraccion =e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DescInfra=e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();
				String Localidad = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();


				Comparendo user = new Comparendo(id,fecha, medio, Clasevehi, tipoServicio, Infraccion, DescInfra, Localidad );
				datos.agregar(user);
				if(e.getAsJsonObject().has("geometry") && !e.getAsJsonObject().get("geometry").isJsonNull()) {
					for(JsonElement geoElem: e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()) {
						geo.add(geoElem.getAsDouble());

					}
				}
			}

			System.out.println(Arrays.toString(lista.toArray()));


		} catch (IOException e) {
			e.printStackTrace();
		}
		return geo;
	}
	public Node<Comparendo> darPrimero(){
		return primero;
	}
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Node<Comparendo> buscar(int dato)
	{
		Node <Comparendo> actual=primero;
		while(actual!=null)
		{
			if(actual.darTvalor().darID()==dato)
				return actual;
			else actual=actual.darSiguiente();

		}
		return null;
	}

	/**
	 * Requerimiento eliminar dato
	 * @param object Dato a eliminar
	 * @return dato eliminado
	 */
	public Comparendo eliminar(Comparendo object)
	{
		return  datos.eliminar(object);
	}
	public IArregloDinamico<Comparendo> dardatos(){
		return datos;
	}
	public void agregarArregloDinamico(Comparendo comparendo){
		datos.agregar(comparendo);
	}
	public void ordenarShellSort(ArregloDinamico<Comparendo> datos)
	{
		// Sort a[] into increasing order.   
		int N = datos.darTamano();  
		int h = 1;     
		while (h < N/3) h = 3*h + 1;
		// 1, 4, 13, 40, 121, 364, 1093, ...   
		while (h >= 1)      
		{  // h-sort the array.  
			for (int i = h; i < N; i++) 
			{  // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .  
				for (int j = i; j >= h && less(datos.darElemento(j),datos.darElemento(j-h)); j -= h)
				{
					datos.exch(i, j);	
				}         
				h = h/3;    
			} 
		} 
	}
	public  void ordenarPorMergeSort(ArregloDinamico<Comparendo> a, int lo, int mid, int hi) 
	{  // Merge a[lo..mid] with a[mid+1..hi].
		ArregloDinamico<Comparendo> aux = new ArregloDinamico<>(a.darTamano());
		int i = lo;
		int j = mid+1;  
		for (int k = lo; k <= hi; k++){
			// Copy a[lo..hi] to aux[lo..hi].     
			aux.agregar(a.darElemento(i));  
		}
		for (int k = lo; k <= hi; k++){
			// Merge back to a[lo..hi].   
			if      (i > mid)  
				a.cambiarElementoEnPosicion(k, aux.darElemento(j++));

			else if (j > hi )  

				a.cambiarElementoEnPosicion(k, aux.darElemento(i++));

			else if (less(aux.darElemento(j), aux.darElemento(i))) 

				a.cambiarElementoEnPosicion(k, aux.darElemento(j++));
			else          
				a.cambiarElementoEnPosicion(k, aux.darElemento(i++));
		}
	}
	public static void sort(ArregloDinamico<Comparendo> a) 
	{        
		StdRandom.shuffle(a);   
	// Eliminate dependence on input.  
	sort(a, 0, a.darTamano() - 1);  
	} 
	private static void sort(ArregloDinamico<Comparendo> a, int lo, int hi)
	{      
		if (hi <= lo) return;   
		int j = partition(a, lo, hi); 
		// Partition (see page 291).   
		sort(a, lo, j-1);          
		// Sort left part a[lo .. j-1].   
		sort(a, j+1, hi);          
		// Sort right part a[j+1 .. hi]. 
	}

	private static int partition(ArregloDinamico<Comparendo> a, int lo, int hi)
	{  // Partition into a[lo..i-1], a[i], a[i+1..hi].   
		int i = lo, j = hi+1;       
		// left and right scan indices  
		Comparendo v = a.darElemento(lo);        
		// partitioning item   while (true)  
		{  // Scan right, scan left, check for scan complete, and exchange.  
			while(true){
				while (less(a.darElemento(++i), v))
					if (i == hi)
						break;   
				while (less(v, a.darElemento(--j))) 
					if (j == lo)
						break;   
				if (i >= j)
					break;     
				a.exch( i, j); 
			}
		}  
		a.exch( lo, j);    
		// Put v = a[j] into position   
		return j;             // with a[lo..j-1] <= a[j] <= a[j+1..hi].
	}










}





