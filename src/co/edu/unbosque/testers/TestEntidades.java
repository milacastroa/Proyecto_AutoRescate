package co.edu.unbosque.testers;

import co.edu.unbosque.modelo.entidades.*;

public class TestEntidades {

    public static void main(String[] args) {
        testCliente();
        testTecnico();
        testUnidad();
        testKitYOperacion();
        testSolicitud();
    }

    static void testCliente() {
        System.out.println("=== TEST CLIENTE ===");
        Cliente c = new Cliente("Juan Perez", TipoCliente.PARTICULAR);
        System.out.println("ToString: " + c);
        System.out.println("getId no null esperado true: " + (c.getId() != null));
        System.out.println("getNombre esperado Juan Perez: " + c.getNombre());
        System.out.println("getTipo esperado PARTICULAR: " + c.getTipo());
        System.out.println();
    }

    static void testTecnico() {
        System.out.println("=== TEST TECNICO ===");
        Tecnico t = new Tecnico("Carlos Lopez", EspecialidadTecnico.MECANICA, "Norte");
        System.out.println("ToString: " + t);
        System.out.println("Disponible arranca true: " + t.isDisponible());
        t.setDisponible(false);
        System.out.println("Disponible tras setear false: " + t.isDisponible());
        System.out.println();
    }

    static void testUnidad() {
        System.out.println("=== TEST UNIDAD SERVICIO ===");
        UnidadServicio u = new UnidadServicio(TipoUnidad.GRUA, "Sur");
        System.out.println("ToString: " + u);
        System.out.println("Estado arranca DISPONIBLE: " + u.getEstado());
        System.out.println("Disponible arranca true: " + u.isDisponible());
        u.setEstado(EstadoUnidad.MANTENIMIENTO);
        u.setDisponible(false);
        System.out.println("Estado tras cambio MANTENIMIENTO: " + u.getEstado());
        System.out.println("Disponible tras cambio false: " + u.isDisponible());
        System.out.println();
    }

    static void testKitYOperacion() {
        System.out.println("=== TEST KIT Y OPERACION ===");
        KitAtencion k = new KitAtencion(TipoServicio.BATERIA);
        System.out.println("ToString kit: " + k);
        System.out.println("enRevision arranca true: " + k.isEnRevision());
        k.setEnRevision(false);
        System.out.println("enRevision tras liberar false: " + k.isEnRevision());

        Operacion op = new Operacion(TipoOperacion.CAMBIO_ESTADO, "Cambio a mantenimiento", "DISPONIBLE");
        System.out.println("ToString operacion: " + op);
        System.out.println("getDatosAntes esperado DISPONIBLE: " + op.getDatosAntes());
        System.out.println();
    }

    static void testSolicitud() {
        System.out.println("=== TEST SOLICITUD SERVICIO ===");
        Cliente c = new Cliente("Maria Torres", TipoCliente.ASEGURADORA);
        Tecnico t = new Tecnico("Luis Gomez", EspecialidadTecnico.ELECTRICA, "Centro");
        UnidadServicio u = new UnidadServicio(TipoUnidad.MOTO, "Centro");

        SolicitudServicio s = new SolicitudServicio(c, TipoServicio.BATERIA, NivelCriticidad.CRITICO);
        System.out.println("ToString: " + s);
        System.out.println("Estado arranca PENDIENTE: " + s.getEstado());
        System.out.println("Prioridad critico esperado 2: " + s.getPrioridad());

        // Verificar que asignar unidad cambia su estado
        s.asignarUnidad(u);
        s.asignarTecnico(t);
        System.out.println("Unidad disponible tras asignar esperado false: " + u.isDisponible());
        System.out.println("Unidad estado tras asignar esperado ASIGNADO: " + u.getEstado());
        System.out.println("Tecnico disponible tras asignar esperado false: " + t.isDisponible());

        s.setEstado(EstadoSolicitud.ATENDIDA);
        System.out.println("Estado tras atender ATENDIDA: " + s.getEstado());
        System.out.println("CSV: " + s.csv());
        System.out.println();
    }
}