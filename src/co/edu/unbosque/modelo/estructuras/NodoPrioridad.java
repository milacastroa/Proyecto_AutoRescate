package co.edu.unbosque.modelo.estructuras;

public class NodoPrioridad extends Nodo {
	public int prioridad; // mayor valor = mayor urgencia

	public NodoPrioridad(Object dato, int prioridad) {
		super(dato);
		this.prioridad = prioridad;
	}
}
