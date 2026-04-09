package co.edu.unbosque.modelo.estructuras;

public class ListaEnlazada {
	private Nodo cabeza;
	private int tamaño;
	
// Constructor
	public ListaEnlazada() {
		this.cabeza= null; // se inicializa vacia hasta que se determine su uso
		this.tamaño=0; // igual que la cabeza, luego se define longitudes
	}
// Metodos principales
	public void insertar(Object dato) {
		Nodo nuevo = new Nodo(dato);
		if(cabeza==null) {
			cabeza=nuevo;
		}else {
			Nodo actual=cabeza;
			while(actual.siguiente!=null) {
				actual= actual.siguiente; // hace que avance hasta el ultimo
			}
			actual.siguiente=nuevo; // aca cuando encuentra el ultimo pues añade la insercion y queda de ultimo
		}
		tamaño ++;
	}
	
	public Object buscar(String id) {
		Nodo actual=cabeza;
			while(actual != null) {
				if(actual.dato.toString().contains(id)) {
					return actual.dato;
				}
				actual = actual.siguiente;
			}
			return null; 
	}
	
	public boolean eliminar(String id) {
		if(cabeza==null) {
			return false;
		}
		
		//Si se elimina la cabeza
		if(cabeza.dato.toString().contains(id)) {
			cabeza = cabeza.siguiente;
			tamaño --;
			return true;
		}
		
		// uso normal
		Nodo anterior=cabeza;
			while(anterior.siguiente!=null) {
				if(anterior.siguiente.dato.toString().contains(id)) {
					anterior.siguiente=anterior.siguiente.siguiente;
					tamaño--;
					return true;
				}
				anterior=anterior.siguiente;
			}
			return false;
	}
	
	public Object[] obtenerTodos() {// devuelve todos los datos del arreglo para que la vista los muestre como necesite
		Object[] resultado = new Object[tamaño];
		Nodo actual = cabeza;
		for(int i=0;i<tamaño;i++) {
			resultado[i]= actual.dato;
			actual=actual.siguiente;
		}
		return resultado;
	}

// getters y setters
	public int getTamaño() {
		return tamaño;
	}
	
	public boolean estaVacia() {
		return cabeza == null;
	}
	
	
	
}
