package co.edu.unbosque.modelo.estructuras;

public class NodoPrioridad extends Nodo{
	public int prioridad; // a mayor valora mayor prioridad
	
//constructur
	public NodoPrioridad(Object dato, int prioridad) {
		super(dato);
		this.prioridad=prioridad;
		// TODO Auto-generated constructor stub
	}
}
