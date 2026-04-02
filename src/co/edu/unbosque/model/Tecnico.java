package co.edu.unbosque.model;

import java.util.UUID;

public class Tecnico {
	
	private UUID id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String especialidad;
	private String zona;
	private boolean asignado;
	private UnidadServicio unidadActual;
	
	public Tecnico(UUID id, String nombre, String apellido, String telefono, String especialidad, String zona,
			boolean asignado, UnidadServicio unidadActual) {
		this.id = UUID.randomUUID();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.especialidad = especialidad;
		this.zona = zona;
		this.asignado = false;
		this.unidadActual = null;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public boolean isAsignado() {
		return asignado;
	}

	public void setAsignado(boolean asignado) {
		this.asignado = asignado;
	}

	public UnidadServicio getUnidadActual() {
		return unidadActual;
	}

	public void setUnidadActual(UnidadServicio unidadActual) {
		this.unidadActual = unidadActual;
	}

	@Override
	public String toString() {
		return "Tecnico [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", especialidad=" + especialidad + ", zona=" + zona + ", asignado=" + asignado + ", unidadActual="
				+ unidadActual + "]";
	}
	
	

}
