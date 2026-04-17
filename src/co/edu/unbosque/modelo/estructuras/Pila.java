package co.edu.unbosque.modelo.estructuras;

public class Pila {
	private Nodo cima;
	private int tamano;

	public Pila() {
		this.cima = null;
		this.tamano = 0;
	}

	public void apilar(Object dato) {
		Nodo nuevo = new Nodo(dato);
		nuevo.siguiente = cima;
		cima = nuevo;
		tamano++;
	}

	public Object desapilar() {
		if (estaVacia()) return null;
		Object dato = cima.dato;
		cima = cima.siguiente;
		tamano--;
		return dato;
	}

	public boolean estaVacia() {
		return cima == null;
	}

	public int getTamano() {
		return tamano;
	}
}
