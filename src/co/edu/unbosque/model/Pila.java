package co.edu.unbosque.model;

public class Pila <T>{
	
	private Nodo<T> top;
	
	public Pila() {
		this.top= null;
	}
	
	public void push(T dato) {
		
		Nodo<T> nodo = new Nodo<T>(dato);
		nodo.setSiguienteDato(top);
		top = nodo;
		
	}
	
	public T pop() {
		
	    if (isEmpty()) {
	        return null; 
	    }
		T dato = top.getDato();
		top = top.getSiguienteDato();
		return dato;
	}
	
	public T peek() {
		if (isEmpty()) {
	        return null; 
	    }
		return top.getDato();
	}
	
	public boolean isEmpty() {
		return top == null;
		
	}
}
