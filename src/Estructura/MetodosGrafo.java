/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.Random;

/**
 *
 * Fecha inicio: 29/04/2020 
 * Ultima modificación:14/05/2020
 */
public class MetodosGrafo {

    public static MetodosGrafo instance = null; // instancia de la clase MetodosGrafo

    /**
     * Fecha inicio: 29/04/2020 
     * Ultima modificación: 29/04/2020
     * 
     * Singleton para que exista únicamente una instacia de la clase
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
     * Fecha inicio: 29/04/2020 
     * Ultima modificación: 29/04/2020
     * 
     * Método que inserta un vértice para el grafo
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
     * Fecha inicio: 29/04/2020 
     * Ultima modificación: 29/04/2020
     * 
     * Método que busca un vértice del grafo
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
     * Fecha inicio: 29/04/2020 
     * Ultima modificación: 29/04/2020
     * Método que inserta un arco para el grafo
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
     *  Fecha inicio: 29/04/2020 
     * Ultima modificación: 29/04/2020
     * 
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
     *  Fecha inicio:  06/05/2020
     * Ultima modificación:09/05/2020
     * 
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
     * Fecha inicio: 29/04/2020 
     * Ultima modificación: 14/05/2020
     * 
     * metodo que imprime el inicio en profundidad
     *
     * @param grafo es el primer vértice del grafo
     */
    public void profundidad(vertice grafo) {
        if ((grafo != null) && (grafo.marca == false)) {//2 * n = 2n
            grafo.marca = true;//n
            arco aux = grafo.sigA;//n
            lineas += 3;
            comparaciones += 2;
            asignaciones += 2;
            while (aux != null) {//n*n = n a la 2
                // System.out.println("Origen: " + grafo.ID);
                // System.out.println("Peso: " + aux.peso);
                // System.out.println("Destino: " + aux.destino.ID);
                // System.out.println("-----------");
                profundidad(aux.destino);//n*n = n a la 2
                aux = aux.sigA;//n*n = n a la 2
                lineas += 3;
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
        //Total medicion analitica 3n a la 2 + 4n 
    }

    /**
     * Fecha inicio: 29/04/2020 
     * Ultima modificación: 14/05/2020
     * 
     * metodo para imprimir el inicio en amplitud
     *
     * @param grafo es el primer vértice del grafo
     */
    public void amplitud(vertice grafo) {
        if (grafo == null) {//1
            comparaciones++;
            lineas++;
            //System.out.println("No hay grafo");=
        } else {
            vertice temp = grafo;//1
            asignaciones++;
            comparaciones++;
            lineas+=2;
            while (temp != null) {//n
                // System.out.println("Vertice: " + temp.ID);
                arco aux = temp.sigA;//n == n
                lineas += 2;
                comparaciones++;
                asignaciones++;
                while (aux != null) {//n*n = n a la 2
                    // System.out.println("Destino: " + aux.destino.ID);
                    aux = aux.sigA;//n*n = n ala 2
                    lineas += 2;
                    comparaciones++;
                    asignaciones++;
                }
                // System.out.println("-----------");
                temp = temp.sigV; //n
                lineas += 2;
                comparaciones++;
                asignaciones++;
            }
            lineas++;
            comparaciones++;
        }
          //Total medicion analitica 2n + 3n + 2
    }


    /**
     *  Fecha inicio: 29/04/2020 
     * Ultima modificación: 29/04/2020
     * 
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
     * Fecha inicio: 09/05/2020
     * Ultima modificación:09/05/2020
     * 
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
        double totalTime = ends - starts;
        System.out.println("Asignaciones: " + asignaciones);
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Lineas: " + lineas);
        System.out.println("Tiempo de ejecucion: " + totalTime + " ms");
        System.out.println("====================================");
    }
}
