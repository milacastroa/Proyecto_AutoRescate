package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.UUID;

public class KitAtencion {

    private UUID id;
    private String codigo;
    private String descripcion;
    private boolean enRevision;
    private boolean elementosCompletos;
    private LocalDate fechaUltimaRevision;

    public KitAtencion(String codigo, String descripcion) {
        this.id = UUID.randomUUID();
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.enRevision = false;
        this.elementosCompletos = true;
        this.fechaUltimaRevision = LocalDate.now();
    }

    public UUID getId() { return id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isEnRevision() { return enRevision; }
    public void setEnRevision(boolean enRevision) { this.enRevision = enRevision; }

    public boolean isElementosCompletos() { return elementosCompletos; }
    public void setElementosCompletos(boolean elementosCompletos) { this.elementosCompletos = elementosCompletos; }

    public LocalDate getFechaUltimaRevision() { return fechaUltimaRevision; }
    public void setFechaUltimaRevision(LocalDate fechaUltimaRevision) { this.fechaUltimaRevision = fechaUltimaRevision; }

    @Override
    public String toString() {
        return "KitAtencion{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", enRevision=" + enRevision +
                ", elementosCompletos=" + elementosCompletos +
                ", fechaUltimaRevision=" + fechaUltimaRevision +
                '}';
    }
}
