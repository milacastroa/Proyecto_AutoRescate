package co.edu.unbosque.modelo.entidades;

import java.util.UUID;

public class UnidadServicio {
	private String id;
	private TipoUnidad tipo;
	private EstadoUnidad estado;
	private String zona;
	private boolean disponible;	
//Constructor
	public UnidadServicio(TipoUnidad tipo,String zona){
		this.id=UUID.randomUUID().toString();
		this.tipo=tipo;
		this.estado=EstadoUnidad.DISPONIBLE;
		this.zona=zona;
		this.disponible=true;
	}
@Override
	public String toString() {
	return "UnidadServicio:"+id+":"+tipo+":"+estado+":"+zona+":"+disponible;
}
//Getters y setters
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public TipoUnidad getTipo() {
	return tipo;
}
public void setTipo(TipoUnidad tipo) {
	this.tipo = tipo;
}
public EstadoUnidad getEstado() {
	return estado;
}
public void setEstado(EstadoUnidad estado) {
	this.estado = estado;
}
public String getZona() {
	return zona;
}
public void setZona(String zona) {
	this.zona = zona;
}
public boolean isDisponible() {
	return disponible;
}
public void setDisponible(boolean disponible) {
	this.disponible = disponible;
}

}
