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

    public static void menuAlgoritmos() {
        MetodosArboles metArbol = MetodosArboles.getInstance();
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();

        int[] tamannio = {1000, 5000, 10000, 100000, 200000, 500000};
        
        metArbol.llenarArbol(1000);
        Arbol raiz1 = metArbol.raiz;
        metArbol.llenarArbol(5000);
        Arbol raiz2 = metArbol.raiz;
        metArbol.llenarArbol(10000);
        Arbol raiz3 = metArbol.raiz;
        // metArbol.llenarArbol(100000); // java.lang.StackOverflowError
        Arbol raiz4 = metArbol.raiz;
        //metArbol.llenarArbol(200000);
        Arbol raiz5 = metArbol.raiz;
        // metArbol.llenarArbol(500000);
        Arbol raiz6 = metArbol.raiz;

        metGrafo.llenarGrafo(1000);
        vertice grafo1 = metGrafo.grafo;
        metGrafo.grafo = null;
        /*
        metGrafo.llenarGrafo(5000); //OutOfMemoryError
        vertice grafo2 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(10000);
        vertice grafo3 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(100000);
        vertice grafo4 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(200000);
        vertice grafo5 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(500000);
        vertice grafo6 = metGrafo.grafo;
        metGrafo.grafo = null;
        */
        System.out.println("Digite un numero del 1 al 4 para ver los resultados de los algoritmos "
                + "\n 1-Algoritmo de recorrido en profundidad Arbol binario "
                + "\n 2-Algoritmo de recorrido en anchura Arbol binario "
                + "\n 3-Algoritmo de recorrido en profundidad Grafo"
                + "\n 4-Algoritmo de recorrido en anchura grafo"
                + "\n ====================================");

        Scanner scanObj = new Scanner(System.in);  // Create a Scanner object
        String opcion = scanObj.nextLine();  // Read user input

        if (opcion.equals("1")) {

            String arbolPro;
            do {
                System.out.println("Ingrese cuál árbol desea ver: "
                        + "\n 1-Arbol con tamaño 1000"
                        + "\n 2-Arbol con tamaño 5000"
                        + "\n 3-Arbol con tamaño 10000"
                        + "\n 4-Arbol con tamaño 100000"
                        + "\n 5-Arbol con tamaño 200000"
                        + "\n 6-Arbol con tamaño 500000"
                        + "\n 7-Volver"
                        + "\n ====================================");

                arbolPro = scanObj.nextLine();  // Read user input

                switch (arbolPro) {
                    case "1":
                        metArbol.datosProfundidad(raiz1);
                        break;
                    case "2":
                        metArbol.datosProfundidad(raiz2);
                        break;
                    case "3":
                        metArbol.datosProfundidad(raiz3);
                        break;
                    case "4":
                        metArbol.datosProfundidad(raiz4);
                        break;
                    case "5":
                        metArbol.datosProfundidad(raiz5);
                        break;
                    case "6":
                        metArbol.datosProfundidad(raiz6);
                        break;
                    case "7":
                        menuAlgoritmos();
                        break;
                    default:
                        System.out.println("Ingreso un dato no valido");
                        break;
                }
            } while (!"7".equals(arbolPro));
        }
        if (opcion.equals("2")) {
            String arbolAmp;
            do {
                System.out.println("Ingrese cuál árbol desea ver: "
                        + "\n 1-Arbol con tamaño 1000"
                        + "\n 2-Arbol con tamaño 5000"
                        + "\n 3-Arbol con tamaño 10000"
                        + "\n 4-Arbol con tamaño 100000"
                        + "\n 5-Arbol con tamaño 200000"
                        + "\n 6-Arbol con tamaño 500000"
                        + "\n 7-Volver"
                        + "\n ====================================");

                arbolAmp = scanObj.nextLine();  // Read user input

                switch (arbolAmp) {
                    case "1":
                        metArbol.datosAmplitud(raiz1);
                        break;
                    case "2":
                        metArbol.datosAmplitud(raiz2);
                        break;
                    case "3":
                        metArbol.datosAmplitud(raiz3);
                        break;
                    case "4":
                        metArbol.datosAmplitud(raiz4);
                        break;
                    case "5":
                        metArbol.datosAmplitud(raiz5);
                        break;
                    case "6":
                        metArbol.datosAmplitud(raiz6);
                        break;
                    case "7":
                        menuAlgoritmos();
                        break;
                    default:
                        System.out.println("Ingreso un dato no valido");
                        break;
                }
            } while (!"7".equals(arbolAmp));

        }
        if (opcion.equals("3")) {
            System.out.println("Algoritmo de recorrido en profundidad para grafo"
                    + "Cantidad de asignaciones y comparaciones para los diferentes tamaños");

            //Instant starts = Instant.now();
            //Algoritmo.recorridoProfundidad();
            //Instant ends = Instant.now();
            //System.out.println("Tamaño del arbol: "+ size);
            //System.out.println("Asignaciones: "+asignaciones);
            //System.out.println("Comparaciones: "+comparaciones);
            //System.out.println("Tiempo de ejecucion: "+Duration.between(starts, ends));
        }
        if (opcion.equals("4")) {
            System.out.println("Algoritmo de recorrido en anchura para grafo"
                    + "Cantidad de asignaciones y comparaciones para los diferentes tamaños");

            //Instant starts = Instant.now();
            //Algoritmo.recorridoProfundidad();
            //Instant ends = Instant.now();
            //System.out.println("Tamaño del arbol: "+ size);
            //System.out.println("Asignaciones: "+asignaciones);
            //System.out.println("Comparaciones: "+comparaciones);
            //System.out.println("Tiempo de ejecucion: "+Duration.between(starts, ends));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MetodosArboles metArbol = MetodosArboles.getInstance();
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();

        /*
        metGrafo.llenarGrafo(1000);
        vertice grafo1 = metGrafo.grafo;
        metGrafo.grafo = null;
        System.out.println("Grafo 1 creado");
        
        metGrafo.datosProfundidad(grafo1);
        metGrafo.datosAmplitud(grafo1);
        */
        
        metGrafo.llenarGrafo(5000);
        
        //menuAlgoritmos(); 
    }
}
