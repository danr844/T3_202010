package model.data_structures;


public class Cola<T> implements ICola<T>
{
	private Node<T> inicioCola;
	private Node<T> finCola;
	private int tamanoCola;
	
	public Cola(){
		inicioCola = null;
		finCola = null;
	}
	
	
	public boolean estavacia(){
		if(inicioCola==null)
			return true;
		else{
			return false;
		}
	}
	
	
	public void enqueue(T multa)
	{
		Node<T> nuevo = new Node<>();
		nuevo.cambiarDato(multa);
		if(estavacia())
		{
			inicioCola = nuevo;
			finCola = nuevo;
			tamanoCola++;
		}
		else if(inicioCola.darSiguiente()==null)
		{
			inicioCola.cambiarSiguiente(nuevo);
			tamanoCola++;
			finCola=nuevo;
		}
		else
		{
			finCola.cambiarSiguiente(nuevo);
			finCola = nuevo;
			tamanoCola++;
		}
	}
<<<<<<< HEAD
	public T dequeue()
=======
	public Node<T> dequeue()
>>>>>>> 241eafb98e096ca4faec158e3036bb10e3a01bda
	{
		if(!estavacia())
		{
			Node<T> valorEliminado = inicioCola;
			if(inicioCola.darSiguiente()!=null)
			{
				inicioCola = inicioCola.darSiguiente();
				tamanoCola--;
			}
<<<<<<< HEAD
			else
			{
				inicioCola= null;
				tamanoCola--;
			}
			return valorEliminado.darTvalor();
=======
			else{
				inicioCola= null;
				tamanoCola = 0;
			}
			return valorEliminado;
>>>>>>> 241eafb98e096ca4faec158e3036bb10e3a01bda
		}
		else
		{
			return null;
		}
	}
	
<<<<<<< HEAD
	public int dartamanoCola(){
		return tamanoCola;
	}
=======
	
	public int dartamanoCola()
	{
		return tamanoCola;
	}
	
	
	public Node<T> darPrimerElemento()
	{
		return inicioCola;
	}
>>>>>>> 241eafb98e096ca4faec158e3036bb10e3a01bda

}
