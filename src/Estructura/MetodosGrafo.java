/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.time.Duration;
import java.time.Instant;
import javax.swing.DefaultListModel;

/**
 *
 * @author Sebas
 */
public class MetodosGrafo {

    public static MetodosGrafo instance = null; // instancia de la clase MetodosGrafo

    public static MetodosGrafo getInstance() { // singleton para que exista únicamente una instacia de la clase
        if (instance == null) {
            instance = new MetodosGrafo();
        }
        return instance;
    }

    DefaultListModel<String> listModel = new DefaultListModel<>(); // ELIMINA

    public vertice grafo;
    public int asignaciones = 0;
    public int comparaciones = 0;
    public int lineas = 0;

    public String insertarVertices(int ID) { // método que inserta un vértice para el grafo
        vertice nuevo = new vertice(ID, false);
        if (grafo == null) {
            grafo = nuevo;
            return "Insertado";
        }
        nuevo.sigV = grafo; //insersion al inicio de una lista
        grafo = nuevo;
        return "";
    }

    public vertice buscar(int id) { // método que busca un vértice del grafo
        vertice aux = grafo;
        while (aux != null) {
            if (aux.ID == id) {
                return aux;
            }
            aux = aux.sigV;
        }
        return null;
    }

    public String insertarArco(vertice origen, vertice destino, int peso) { // método que inserta un arco para el grafo
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

    public arco buscar(vertice origen, vertice destino) { // método que busca un arco del grafo
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

    public void profundidad(vertice grafo) //metodo que imprime el inicio en profundidad
    {
        if ((grafo == null) | (grafo.marca == true)) {
            comparaciones += 2;
            return;
        } else {
            grafo.marca = true;
            arco aux = grafo.sigA;
            asignaciones += 2;
            while (aux != null) {
                comparaciones++;
                listModel.addElement("Origen: " + grafo.ID);
                listModel.addElement("Peso: " + aux.peso);
                listModel.addElement("Destino: " + aux.destino.ID);
                profundidad(aux.destino);
                aux = aux.sigA;
                asignaciones++;
            }
            comparaciones++;
        }
    }

    public void amplitud(vertice grafo) // metodo para imprimir el inicio en amplitud
    {
        if (grafo == null) {
            comparaciones++;
            System.out.println("No hay grafo");
        } else {
            vertice temp = grafo;
            while (temp != null) {
                comparaciones++;
                listModel.addElement("Vertice: " + temp.ID);
                arco aux = temp.sigA;
                asignaciones++;
                while (aux != null) {
                    listModel.addElement("Destino: " + aux.destino.ID);
                    aux = aux.sigA;
                    asignaciones++;
                }
                comparaciones++;
                listModel.addElement("-----------");
                temp = temp.sigV;
                asignaciones++;
            }
            comparaciones++;
        }
    }

    public void llenarGrafo(int n) {
        for (int i = 0; i <= n; i++) { // primero se insertan los vertices
            insertarVertices(i);
        }
        for (int i = 0; i <= n; i++) { // liego se insertan los arcos
            for (int j = 0; j < n; j++) {
                insertarArco(buscar(i), buscar(j), 1);
            }
        }
    }

    public void quitarMarca(vertice grafo) {
        vertice aux = grafo;
        while (aux != null) {
            aux.marca = false;
            aux = aux.sigV;
        }
    }

    public void datosProfundidad(vertice grafo) {
        asignaciones = 0;
        comparaciones = 0;
        lineas = 0;
        Instant starts = Instant.now();
        profundidad(grafo);
        Instant ends = Instant.now();
        quitarMarca(grafo); // por si deea volver a llamar a profundidad
        System.out.println("Asignaciones: " + asignaciones);
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Lineas: " + lineas);
        System.out.println("Tiempo de ejecucion: " + Duration.between(starts, ends));
        System.out.println("====================================");
    }

    public void datosAmplitud(vertice grafo) {
        asignaciones = 0;
        comparaciones = 0;
        lineas = 0;
        Instant starts = Instant.now();
        amplitud(grafo);
        Instant ends = Instant.now();
        System.out.println("Asignaciones: " + asignaciones);
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Lineas: " + lineas);
        System.out.println("Tiempo de ejecucion: " + Duration.between(starts, ends));
        System.out.println("====================================");
    }

    public int gradoExterno(vertice grafo) { // para saber si es fuertemente conexo, LUEGO ELIMINAR
        int cont = 0;
        if (grafo.sigA != null) {
            arco aux = grafo.sigA;
            while (aux != null) {
                cont++;
                aux = aux.sigA;
            }
        }
        return cont;
    }

    public void grafoFuertementeConexo(vertice grafo) { // Método para SABER si es un grafo fuermenete conexo luego ELIMINAR
        //se parte de que es un grafo no dirigido (no tiene flecha)
        //grafo completo, que todos sus vertices apunten a todos los vertices (excepto a él mismo xD)
        int vertices = 0;
        vertice temp = grafo;
        while (temp != null) { //se cuentan los vértices
            vertices++;
            temp = temp.sigV;
        }
        vertice aux = grafo;
        while (aux != null) {
            if (gradoExterno(aux) != vertices - 1) { //los vertices tienen que tener cantidad de vertices-1 
                System.out.println("No es un grafo FuertementeConexo");
                return;
            }
            aux = aux.sigV;
        }
        System.out.println("Es un grafo FuertementeConexo");
    }
}
