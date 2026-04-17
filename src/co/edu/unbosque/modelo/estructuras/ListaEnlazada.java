package co.edu.unbosque.modelo.estructuras;

public class ListaEnlazada {
	private Nodo cabeza;
	private int tamano;

	public ListaEnlazada() {
		this.cabeza = null;
		this.tamano = 0;
	}

	public void insertar(Object dato) {
		Nodo nuevo = new Nodo(dato);
		if (cabeza == null) {
			cabeza = nuevo;
		} else {
			Nodo actual = cabeza;
			while (actual.siguiente != null) {
				actual = actual.siguiente;
			}
			actual.siguiente = nuevo;
		}
		tamano++;
	}

	// busca por subcadena del toString del objeto
	public Object buscar(String id) {
		Nodo actual = cabeza;
		while (actual != null) {
			if (actual.dato.toString().contains(id)) {
				return actual.dato;
			}
			actual = actual.siguiente;
		}
		return null;
	}

	public boolean eliminar(String id) {
		if (cabeza == null) return false;
		if (cabeza.dato.toString().contains(id)) {
			cabeza = cabeza.siguiente;
			tamano--;
			return true;
		}
		Nodo anterior = cabeza;
		while (anterior.siguiente != null) {
			if (anterior.siguiente.dato.toString().contains(id)) {
				anterior.siguiente = anterior.siguiente.siguiente;
				tamano--;
				return true;
			}
			anterior = anterior.siguiente;
		}
		return false;
	}

	// devuelve todos los datos para que la vista los procese
	public Object[] obtenerTodos() {
		Object[] resultado = new Object[tamano];
		Nodo actual = cabeza;
		for (int i = 0; i < tamano; i++) {
			resultado[i] = actual.dato;
			actual = actual.siguiente;
		}
		return resultado;
	}

	public int getTamano() {
		return tamano;
	}

	public boolean estaVacia() {
		return cabeza == null;
	}
}
