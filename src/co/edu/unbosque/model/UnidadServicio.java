package co.edu.unbosque.model;

import java.util.UUID;

public class UnidadServicio {

    private UUID id;
    private String placa;
    private TipoUnidad tipo;
    private EstadoUnidad estado;
    private String zona;
    private boolean disponible;
    private KitAtencion kitAsignado;

    public UnidadServicio(String placa, TipoUnidad tipo, String zona) {
        this.id = UUID.randomUUID();
        this.placa = placa;
        this.tipo = tipo;
        this.zona = zona;
        this.estado = null;
        this.disponible = true;
        this.kitAsignado = null;
    }

   
    public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
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


	public KitAtencion getKitAsignado() {
		return kitAsignado;
	}


	public void setKitAsignado(KitAtencion kitAsignado) {
		this.kitAsignado = kitAsignado;
	}


	@Override
    public String toString() {
        return "UnidadServicio{" +
                "placa='" + placa + '\'' +
                ", tipo=" + tipo +
                ", estado=" + estado +
                ", zona='" + zona + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}