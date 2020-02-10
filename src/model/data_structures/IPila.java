package model.data_structures;

public interface IPila <T> 
{
	public void push(T pElemento);

	public Node<T> pop();

	public int darTamanoPila();

	public boolean estaVacia();

	public Node<T> darPrimerElemento();


}
