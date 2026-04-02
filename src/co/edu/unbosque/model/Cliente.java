package co.edu.unbosque.model;

import java.util.UUID;

public class Cliente {

    private UUID id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipoCliente;
    private String zona;

    public Cliente(String nombre, String apellido, String telefono, String tipoCliente, String zona) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
        this.zona = zona;
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



	public String getTipoCliente() {
		return tipoCliente;
	}



	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}



	public String getZona() {
		return zona;
	}



	public void setZona(String zona) {
		this.zona = zona;
	}



	@Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tipoCliente='" + tipoCliente + '\'' +
                ", zona='" + zona + '\'' +
                '}';
    }
}
