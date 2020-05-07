/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author edubi
 */
public class MetodosArboles {

    public static MetodosArboles instance = null; // instancia de la clase MetodosArboles

    public static MetodosArboles getInstance() { // singleton para que exista únicamente una instacia de la clase
        if (instance == null) {
            instance = new MetodosArboles();
        }
        return instance;
    }
    public Arbol raiz; // raíz del árbol
    public String resultado; // por si desea saber el estado del método insertarOrdenado
    int global = 0;

    public int asignaciones = 0;
    public int comparaciones = 0;
    public int lineas = 0;

    public String insertarOrdenado(int id, Arbol aux) { // método que inserta un nodo en el arbol de manera ordenada
        if (raiz == null) {
            Arbol nuevoArbol = new Arbol(id);
            raiz = nuevoArbol;
            return resultado = "insertado";
        } else {
            if (id == aux.id) {
                return resultado = "repetido";
            }
            if (id < aux.id) {
                if (aux.izq == null) {
                    aux.izq = new Arbol(id);
                    return resultado = "insertado";
                } else {
                    insertarOrdenado(id, aux.izq);
                }
            }
            if (id > aux.id) {
                if (aux.der == null) {
                    aux.der = new Arbol(id);
                    return resultado = "insertado";
                } else {
                    insertarOrdenado(id, aux.der);
                }
            }

            return resultado;
        }
    }

    public Arbol buscarArbol(int id, Arbol aux) { // buscar un nodo del Arbol, aux es un auxiliar de la raíz
        if (raiz == null) {
            return null;
        } else {
            if (id == aux.id) {
                return aux;
            }
            if (id < aux.id) {
                if (aux.izq == null) {
                    return null;
                } else {
                    return buscarArbol(id, aux.izq);
                }
            }
            if (aux.der == null) {
                return null;
            } else {
                return buscarArbol(id, aux.der);
            }
        }
    }

    public void imprimirOrden(Arbol aux) { // método que imprime los nodos: izquierda, raiz y derecha
        if (aux == null) { // condicion de parada para la recursividad
            comparaciones++;
            lineas += 2;
            return;
        }
        imprimirOrden(aux.izq);
        lineas++;
        asignaciones++;
        //System.out.println(aux.id);
        imprimirOrden(aux.der);
        lineas++;
        asignaciones++;
    }

    public void llenarArbol(int n) { // método que llena el arbol de forma ordenada
        raiz = null; // se iguala a null para poder crear otros árboles
        insertarOrdenado(n / 2, raiz);
        for (int i = 0; i <= n; i++) {
            insertarOrdenado(i, raiz);
        }
    }

    public void amplitud(Arbol value) {//método que imprime el árbol en amplitud
        Arbol aux;
        Cola cola, colaAux;
        lineas += 2;
        if (value != null) {
            cola = new Cola();
            colaAux = new Cola();
            cola.Insertar(value);
            lineas += 4;
            comparaciones++;
            asignaciones += 3;
            while (!cola.colaVacia()) {
                colaAux.Insertar(aux = cola.Extraer());
                lineas += 2;
                comparaciones++;
                asignaciones += 4;
                if (aux.izq != null) {
                    cola.Insertar(aux.izq);
                    lineas += 2;
                    comparaciones++;
                    asignaciones++;
                }
                if (aux.der != null) {
                    cola.Insertar(aux.der);
                    lineas += 2;
                    comparaciones++;
                    asignaciones++;
                }
                lineas += 2;
            }
            // colaAux.imprimirCola();
            lineas += 2;
            comparaciones++;
            asignaciones++;

            int totalLineasCola = cola.lineasCola + colaAux.lineasCola;
            lineas += totalLineasCola;
            int totalAsigCola = cola.asignacionesCola + colaAux.asignacionesCola;
            asignaciones += totalAsigCola;
            int totalComCola = cola.comparacionesCola + colaAux.comparacionesCola;
            comparaciones += totalComCola;
        }
    }

    public void datosProfundidad(Arbol raiz) {
        asignaciones = 0;
        comparaciones = 0;
        lineas = 0;       
        long starts, ends;
        starts = System.currentTimeMillis();
        imprimirOrden(raiz);
        ends = System.currentTimeMillis();
        long totalTime = ends - starts;
        System.out.println("Asignaciones: " + asignaciones);
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Lineas: " + lineas);
        System.out.println("Tiempo de ejecucion: " + totalTime + " ms");
        System.out.println("====================================");
    }

    public void datosAmplitud(Arbol raiz) {
        asignaciones = 0;
        comparaciones = 0;
        lineas = 0;
        long starts, ends;
        starts = System.currentTimeMillis();
        amplitud(raiz);
        ends = System.currentTimeMillis();
        long totalTime = ends - starts;
        System.out.println("Asignaciones: " + asignaciones);
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Lineas: " + lineas);
        System.out.println("Tiempo de ejecucion: " + totalTime + " ms");
        System.out.println("====================================");
    }
}
