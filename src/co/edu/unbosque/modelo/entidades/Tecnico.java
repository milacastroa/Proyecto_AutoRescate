package co.edu.unbosque.modelo.entidades;
import java.util.UUID;


public class Tecnico {
	private String id;
	private String nombre;
	private EspecialidadTecnico especialidad;
	private String zona;
	private boolean disponible;
	
//Constructor
	public Tecnico(String nombre, EspecialidadTecnico especialidad,String zona) {
		this.id=UUID.randomUUID().toString();
		this.nombre=nombre;
		this.especialidad=especialidad;
		this.zona=zona;
		this.disponible=true;
	}
	
@Override
	public String toString() {
	return "Tecnico:"+id+":"+nombre+":"+especialidad+":"+zona+":"+disponible; 
}
// Getters y Setters

	public String getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public EspecialidadTecnico getEspecialidad() {
		return especialidad;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}
	
	
}
