package co.edu.unbosque.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class SolicitudServicio {

    private UUID id;
    private Cliente cliente;
    private TipoServicio tipoServicio;
    private NivelPrioridad prioridad;
    private String descripcion;
    private String estado;
    private String ubicacion;
    private LocalDateTime horaCreacion;

    public SolicitudServicio(Cliente cliente, TipoServicio tipoServicio, NivelPrioridad prioridad,
                              String descripcion, String ubicacion) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.tipoServicio = tipoServicio;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.estado = "PENDIENTE";
        this.horaCreacion = LocalDateTime.now();
    }

    public UUID getId() { return id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public TipoServicio getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(TipoServicio tipoServicio) { this.tipoServicio = tipoServicio; }

    public NivelPrioridad getPrioridad() { return prioridad; }
    public void setPrioridad(NivelPrioridad prioridad) { this.prioridad = prioridad; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public LocalDateTime getHoraCreacion() { return horaCreacion; }

    @Override
    public String toString() {
        return "SolicitudServicio{" +
                "cliente=" + cliente.getNombre() + ' ' + cliente.getApellido() +
                ", tipoServicio=" + tipoServicio +
                ", prioridad=" + prioridad +
                ", estado='" + estado + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", horaCreacion=" + horaCreacion +
                '}';
    }
}