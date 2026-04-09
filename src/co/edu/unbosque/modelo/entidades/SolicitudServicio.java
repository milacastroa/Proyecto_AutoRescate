package co.edu.unbosque.modelo.entidades;

import java.util.UUID;

public class SolicitudServicio {
	private String id;
	private Cliente cliente;
	private TipoServicio tipoServicio;
	private NivelCriticidad criticidad;
	private EstadoSolicitud estado;
	private UnidadServicio unidadAsignada;
	private Tecnico tecnicoAsignado;
	private long timestamp;
	
//Constructor
	public SolicitudServicio(Cliente cliente,TipoServicio tipoServicio, NivelCriticidad criticidad) {
		this.id=UUID.randomUUID().toString();
		this.cliente=cliente;
		this.tipoServicio=tipoServicio;
		this.criticidad=criticidad;
		this.estado=EstadoSolicitud.PENDIENTE;
		this.unidadAsignada=null;
		this.tecnicoAsignado=null;
		this.timestamp=System.currentTimeMillis();
	}
//Metodos
	public int getPrioridad() {
		if(criticidad==NivelCriticidad.CRITICO) {
			return 2;
		}
		return 1;
	}
	
	public void asignarUnidad(UnidadServicio unidad) {
		this.unidadAsignada=unidad;
		unidad.setDisponible(false);
		unidad.setEstado(EstadoUnidad.ASIGNADO);
	}
	
	public void asignarTecnico(Tecnico tecnico) {
		this.tecnicoAsignado=tecnico;
		tecnico.setDisponible(false);
	}
	public String csv() {
		return  id+","+
				cliente.getNombre()+","+
				tipoServicio+","+
				criticidad+","+
				estado+","+
				(unidadAsignada != null ? unidadAsignada.getId() : "Sin unidad")+","+
				(tecnicoAsignado !=null ? tecnicoAsignado.getNombre(): "Sin tecnico")+","+
				timestamp;
	}
@Override
	public String toString() {
		return "Solicitud:"+id+":"+cliente.getNombre()+":"+tipoServicio+":"+criticidad+":"+estado;
}
public String getId() {
	return id; }
public Cliente getCliente() {
	return cliente; }
public TipoServicio getTipoServicio() {
	return tipoServicio; }
public NivelCriticidad getCriticidad() {
	return criticidad; }
public EstadoSolicitud getEstado() {
	return estado; }
public void setEstado(EstadoSolicitud estado) {
	this.estado = estado; }
public UnidadServicio getUnidadAsignada() {
	return unidadAsignada; }
public Tecnico getTecnicoAsignado() {
	return tecnicoAsignado; }
public long getTimestamp() {
	return timestamp; }
}
