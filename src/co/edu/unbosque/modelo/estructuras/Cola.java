package co.edu.unbosque.modelo.estructuras;

public class Cola {
	private Nodo frente; // salida
	private Nodo fin;    // entrada
	private int tamano;

	public Cola() {
		this.frente = null;
		this.fin = null;
		this.tamano = 0;
	}

	public void encolar(Object dato) {
		Nodo nuevo = new Nodo(dato);
		if (estaVacia()) {
			frente = nuevo;
			fin = nuevo;
		} else {
			fin.siguiente = nuevo;
			fin = nuevo;
		}
		tamano++;
	}

	public Object desencolar() {
		if (estaVacia()) return null;
		Object dato = frente.dato;
		frente = frente.siguiente;
		if (frente == null) fin = null;
		tamano--;
		return dato;
	}

	public Object verificar() {
		if (estaVacia()) return null;
		return frente.dato;
	}

	public boolean estaVacia() {
		return frente == null;
	}

	public int getTamano() {
		return tamano;
	}
}
