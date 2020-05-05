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

        int[] tamannio = {1000, 5000, 10000, 100000, 200000, 500000}; // array con los tamaños para los árboles y grafos

        metArbol.llenarArbol(tamannio[0]);
        Arbol raiz1 = metArbol.raiz;
        ////   metArbol.llenarArbol(tamannio[1]);
        Arbol raiz2 = metArbol.raiz;
         metArbol.llenarArbol(tamannio[2]);
        Arbol raiz3 = metArbol.raiz;
        // metArbol.llenarArbol(tamannio[3]); // java.lang.StackOverflowError
        Arbol raiz4 = metArbol.raiz;
        //metArbol.llenarArbol(tamannio[4]);
        Arbol raiz5 = metArbol.raiz;
        // metArbol.llenarArbol(tamannio[5]);
        Arbol raiz6 = metArbol.raiz;

       //metGrafo.llenarGrafo(tamannio[0]);
        vertice grafo1 = metGrafo.grafo;

        //System.out.println(grafo1.marca);
        metGrafo.grafo = null;
        //metGrafo.llenarGrafo(tamannio[1]); //OutOfMemoryError
        vertice grafo2 = metGrafo.grafo;
       // metGrafo.grafo = null;
        metGrafo.llenarGrafo(tamannio[2]);
        vertice grafo3 = metGrafo.grafo;
        //metGrafo.grafo = null;
        //metGrafo.llenarGrafo(tamannio[3]);
        vertice grafo4 = metGrafo.grafo;
       // metGrafo.grafo = null;
        //metGrafo.llenarGrafo(tamannio[4]);
        vertice grafo5 = metGrafo.grafo;
      //  metGrafo.grafo = null;
     //  metGrafo.llenarGrafo(tamannio[5]);
       vertice grafo6 = metGrafo.grafo;
         metGrafo.quitarMarca(grafo3 );
     //   metGrafo.grafo = null;

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
                System.out.println("Ingrese cuál árbol desea ver en profundidad: "
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
                System.out.println("Ingrese cuál árbol desea ver en amplitud: "
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
            String grafoPro;
            do {
                System.out.println("Ingrese cuál grafo desea ver en profundidad: "
                        + "\n 1-Grafo con tamaño 1000"
                        + "\n 2-Grafo con tamaño 5000"
                        + "\n 3-Grafo con tamaño 10000"
                        + "\n 4-Grafo con tamaño 100000"
                        + "\n 5-Grafo con tamaño 200000"
                        + "\n 6-Grafo con tamaño 500000"
                        + "\n 7-Volver"
                        + "\n ====================================");

                grafoPro = scanObj.nextLine();  // Read user input

                switch (grafoPro) {
                    case "1":
                        metGrafo.datosProfundidad(grafo1);
                        break;
                    case "2":
                        metGrafo.datosProfundidad(grafo2);
                        break;
                    case "3":
                        metGrafo.datosProfundidad(grafo3);
                        break;
                    case "4":
                        metGrafo.datosProfundidad(grafo4);
                        break;
                    case "5":
                        metGrafo.datosProfundidad(grafo5);
                        break;
                    case "6":
                        metGrafo.datosProfundidad(grafo6);
                        break;
                    case "7":
                        menuAlgoritmos();
                        break;
                    default:
                        System.out.println("Ingreso un dato no valido");
                        break;
                }
            } while (!"7".equals(grafoPro));
        }
        if (opcion.equals("4")) {
            String grafoAmp;
            do {
                System.out.println("Ingrese cuál grafo desea ver en amplitud: "
                        + "\n 1-Grafo con tamaño 1000"
                        + "\n 2-Grafo con tamaño 5000"
                        + "\n 3-Grafo con tamaño 10000"
                        + "\n 4-Grafo con tamaño 100000"
                        + "\n 5-Grafo con tamaño 200000"
                        + "\n 6-Grafo con tamaño 500000"
                        + "\n 7-Volver"
                        + "\n ====================================");

                grafoAmp = scanObj.nextLine();  // Read user input

                switch (grafoAmp) {
                    case "1":
                        metGrafo.datosAmplitud(grafo1);
                        break;
                    case "2":
                        metGrafo.datosAmplitud(grafo2);
                        break;
                    case "3":
                        metGrafo.datosAmplitud(grafo3);
                        break;
                    case "4":
                        metGrafo.datosAmplitud(grafo4);
                        break;
                    case "5":
                        metGrafo.datosAmplitud(grafo5);
                        break;
                    case "6":
                        metGrafo.datosAmplitud(grafo6);
                        break;
                    case "7":
                        menuAlgoritmos();
                        break;
                    default:
                        System.out.println("Ingreso un dato no valido");
                        break;
                }
            } while (!"7".equals(grafoAmp));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

         menuAlgoritmos();
    }
}
