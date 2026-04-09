/*package co.edu.unbosque.testers;

import co.edu.unbosque.modelo.estructuras.*;

public class TestEstructuras {

  public static void main(String[] args) {
        testLista();
        testPila();
        testCola();
        testColaPrioridad();
   }

    // ─── LISTA ───────────────────────────────────────────
    static void testLista() {
        System.out.println("=== TEST LISTA ENLAZADA ===");
        ListaEnlazada lista = new ListaEnlazada();

        lista.insertar("Cliente:C001:Juan");
        lista.insertar("Cliente:C002:Maria");
        lista.insertar("Cliente:C003:Pedro");

        System.out.println("Tamaño esperado 3: " + lista.getTamaño());
        System.out.println("Buscar C002 esperado Maria: " + lista.buscar("C002"));

        lista.eliminar("C002");
        System.out.println("Tamaño tras eliminar C002, esperado 2: " + lista.getTamaño());
        System.out.println("Buscar C002 tras eliminar, esperado null: " + lista.buscar("C002"));

        Object[] todos = lista.obtenerTodos();
        System.out.println("Todos los elementos:");
        for (Object o : todos) System.out.println("  " + o);
        System.out.println();
    }

    // ─── PILA ────────────────────────────────────────────
    static void testPila() {
        System.out.println("=== TEST PILA ===");
        Pila pila = new Pila();

        pila.apilar("Kit1");
        pila.apilar("Kit2");
        pila.apilar("Kit3");

        System.out.println("Tamaño esperado 3: " + pila.getTamaño());
        System.out.println("Desapilar esperado Kit3: " + pila.desapilar());
        System.out.println("Desapilar esperado Kit2: " + pila.desapilar());
        System.out.println("Tamaño esperado 1: " + pila.getTamaño());
        System.out.println("Desapilar esperado Kit1: " + pila.desapilar());
        System.out.println("Pila vacía esperado true: " + pila.estaVacia());
        System.out.println("Desapilar vacía esperado null: " + pila.desapilar());
        System.out.println();
    }

    // ─── COLA ────────────────────────────────────────────
    static void testCola() {
        System.out.println("=== TEST COLA ===");
        Cola cola = new Cola();

        cola.encolar("Solicitud1");
        cola.encolar("Solicitud2");
        cola.encolar("Solicitud3");

        System.out.println("Tamaño esperado 3: " + cola.getTamaño());
        System.out.println("Desencolar esperado Solicitud1: " + cola.desencolar());
        System.out.println("Desencolar esperado Solicitud2: " + cola.desencolar());
        System.out.println("Tamaño esperado 1: " + cola.getTamaño());
        System.out.println("Desencolar esperado Solicitud3: " + cola.desencolar());
        System.out.println("Cola vacía esperado true: " + cola.estaVacia());
        System.out.println("Desencolar vacía esperado null: " + cola.desencolar());
        System.out.println();
    }

    // ─── COLA PRIORIDAD ──────────────────────────────────
    static void testColaPrioridad() {
        System.out.println("=== TEST COLA PRIORIDAD ===");
        ColaPrioridad cp = new ColaPrioridad();

        cp.encolar("Sol.A - normal",   1);
        cp.encolar("Sol.B - normal",   1);
        cp.encolar("Sol.C - critica",  2);
        cp.encolar("Sol.D - critica",  2);

        System.out.println("Tamaño esperado 4: " + cp.getTamaño());
        System.out.println("Desencolar esperado Sol.C (prioridad 2): " + cp.desencolar());
        System.out.println("Desencolar esperado Sol.D (prioridad 2): " + cp.desencolar());
        System.out.println("Desencolar esperado Sol.A (prioridad 1): " + cp.desencolar());
        System.out.println("Desencolar esperado Sol.B (prioridad 1): " + cp.desencolar());
        System.out.println("Cola vacía esperado true: " + cp.estaVacia());
        System.out.println();
    }
}*/