/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Metodos.MetodosArboles;
import Clases.Arbol;
import Metodos.MetodosGrafo;
import Clases.Vertice;
import java.util.Scanner;

/**
 *
 */
public class Main {

    /**
     * Fecha inicio: 09/05/2020. Fecha última modificación: 09/05/2020
     * 
     * método que crea los árboles de distintos tamaños y los almacena en un
     * arreglo
     *
     * @param tamannio tamaños requeridos para crear los árboles
     * @return un arreglo con las raices de los árboles de distintos tamaños
     */
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

    /**
     * Fecha inicio: 09/05/2020. Fecha última modificación: 09/05/2020
     * 
     * método que crea los grafos de distintos tamaños y los almacena en un
     * arreglo
     *
     * @param tamannio tamaños requeridos para crear los grafos
     * @return un arreglo con el primer vértice de los grafos de distintos
     * tamaños
     */
    public static Vertice[] crearGrafos(int[] tamannio) {
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();
        Vertice[] grafos = new Vertice[6];
        for (int i = 0; i < tamannio.length; i++) {
            metGrafo.llenarGrafo(tamannio[i]);
            Vertice grafo = metGrafo.grafo;
            grafos[i] = grafo;
            metGrafo.grafo = null;
        }
        return grafos;
    }

    /**
     * Fecha inicio: 01/05/2020. Fecha última modificación: 09/05/2020
     * 
     * método que muestra la posibilidad al usuario de escoger el algoritmo que
     * desea ver y ejecuta el algoritmo seleccionado
     */
    public static void menuAlgoritmos() {
        MetodosArboles metArbol = MetodosArboles.getInstance();
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();

        int[] tamannioArbol = {1000, 5000, 10000, 20000, 40000, 50000}; // array con los tamaños para los árboles  
        int[] tamannioGrafo = {100, 500,1000, 2000, 4000, 5000}; // array con los tamaños para los grafos

        Arbol[] arboles = crearArboles(tamannioArbol); // array con las raices de los árboles
        Vertice[] grafos = crearGrafos(tamannioGrafo); // array con los vértices de los grafos

        while (true) {
            System.out.println("Digite un numero del 1 al 4 para ver los resultados de los algoritmos "
                    + "\n 1-Algoritmo de recorrido en profundidad Arbol binario "
                    + "\n 2-Algoritmo de recorrido en anchura Arbol binario "
                    + "\n 3-Algoritmo de recorrido en profundidad Grafo"
                    + "\n 4-Algoritmo de recorrido en anchura Grafo"
                    + "\n 5-Salir"
                    + "\n ====================================");

            Scanner scanObj = new Scanner(System.in);  // Create a Scanner object
            String opcion = scanObj.nextLine();  // Read user input
            switch (opcion) {
                case "1":
                    System.out.println("Cantidad de asignaciones, comparaciones, "
                            + "lineas ejecutadas y tiempo de ejecucion del algoritmo con recorrido de profundidad"
                            + "1000, 5000, 10000,20000,40000, 50000");
                    for (int i = 0; i < tamannioArbol.length; i++) {
                        System.out.println(i + 1 + "-Arbol con tamaño " + tamannioArbol[i]);
                        metArbol.datosProfundidad(arboles[i]);
                    }
                    break;
                case "2":
                    System.out.println("Cantidad de asignaciones, comparaciones, "
                            + "lineas ejecutadas y tiempo de ejecucion del algoritmo con recorrido de amplitud");
                    for (int i = 0; i < tamannioArbol.length; i++) {
                        System.out.println(i + 1 + "-Arbol con tamaño " + tamannioArbol[i]);
                        metArbol.datosAmplitud(arboles[i]);
                    }
                    break;
                case "3":
                    System.out.println("Cantidad de asignaciones, comparaciones, "
                            + "lineas ejecutadas y tiempo de ejecucion del algoritmo con recorrido de amplitud");
                    for (int i = 0; i < tamannioGrafo.length; i++) {
                        System.out.println(i + 1 + "-Grafo con tamaño " + tamannioGrafo[i]);
                        metGrafo.datosProfundidad(grafos[i]);
                    }
                    break;
                case "4":
                    System.out.println("Cantidad de asignaciones, comparaciones, "
                            + "lineas ejecutadas y tiempo de ejecucion del algoritmo con recorrido de amplitud");
                    for (int i = 0; i < tamannioGrafo.length; i++) {
                        System.out.println(i + 1 + "-Grafo con tamaño " + tamannioGrafo[i]);
                        metGrafo.datosAmplitud(grafos[i]);
                    }
                    break;
                case "5":
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    /**
     * Fecha inicio: 29/04/2020. Ultima modificación: 09/05/2020 
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        menuAlgoritmos();
    }
}
