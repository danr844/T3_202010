package model.data_structures;

public class Node {
	
	private int OBJECT_ID;
	private String FECHA_HORA;
	private String Infraccion;
	private String CLASE_VEHICULO;
	private String TIPO_SERVICIO;
	private String LOCALIDAD;
	private Node siguiente;
	private Node anterior;
	
	
	public Node (int pOBJECT_ID, String pFECHA_HORA, String pInfraccion, String pCLASE_VEHICULO, String pTIPO_SERVICIO, String pLOCALIDAD){
		OBJECT_ID = pOBJECT_ID;
		FECHA_HORA= pFECHA_HORA;
		Infraccion= pInfraccion;
		CLASE_VEHICULO = pCLASE_VEHICULO;
		TIPO_SERVICIO=pTIPO_SERVICIO;
		LOCALIDAD= pLOCALIDAD;
		siguiente = null;
		anterior = null;
		
		
	}

	public int darID(){
		return OBJECT_ID;
	}
	public String darFecha(){
		return FECHA_HORA;
	}
	public String darInfraccion(){
		return Infraccion;
	}
	public String darClaseVehiculo(){
		return CLASE_VEHICULO;
	}
	public String darTipoServicio(){
		return TIPO_SERVICIO;
	}
	public String darLocalidad(){
		return LOCALIDAD;
	}
	public Node darSiguiente(){
		return siguiente;
	}
	public void cambiarSiguiente(Node pSiguiente){
		siguiente = pSiguiente;
	}
	public Node darAnterior(){
		return anterior;
	}
	public void cambiarAnterior(Node pAnterior){
		anterior = pAnterior;
	}
	public void desconectarSiguiente(){
		cambiarSiguiente(siguiente.darSiguiente());
		siguiente.darSiguiente().cambiarAnterior(this);
	}
}
