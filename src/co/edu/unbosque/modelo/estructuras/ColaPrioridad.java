package co.edu.unbosque.modelo.estructuras;

public class ColaPrioridad {
	private Nodo cabeza;
	private int tamaño;

//Constructor
	public ColaPrioridad() {
		this.cabeza=null;
		this.tamaño=0;
	}
//Metodos
	public void encolar(Object dato, int prioridad) {// el mayor numero es el mas urgente
		NodoPrioridad nuevo = new NodoPrioridad(dato,prioridad);
		
		//caso vacia
		if(cabeza==null|| prioridad > ((NodoPrioridad)cabeza).prioridad) {
			nuevo.siguiente=cabeza;
			cabeza=nuevo;
		}else { // se busca donde debe estar en terminos de prioridad
			NodoPrioridad actual = (NodoPrioridad) cabeza;
				while (actual.siguiente!=null&&((NodoPrioridad)actual.siguiente).prioridad>=prioridad) {
					actual=(NodoPrioridad)actual.siguiente;
				}
				nuevo.siguiente = actual.siguiente;
				actual.siguiente=nuevo;
		}
		tamaño++;
	}
	
	public Object desencolar() {
		if(estaVacia()) {
			return null;
		}
		
		Object dato = cabeza.dato;
		cabeza= cabeza.siguiente;
		tamaño--;
		return dato;
	}
	
	public Object verificar() {
		if(estaVacia()) {
			return null;
		}
		return cabeza.dato;
	}
	
	public boolean estaVacia() {
		return cabeza==null;
	}
	
	public int getTamaño() {
		return tamaño;
	}
}
