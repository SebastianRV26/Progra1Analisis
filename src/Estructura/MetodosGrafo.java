/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.Random;

/**
 *
 * @author Sebas
 */
public class MetodosGrafo {

    public static MetodosGrafo instance = null; // instancia de la clase MetodosGrafo

    /**
     * singleton para que exista únicamente una instacia de la clase
     * MetodosGrafo
     *
     * @return la instancia única del objeto MetodosGrafo
     */
    public static MetodosGrafo getInstance() {
        if (instance == null) {
            instance = new MetodosGrafo();
        }
        return instance;
    }

    public vertice grafo;
    public int asignaciones = 0;
    public int comparaciones = 0;
    public int lineas = 0;

    /**
     * método que inserta un vértice para el grafo
     *
     * @param ID el identificador del vértice que deseamos crear
     * @return "Insertado" o ""
     */
    public String insertarVertices(int ID) {
        vertice nuevo = new vertice(ID, false);
        if (grafo == null) {
            grafo = nuevo;
            return "Insertado";
        }
        nuevo.sigV = grafo; //insersion al inicio de una lista
        grafo = nuevo;
        return "";
    }

    /**
     * método que busca un vértice del grafo
     *
     * @param id el id del vertice que deseamos buscar
     * @return vértice encontrado o null
     */
    public vertice buscar(int id) {
        vertice aux = grafo;
        while (aux != null) {
            if (aux.ID == id) {
                return aux;
            }
            aux = aux.sigV;
        }
        return null;
    }

    /**
     * método que inserta un arco para el grafo
     *
     * @param origen vértice de origen de arco al que queremos insertar
     * @param destino vértice destino de arco al que queremos insertar
     * @param peso el peso del arco, número entre el 1 al 10
     * @return "Insertado" o "No se pueden repetir arcos"
     */
    public String insertarArco(vertice origen, vertice destino, int peso) {
        if (buscar(origen, destino) == null) {
            arco nuevo = new arco(peso);
            nuevo.destino = destino;
            if (origen.sigA == null) {
                origen.sigA = nuevo;
            } else {
                nuevo.sigA = origen.sigA;
                origen.sigA.antA = nuevo;
                origen.sigA = nuevo;
            }
            return "Insertado";
        }
        return "No se pueden repetir arcos";
    }

    /**
     * método que busca un arco del grafo
     *
     * @param origen vértice de origen de arco al que queremos buscar
     * @param destino vértice destino de arco al que queremos buscar
     * @return el arco deseado o null
     */
    public arco buscar(vertice origen, vertice destino) {
        if (origen.sigA != null) {
            arco aux = origen.sigA;
            while (aux != null) {
                if (aux.destino == destino) {
                    return aux;
                }
                aux = aux.sigA;
            }
        }
        return null;
    }

    /**
     * metodo que imprime el inicio en profundidad
     *
     * @param grafo es el primer vértice del grafo
     */
    public void profundidad(vertice grafo) {
        if ((grafo != null) && (grafo.marca == false)) {
            grafo.marca = true;
            arco aux = grafo.sigA;
            lineas += 3;
            comparaciones += 2;
            asignaciones += 2;
            while (aux != null) {
                // System.out.println("Origen: " + grafo.ID);
                // System.out.println("Peso: " + aux.peso);
                // System.out.println("Destino: " + aux.destino.ID);
                // System.out.println("-----------");
                profundidad(aux.destino);
                aux = aux.sigA;
                lineas += 2;
                comparaciones++;
                asignaciones += 2;
            }
            lineas++;
            comparaciones++;
        } else {
            lineas++;
            comparaciones++;
            return;
        }
    }

    /**
     * metodo para imprimir el inicio en amplitud
     *
     * @param grafo es el primer vértice del grafo
     */
    public void amplitud(vertice grafo) {
        if (grafo == null) {
            comparaciones++;
            lineas++;
            //System.out.println("No hay grafo");
        } else {
            vertice temp = grafo;
            asignaciones++;
            lineas++;
            while (temp != null) {
                // System.out.println("Vertice: " + temp.ID);
                arco aux = temp.sigA;
                lineas += 2;
                comparaciones++;
                asignaciones++;
                while (aux != null) {
                    // System.out.println("Destino: " + aux.destino.ID);
                    aux = aux.sigA;
                    lineas += 2;
                    comparaciones++;
                    asignaciones++;
                }
                // System.out.println("-----------");
                temp = temp.sigV;
                lineas += 2;
                comparaciones++;
                asignaciones++;
            }
            lineas++;
            comparaciones++;
        }
    }

    /**
     * método que llena el grafo fuertemente conexo
     *
     * @param n es la cantidad de nodos que requiere el grafo
     */
    public void llenarGrafo(int n) {
        vertice origen, destino;
        for (int i = 0; i <= n; i++) { // primero se insertan los vertices
            insertarVertices(i);
        }
        for (int i = 0; i <= n; i++) { // luego se insertan los arcos
            origen = buscar(i);
            for (int j = 0; j < n; j++) { // para que el grafo sea fuertemente conexo 
                Random random = new Random();
                destino = buscar(j);
                if (destino.ID != origen.ID) {
                    insertarArco(origen, destino, random.nextInt(11) + 1);
                }
            }
        }
        quitarMarca(grafo);
    }

    /**
     * método que establece la marca de todos los nodos del grafo como false
     *
     * @param grafo es el primer vértice del grafo
     */
    public void quitarMarca(vertice grafo) {
        vertice aux = grafo;
        while (aux != null) {
            aux.marca = false;
            aux = aux.sigV;
        }
    }

    /**
     * método que llama a la profundidad para grafo y muestra sus asignaciones,
     * comparaciones, lineas de código ejecutadas y su duración
     *
     * @param grafo es el primer vértice del grafo
     */
    public void datosProfundidad(vertice grafo) {
        asignaciones = 0;
        comparaciones = 0;
        lineas = 0;
        long starts, ends;
        starts = System.currentTimeMillis(); // empieza el conteo del tiempo en que durará el algoritmo de profundidad
        profundidad(grafo);
        ends = System.currentTimeMillis(); // termina el conteo del tiempo en que durará el algoritmo de profundidad
        long totalTime = ends - starts;
        System.out.println("Asignaciones: " + asignaciones);
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Lineas: " + lineas);
        System.out.println("Tiempo de ejecucion: " + totalTime + " ms");
        System.out.println("====================================");
    }

    /**
     * método que llama a la amplitud para grafo y muestra sus asignaciones,
     * comparaciones, lineas de código ejecutadas y su duración
     *
     * @param grafo es el primer vértice del grafo
     */
    public void datosAmplitud(vertice grafo) {
        asignaciones = 0;
        comparaciones = 0;
        lineas = 0;
        long starts, ends;
        starts = System.currentTimeMillis(); // empieza el conteo del tiempo en que durará el algoritmo de amplitud
        amplitud(grafo);
        ends = System.currentTimeMillis(); // termina el conteo del tiempo en que durará el algoritmo de amplitud
        long totalTime = ends - starts;
        System.out.println("Asignaciones: " + asignaciones);
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Lineas: " + lineas);
        System.out.println("Tiempo de ejecucion: " + totalTime + " ms");
        System.out.println("====================================");
    }
}
