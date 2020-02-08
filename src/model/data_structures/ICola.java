package model.data_structures;

public interface ICola <T>{
	
	public void enqueue(T multa);
	
	public Node<T> dequeue();
	
	public boolean estavacia();
	
	public int dartamanoCola();
	
	public Node<T> darPrimerElemento();







}
