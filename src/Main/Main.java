/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Estructura.*;
//import Algoritmos.*;
import java.util.Scanner;

/**
 *
 * @author Sebas
 */
public class Main {

    public static Arbol[] crearArboles(int[] tamannio) {
        MetodosArboles metArbol = MetodosArboles.getInstance();
        Arbol[] arboles = new Arbol[6];
        for (int i = 0; i < tamannio.length; i++) {
            metArbol.llenarArbol(tamannio[i]);
            Arbol arbol = metArbol.raiz;
            arboles[i] = arbol;
            metArbol.raiz = null;
        }
        return arboles;
    }

    public static vertice[] crearGrafos(int[] tamannio) {
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();
        vertice[] grafos = new vertice[6];
        for (int i = 0; i < tamannio.length; i++) {
            metGrafo.llenarGrafo(tamannio[i]);
            vertice grafo = metGrafo.grafo;
            grafos[i] = grafo;
            metGrafo.grafo = null;
        }
        return grafos;
    }

    public static void menuAlgoritmos() {
        MetodosArboles metArbol = MetodosArboles.getInstance();
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();

        int[] tamannio = {1000, 5000, 10000, 100000, 200000, 500000}; // array con los tamaños para los árboles y grafos

        Arbol[] arboles = crearArboles(tamannio);
        vertice[] grafos = crearGrafos(tamannio);
        
        // aquí sigue el menú de escoger el algoritmo
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MetodosArboles metArbol = MetodosArboles.getInstance();
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();

        menuAlgoritmos();
    }
}
