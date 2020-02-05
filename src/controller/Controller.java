package controller;

import java.util.Scanner;

import com.sun.glass.events.ViewEvent;

import model.data_structures.Multa;
import model.data_structures.Node;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		
		Integer respuesta = 0;

		while( !fin ){
			view.printMenu();
			Integer dato =0;
			int option = lector.nextInt();
			switch(option){
				case 1:
					view.printMessage("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
				    int capacidad = lector.nextInt();
				    modelo = new Modelo(capacidad); 
				    view.printMessage("Arreglo Dinamico creado");
				    view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 2:
					view.printMessage("--------- \nDar cadena (simple) a ingresar: ");
					dato = lector.nextInt();
					view.printMessage("Dato agregado");
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 3:
					view.printMessage("--------- \nDar cadena (simple) a buscar: ");
					dato = lector.nextInt();
					respuesta = modelo.buscar(dato);
					if ( respuesta != null)
					{
						view.printMessage("Dato encontrado: "+ respuesta);
					}
					else
					{
						view.printMessage("Dato NO encontrado");
					}
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 4:
					view.printMessage("--------- \nDar cadena (simple) a eliminar: ");
					dato = lector.nextInt();
					respuesta = modelo.eliminar(dato);
					if ( respuesta != null)
					{
						view.printMessage("Dato eliminado "+ respuesta);
					}
					else
					{
						view.printMessage("Dato NO eliminado");							
					}
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 5: 
					view.printMessage("--------- \nContenido del Arreglo: ");
					view.printModelo(modelo);
					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;	
					
				case 6: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	
				case 7:
					view.printMessage("--------- Se esta cargando la informacion \n---------");
					modelo.cargarInfo();
					if(modelo.darPrimero()!=null){
						Node<Multa> actual = modelo.darPrimero();
						while(actual!=null){
							view.printMessage(""+actual.darTvalor().darID()+" "+actual.darTvalor().darFecha()+" "+ actual.darTvalor().darMedio()+" "+actual.darTvalor().darClaseVehiculo()+" "+actual.darTvalor().darTipoServicio()+" "+actual.darTvalor().darInfraccion()+" "+actual.darTvalor().darDescInfo()+" "+ actual.darTvalor().darLocalidad());
							actual = actual.darSiguiente();
						}
					}
					
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
