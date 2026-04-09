package co.edu.unbosque.modelo.entidades;
import java.util.UUID;

public class Cliente {
	private String id;
	private String nombre;
	private TipoCliente tipo;
	
//Constructor
	public Cliente(String nombre,TipoCliente tipo) {
		this.id=UUID.randomUUID().toString();// Esto va a generar un valor random
		this.nombre=nombre;
		this.tipo=tipo;
	}
@Override
	public String toString() {
	return "Cliente: "+id+":"+nombre+":"+tipo;
}
//Getters y setters
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public TipoCliente getTipo() {
	return tipo;
}
public void setTipo(TipoCliente tipo) {
	this.tipo = tipo;
}
 
}
