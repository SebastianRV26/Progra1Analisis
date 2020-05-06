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
        int[] tamannioArbol = {1000, 5000, 10000, 20000, 40000, 50000}; // array con los tamaños para los árboles  
        int[] tamannioGrafo = {100, 500, 1000, 2000, 4000, 5000}; // array con los tamaños para los grafos
        
        Arbol[] arboles = crearArboles(tamannioArbol);
        vertice[] grafos = crearGrafos(tamannioGrafo);

        //////////////////////////////////////////
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();

        System.out.println("Digite un numero del 1 al 4 para ver los resultados de los algoritmos "
                + "\n 1-Algoritmo de recorrido en profundidad Arbol binario "
                + "\n 2-Algoritmo de recorrido en anchura Arbol binario "
                + "\n 3-Algoritmo de recorrido en profundidad Grafo"
                + "\n 4-Algoritmo de recorrido en anchura Grafo"
                + "\n ====================================");

        Scanner scanObj = new Scanner(System.in);  // Create a Scanner object
        String opcion = scanObj.nextLine();  // Read user input

        if (opcion.equals("1")) {

            System.out.println("Cantidad de asignaciones, comparaciones, "
                    + "lineas ejecutadas y tiempo de ejecucion del algoritmo con recorrido de profundidad"
                    + "1000, 5000, 10000,20000,40000, 50000");
            for (int i = 0; i < tamannioArbol.length; i++) {
                System.out.println(i + 1 + "-Arbol con tamaño " + tamannioArbol[i]);
                metArbol.datosProfundidad(arboles[i]);
            }
        }
        if (opcion.equals("2")) {
            System.out.println("Cantidad de asignaciones, comparaciones, "
                    + "lineas ejecutadas y tiempo de ejecucion del algoritmo con recorrido de amplitud");

            for (int i = 0; i < tamannioArbol.length; i++) {
                System.out.println(i + 1 + "-Arbol con tamaño " + tamannioArbol[i]);
                metArbol.datosAmplitud(arboles[i]);
            }
        }
        if (opcion.equals("3")) {
            System.out.println("Cantidad de asignaciones, comparaciones, "
                    + "lineas ejecutadas y tiempo de ejecucion del algoritmo con recorrido de amplitud");

            for (int i = 0; i < tamannioGrafo.length; i++) {
                System.out.println(i + 1 + "-Grafo con tamaño " + tamannioGrafo[i]);
                metGrafo.datosProfundidad(grafos[i]);
            }

        }
        if (opcion.equals("4")) {
            System.out.println("Cantidad de asignaciones, comparaciones, "
                    + "lineas ejecutadas y tiempo de ejecucion del algoritmo con recorrido de amplitud");

            for (int i = 0; i < tamannioGrafo.length; i++) {
                System.out.println(i + 1 + "-Grafo con tamaño " + tamannioGrafo[i]);
                metGrafo.datosAmplitud(grafos[i]);
            }

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
        MetodosArboles metArbol = MetodosArboles.getInstance();
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();
        
        metArbol.llenarArbol(1000);
        Arbol raiz1 = metArbol.raiz;
        metArbol.imprimirPreOrden(raiz1);
        System.out.println("1-Arbol con tamaño 1000");
        metArbol.datosProfundidad(raiz1);
        
        System.out.println("1-Grafo con tamaño ");
        metGrafo.llenarGrafo(5000);
        vertice grafo1 = metGrafo.grafo;
        metGrafo.datosProfundidad(grafo1);
        metGrafo.datosAmplitud(grafo1);
         */
        menuAlgoritmos();
    }
}

