package co.edu.unbosque.modelo.estructuras;

public class Cola {
	private Nodo frente;//salida
	private Nodo fin;// entrada
	private int tamaño;
	
//Constructor	
	public Cola(Nodo frente, Nodo fin, int tamaño) {
		//al iniciar la cola esta completamente vacia
		this.frente=null;
		this.fin=null;
		this.tamaño=0;
	}

//Metodos
	public void encolar(Object dato) {
		Nodo nuevo = new Nodo(dato);
		if(estaVacia()) {
			frente = nuevo;
			fin = nuevo;
		}else {
			fin.siguiente=nuevo;
			fin = nuevo;
		}
		tamaño++;
	}
	
	public Object desencolar() {
		if(estaVacia()) {
			return null;
		}
		
		Object dato = frente.dato;
		frente= frente.siguiente; 
		
		if(frente==null) {
			fin=null;
		}
		tamaño--;
		return dato;
	}
	
	public Object verificar() {
		if(estaVacia()){
			return null;
		}
		return frente.dato;
	}
	
	public boolean estaVacia() {
		return frente==null;
	}
	
	public int getTamaño() {
		return tamaño;
	}
}
