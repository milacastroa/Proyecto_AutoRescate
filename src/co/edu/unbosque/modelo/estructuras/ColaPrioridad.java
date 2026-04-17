package co.edu.unbosque.modelo.estructuras;

public class ColaPrioridad {
	private NodoPrioridad cabeza;
	private int tamano;

	public ColaPrioridad() {
		this.cabeza = null;
		this.tamano = 0;
	}

	// mayor numero = mayor urgencia
	public void encolar(Object dato, int prioridad) {
		NodoPrioridad nuevo = new NodoPrioridad(dato, prioridad);
		if (cabeza == null || prioridad > cabeza.prioridad) {
			nuevo.siguiente = cabeza;
			cabeza = nuevo;
		} else {
			NodoPrioridad actual = cabeza;
			while (actual.siguiente != null
					&& ((NodoPrioridad) actual.siguiente).prioridad >= prioridad) {
				actual = (NodoPrioridad) actual.siguiente;
			}
			nuevo.siguiente = actual.siguiente;
			actual.siguiente = nuevo;
		}
		tamano++;
	}

	public Object desencolar() {
		if (estaVacia()) return null;
		Object dato = cabeza.dato;
		cabeza = (NodoPrioridad) cabeza.siguiente;
		tamano--;
		return dato;
	}

	public Object verificar() {
		if (estaVacia()) return null;
		return cabeza.dato;
	}

	public boolean estaVacia() {
		return cabeza == null;
	}

	public int getTamano() {
		return tamano;
	}
}
