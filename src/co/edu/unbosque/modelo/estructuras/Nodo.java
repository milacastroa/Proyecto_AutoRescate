package co.edu.unbosque.modelo.estructuras;

public class Nodo {
	public Object dato; // se deja como object para que lo podamos usar con cualquier tipo de dato.
	
	public Nodo siguiente;
	
// constructor
	public Nodo(Object dato) {
		this.dato= dato;
		this.siguiente = null;
	}
}
