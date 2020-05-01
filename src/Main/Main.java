/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Estructura.*;
//import Algoritmos.*;
import java.time.Duration;
import java.time.Instant;
import Estructura.Arbol;
import Estructura.MetodosArboles;
import Estructura.MetodosGrafo;
import java.util.Scanner;

/**
 *
 * @author Sebas
 */
public class Main {

    public static void menuAlgoritmos() {
        System.out.println("Digite un numero del 1 al 4 para ver los resultados de los algoritmos "
                + "\n 1-Algoritmo de recorrido en profundidad Arbol binario "
                + "\n 2-Algoritmo de recorrido en anchura Arbol binario "
                + "\n 3-Algoritmo de recorrido en profundidad Grafo"
                + "\n 4-Algoritmo de recorrido en anchura grafo");

        Scanner scanObj = new Scanner(System.in);  // Create a Scanner object
        String opcion = scanObj.nextLine();  // Read user input
        
        if (opcion.equals("1")) {

            //asignaciones = 0;
            //comparaciones = 0;
            //lineas = 0;
            System.out.println("Algoritmo de recorrido en profundidad para Arbol binario"
                    + "Cantidad de asignaciones y comparaciones para los diferentes tamaños");

            //Instant starts = Instant.now();
            //Algoritmo.recorridoProfundidad();
            //Instant ends = Instant.now();
            //System.out.println("Tamaño del arbol: "+ size);
            //System.out.println("Asignaciones: "+asignaciones);
            //System.out.println("Comparaciones: "+comparaciones);
            //System.out.println("Tiempo de ejecucion: "+Duration.between(starts, ends));
        }
        if (opcion.equals("2")) {
            //asignaciones = 0;
            //comparaciones = 0;
            //lineas = 0;
            System.out.println("Algoritmo de recorrido en Anchura para Arbol binario"
                    + "Cantidad de asignaciones y comparaciones para los diferentes tamaños");

            //Instant starts = Instant.now();
            //Algoritmo.recorridoProfundidad();
            //Instant ends = Instant.now();
            //System.out.println("Tamaño del arbol: "+ size);
            //System.out.println("Asignaciones: "+asignaciones);
            //System.out.println("Comparaciones: "+comparaciones);
            //System.out.println("Tiempo de ejecucion: "+Duration.between(starts, ends));
        }
        if (opcion.equals("3")) {
            //asignaciones = 0;
            //comparaciones = 0;
            //lineas = 0;
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
            //asignaciones = 0;
            //comparaciones = 0;
            //lineas = 0;
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

        menuAlgoritmos();
        //metArbol.imprimirOrden(metArbol.raiz);

        // metArbol.llenarArbol(100);
        // metArbol.imprimirOrden(metArbol.raiz);
    }

    private static void Switch(String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
