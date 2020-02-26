package test.logic;

import static org.junit.Assert.*;

import model.data_structures.Comparendo;
import model.data_structures.Node;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	private Comparendo nueva;
	private Node<Comparendo> nodo;
	private Comparendo nueva2;


	
	@Before
	public void setUp1() {
		modelo= new Modelo();
		nueva = new Comparendo(1234, "hola1", "hola2", "hola3", "hola4", "hola5", "hola", "hola7");
		nueva2 = new Comparendo(0000, "0000", "0009", "0008", "0007", "0006", "0005", "0004");
		
		nodo=new Node<Comparendo>();
		Node<Comparendo> nodo2 =new Node<Comparendo>();

		nodo.cambiarDato(nueva);
		nodo2.cambiarDato(nueva2);
		
		nodo.cambiarSiguiente(nodo2);
		
		modelo.agregarArregloDinamico(nueva);
		modelo.agregarArregloDinamico(nueva2);
		
	}

	public void setUp2() {
		//test para el arreglo dinamico, no aplica.
	}

	@Test
	public void testModelo() {
		setUp1();
		assertTrue(modelo!=null);
	}

	@Test
	public void testDarTamano() {
		// TODO
		setUp1();
		assertEquals("No tiene el tamaño esperado", 2, modelo.darNumeroNodos());
		
	}

	@Test
	public void testAgregar() 
	{
			// TODO Completar la prueba
		setUp1();
		assertEquals("No tiene el tamaño esperado", 2, modelo.darNumeroNodos());
		nueva = new Comparendo(1, "hola1", "hola2", "hola3", "hola4", "hola5", "hola", "hola7");
		modelo.agregarArregloDinamico(nueva);
		assertEquals("No tiene el tamaño esperado", 3, modelo.darNumeroNodos());

			
	}

	@Test
	public void testBuscar()
	{
		setUp1();
		// TODO Completar la prueba
		assertNotNull("El objeto no deberia ser null", modelo.buscar(1234));
		assertNotNull("El objeto no deberia ser null", modelo.buscar(0000));
		assertNull("El objeto deberia ser distinto de null",modelo.buscar(1));
	}
	@Test
	
	public void testCargarInfo() {
		setUp2();
		assertNotNull("la informacon no fue cargada", modelo.cargarInfo());
	}

}
