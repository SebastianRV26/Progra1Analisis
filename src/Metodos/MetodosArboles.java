/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Clases.Arbol;

/**
 *
 * Fecha inicio: 29/04/2020 
 * Ultima modificación:14/05/2020
 */
public class MetodosArboles {

    public static MetodosArboles instance = null; // instancia de la clase MetodosArboles

    /**
     * Fecha inicio: 29/04/2020 
     * Ultima modificación: 29/04/2020 
     * Singleton para que exista únicamente una instacia de la clase
     * MetodosArboles
     *
     * @return la instancia única del objeto MetodosArboles
     */
    public static MetodosArboles getInstance() {
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

    /**
     *  Fecha inicio: 29/04/2020 
     * Ultima modificación:  29/04/2020 
     * 
     * Método que inserta un nodo en el arbol de manera ordenada
     *
     * @param id identificador del nodo del árbol
     * @param aux la raíz del árbol
     * @return "insertado" o "repetido"
     */
    public String insertarOrdenado(int id, Arbol aux) {
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

     /**
      * Fecha inicio:  06/05/2020
     *  Ultima modificación:09/05/2020
     * 
     * Método que llena el arbol de forma ordenada
     *
     * @param n es la cantidad de nodos que requiere el árbol
     */
    public void llenarArbol(int n) {
        raiz = null; // se iguala a null para poder crear otros árboles
        insertarOrdenado(n / 2, raiz);
        for (int i = 0; i <= n; i++) {
            insertarOrdenado(i, raiz);
        }
    }


    /**
     *  Fecha inicio: 29/04/2020 
     * Ultima modificación: 14/05/2020
     * 
     * Método que imprime los nodos del arbol en en siguiente orden: 
     * izquierda, raiz y derecha
     *
     * @param aux auxiliar de la raíz del árbol
     */
    public void imprimirOrden(Arbol aux) {
        if (aux == null) { // condicion de parada para la recursividad   n^n
            comparaciones++;
            lineas += 2;
            return;
        }
        imprimirOrden(aux.izq);//n
        lineas++;
        asignaciones++;
        //System.out.println(aux.id);
        imprimirOrden(aux.der);//n
        lineas++;
        asignaciones++;
        
          //Total medicion analitica 3 n^n + 4n 
    }


    /**
     *  Fecha inicio: 01/05/2020
     *  Ultima modificación:14/05/2020
     * 
     * método que imprime el árbol en amplitud
     *
     * @param value auxiliar de la raíz del árbol
     */
    public void amplitud(Arbol value) {
        Arbol aux;
        Cola cola, colaAux;
        lineas += 2;
        if (value != null) {//1
            cola = new Cola();//1
            colaAux = new Cola();//1
            cola.Insertar(value);//12
            lineas += 4;//16
            comparaciones++;
            asignaciones += 3;
            while (!cola.colaVacia()) {//4n
                colaAux.Insertar(aux = cola.Extraer());//(12+11)n = 23n
                lineas += 2;
                comparaciones++;
                asignaciones += 4;
                if (aux.izq != null) {//1*n
                    cola.Insertar(aux.izq);//12*n
                    lineas += 2;
                    comparaciones++;
                    asignaciones++;
                }
                if (aux.der != null) {//n
                    cola.Insertar(aux.der);//12*n
                    lineas += 2;
                    comparaciones++;
                    asignaciones++;
                }
                lineas += 2;
            }
            // colaAux.imprimirCola(); //5n + 3
            
            //  //Total medicion analitica  53n + 15 (Falta sumarle el imprimir cola)
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

    /**
     * Fecha inicio: 09/05/2020
     * Ultima modificación:09/05/2020
     * 
     * Método que llama a la profundidad del árbol y muestra sus asignaciones,
     * comparaciones, lineas de código ejecutadas y su duración
     *
     * @param raiz auxiliar de la raíz del árbol
     */
    public void datosProfundidad(Arbol raiz) {
        asignaciones = 0;
        comparaciones = 0;
        lineas = 0;
        long starts, ends;
        starts = System.currentTimeMillis(); // empieza el conteo del tiempo en que durará el algoritmo de profundidad
        imprimirOrden(raiz);
        ends = System.currentTimeMillis(); // termina el conteo del tiempo en que durará el algoritmo de profundidad
        double totalTime = ends - starts;
        System.out.println("Asignaciones: " + asignaciones);
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Lineas: " + lineas);
        System.out.println("Tiempo de ejecucion: " + totalTime + " ms");
        System.out.println("====================================");
    }

    /**
     * Fecha inicio: 09/05/2020
     * Ultima modificación:09/05/2020
     * 
     * Método que llama a la amplitud del árbol y muestra sus asignaciones,
     * comparaciones, lineas de código ejecutadas y su duración
     *
     * @param raiz auxiliar de la raíz del árbol
     */
    public void datosAmplitud(Arbol raiz) {
        asignaciones = 0;
        comparaciones = 0;
        lineas = 0;
        long starts, ends;
        starts = System.currentTimeMillis(); // empieza el conteo del tiempo en que durará el algoritmo de amplitud
        amplitud(raiz);
        ends = System.currentTimeMillis(); // empieza el conteo del tiempo en que durará el algoritmo de amplitud
        double totalTime =  ends - starts;
        System.out.println("Asignaciones: " + asignaciones);
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Lineas: " + lineas);
        System.out.println("Tiempo de ejecucion: " + totalTime + " ms");
        System.out.println("====================================");
    }
}
