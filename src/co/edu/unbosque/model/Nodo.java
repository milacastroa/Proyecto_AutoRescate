package co.edu.unbosque.model;

public class Nodo <T>{
	
	private T dato; 
	private Nodo<T> siguienteDato;
	
	public Nodo(T dato) {
		this.dato = dato;
		this.siguienteDato = null;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public Nodo<T> getSiguienteDato() {
		return siguienteDato;
	}

	public void setSiguienteDato(Nodo<T> siguienteDato) {
		this.siguienteDato = siguienteDato;
	}
	
	

}
