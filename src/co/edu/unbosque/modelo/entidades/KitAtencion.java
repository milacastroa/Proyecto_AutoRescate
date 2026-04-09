package co.edu.unbosque.modelo.entidades;

import java.util.UUID;

public class KitAtencion {
	private String id;
	private TipoServicio tipo;
	private boolean enRevision;
	
//Constructor
	public KitAtencion(TipoServicio tipo) {
		this.id=UUID.randomUUID().toString();
		this.tipo=tipo;
		this.enRevision=true;
	}
	
@Override
	public String toString() {
	return "KitAtencion:"+id+":"+tipo+":"+enRevision;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public TipoServicio getTipo() {
	return tipo;
}

public void setTipo(TipoServicio tipo) {
	this.tipo = tipo;
}

public boolean isEnRevision() {
	return enRevision;
}

public void setEnRevision(boolean enRevision) {
	this.enRevision = enRevision;
}


}
