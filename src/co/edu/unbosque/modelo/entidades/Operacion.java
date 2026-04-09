package co.edu.unbosque.modelo.entidades;

public class Operacion {
 private TipoOperacion tipo;
 private String descripcion;
 private long timestamp;
 private String datosAntes;
 
//Constructor
 public Operacion(TipoOperacion tipo,String descripcion,String datosAntes) {
	 this.tipo=tipo;
	 this.descripcion=descripcion;
	 this.datosAntes=datosAntes;
	 this.timestamp=System.currentTimeMillis();	 
 }
@Override
	public String toString() {
	return "Operacion:"+tipo+":"+descripcion+":"+timestamp;
}
public TipoOperacion getTipo() {
	return tipo;
}
public String getDescripcion() {
	return descripcion;
}
public long getTimestamp() {
	return timestamp;
}
public String getDatosAntes() {
	return datosAntes;
}
}
