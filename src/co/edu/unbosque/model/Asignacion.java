package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Asignacion {
	
	private UUID id;
	private SolicitudServicio solicitud;
	private UnidadServicio unidad;
	private Tecnico tecnico;
    private LocalDateTime horaAsignacion;
    private LocalDateTime horaFinalizacion;
    private String estado;
    
    
	public Asignacion(UUID id, SolicitudServicio solicitud, UnidadServicio unidad, Tecnico tecnico,
			LocalDateTime horaAsignacion, LocalDateTime horaFinalizacion, String estado) {
		this.id = UUID.randomUUID();
		this.solicitud = solicitud;
		this.unidad = unidad;
		this.tecnico = tecnico;
		this.horaAsignacion = LocalDateTime.now();
		this.horaFinalizacion = null;
		this.estado = "Activa";
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public SolicitudServicio getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(SolicitudServicio solicitud) {
		this.solicitud = solicitud;
	}
	public UnidadServicio getUnidad() {
		return unidad;
	}
	public void setUnidad(UnidadServicio unidad) {
		this.unidad = unidad;
	}
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	public LocalDateTime getHoraAsignacion() {
		return horaAsignacion;
	}
	public void setHoraAsignacion(LocalDateTime horaAsignacion) {
		this.horaAsignacion = horaAsignacion;
	}
	public LocalDateTime getHoraFinalizacion() {
		return horaFinalizacion;
	}
	public void setHoraFinalizacion(LocalDateTime horaFinalizacion) {
		this.horaFinalizacion = horaFinalizacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Asignacion [id=" + id + ", solicitud=" + solicitud + ", unidad=" + unidad + ", tecnico=" + tecnico
				+ ", horaAsignacion=" + horaAsignacion + ", horaFinalizacion=" + horaFinalizacion + ", estado=" + estado
				+ "]";
	}
    

}
