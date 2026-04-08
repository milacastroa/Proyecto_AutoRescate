package co.edu.unbosque.modelo.estructuras;

public class Pila {
	private Nodo cima;
	private int tamaño;
//Constructor
	public Pila(Nodo cima, int tamaño) {
		this.cima = null;
		this.tamaño=0; // igual que en la lista dejamos todo preparado para iniciarla desde ceros	
	}
	
//Metodos
	public void apilar(Object dato) {
		Nodo nuevo = new Nodo(dato);
		nuevo.siguiente = cima;
		cima=nuevo;
		tamaño++;
	}
	
	public Object desapilar() {
		if(estaVacia()){
			return null;
		}
		
		Object dato = cima.dato;
		cima=cima.siguiente;
		tamaño--;
		return dato; // devuelve la informacion que sale de la pila 
		
	}
	
	public boolean estaVacia() {
		return cima==null;
	}
	
	public int getTamaño() {
		return tamaño;
	}
}
