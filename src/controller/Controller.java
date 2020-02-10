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
			int option = lector.nextInt();
			switch(option)
			{
			case 1:
				view.printMessage("------------------------------------------------------------------------\n Se esta cargando la informacion \n------------------------------------------------------------------------");
					modelo.cargarInfo();
				if(modelo.darPrimero()!=null)
				{
					Node<Multa> encontradoPila = modelo.darPrimerNodoPila();
					Node<Multa> encontradoCola = modelo.darPrimerNodoCola();

					view.printMessage("Primer comparendo en la Cola:"+ encontradoCola.darTvalor().darID()+","+encontradoCola.darTvalor().darFecha()+","+ encontradoCola.darTvalor().darClaseVehiculo()+","+encontradoCola.darTvalor().darTipoServicio()+","+encontradoCola.darTvalor().darLocalidad()+"\n---------------------------");
					view.printMessage("Primer comparendo en la Pila: "+ encontradoPila.darTvalor().darID()+","+encontradoPila.darTvalor().darFecha()+","+ encontradoPila.darTvalor().darClaseVehiculo()+","+encontradoPila.darTvalor().darTipoServicio()+","+encontradoPila.darTvalor().darLocalidad()+"\n---------------------------");
					view.printMessage("Total de comparendos leidos: "+modelo.darTamanoPila());
					view.printMessage("------------------------------------------------------------------------");

				}
				break;

			case 2:
				view.printMessage("------------------------------------------------------------------------\n Ingrese el id buscado: \n------------------------------------------------------------------------");
				int idBuscada = lector.nextInt();

				//Node<Multa> encontrado=modelo.buscar(idBuscada);
				//view.printMessage(""+ encontrado.darTvalor().darID()+","+encontrado.darTvalor().darFecha()+","+ encontrado.darTvalor().darClaseVehiculo()+","+encontrado.darTvalor().darTipoServicio()+","+encontrado.darTvalor().darLocalidad()+"\n---------------------------");

				break;


			default: 
				view.printMessage("--------------------------------------------------------------- \n Opcion Invalida !! \n---------------------------------------------------------------");
				break;
			}
		}




	}	
}
