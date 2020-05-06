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
    
    public static void crearArboles(){
        MetodosArboles metArbol = MetodosArboles.getInstance(); 
        int[] tamannio = {1000, 5000, 10000,20000,40000, 50000}; // array con los tamaños para los árboles y grafos, 
        metArbol.llenarArbol(tamannio[0]);
        Arbol raiz1 = metArbol.raiz;
        metArbol.llenarArbol(tamannio[1]);
        Arbol raiz2 = metArbol.raiz;
        metArbol.llenarArbol(tamannio[2]);
        Arbol raiz3 = metArbol.raiz;
        metArbol.llenarArbol(tamannio[3]); 
        Arbol raiz4 = metArbol.raiz;
        metArbol.llenarArbol(tamannio[4]);
        Arbol raiz5 = metArbol.raiz;
        metArbol.llenarArbol(tamannio[5]);
        Arbol raiz6 = metArbol.raiz;
       
    }
    public static void crearGrafo(){
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();
        int[] tamannio = {1000, 5000, 10000,20000,40000, 50000}; // array con los tamaños para los árboles y grafos,
        metGrafo.llenarGrafo(tamannio[0]);
        vertice grafo1 = metGrafo.grafo;
        System.out.println(grafo1.marca);
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(tamannio[1]); //OutOfMemoryError
        vertice grafo2 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(tamannio[2]);
        vertice grafo3 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(tamannio[3]);
        vertice grafo4 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(tamannio[4]);
        vertice grafo5 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(tamannio[5]);
        vertice grafo6 = metGrafo.grafo;
        metGrafo.quitarMarca(grafo3);
        metGrafo.grafo = null; 
    }
    

    public static void menuAlgoritmos() {
        MetodosArboles metArbol = MetodosArboles.getInstance(); 
        int[] tamannio = {1000, 5000, 10000,20000,40000, 50000}; // array con los tamaños para los árboles y grafos, 
        metArbol.llenarArbol(tamannio[0]);
        Arbol raiz1 = metArbol.raiz;
        metArbol.llenarArbol(tamannio[1]);
        Arbol raiz2 = metArbol.raiz;
        
        metArbol.llenarArbol(tamannio[2]);
        Arbol raiz3 = metArbol.raiz;
        metArbol.llenarArbol(tamannio[3]); 
        Arbol raiz4 = metArbol.raiz;
        metArbol.llenarArbol(tamannio[4]);
        Arbol raiz5 = metArbol.raiz;
        metArbol.llenarArbol(tamannio[5]);
        Arbol raiz6 = metArbol.raiz;
        
        //////////////////////////////////////////
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();
        
        
        metGrafo.llenarGrafo(tamannio[0]);
        vertice grafo1 = metGrafo.grafo;
        System.out.println(grafo1.marca);
        metGrafo.grafo = null;
        
        metGrafo.llenarGrafo(tamannio[1]); //OutOfMemoryError
        vertice grafo2 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(tamannio[2]);
        vertice grafo3 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(tamannio[3]);
        vertice grafo4 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(tamannio[4]);
        vertice grafo5 = metGrafo.grafo;
        metGrafo.grafo = null;
        metGrafo.llenarGrafo(tamannio[5]);
        vertice grafo6 = metGrafo.grafo;
        metGrafo.quitarMarca(grafo3);
        metGrafo.grafo = null;
        
        
        
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

            System.out.println("1-Arbol con tamaño 1000");
            metArbol.datosProfundidad(raiz1);
            System.out.println("2-Arbol con tamaño 5000");
            metArbol.datosProfundidad(raiz2);
            System.out.println("3-Arbol con tamaño 10000");
            metArbol.datosProfundidad(raiz3);
            System.out.println("4-Arbol con tamaño 20000");
            metArbol.datosProfundidad(raiz4);
            System.out.println("5-Arbol con tamaño 40000");
            metArbol.datosProfundidad(raiz5);
            System.out.println("6-Arbol con tamaño 50000");
            metArbol.datosProfundidad(raiz6);
        }
        if (opcion.equals("2")) {
            System.out.println("Cantidad de asignaciones, comparaciones, "
                     + "lineas ejecutadas y tiempo de ejecucion del algoritmo con recorrido de amplitud");

            System.out.println("1-Arbol con tamaño 1000");
            metArbol.datosAmplitud(raiz1);
            System.out.println("2-Arbol con tamaño 5000");
            metArbol.datosAmplitud(raiz2);
            System.out.println("3-Arbol con tamaño 10000");
            metArbol.datosAmplitud(raiz3);
            System.out.println("4-Arbol con tamaño 20000");
            metArbol.datosAmplitud(raiz4);
            System.out.println("5-Arbol con tamaño 40000");
            metArbol.datosAmplitud(raiz5);
            System.out.println("6-Arbol con tamaño 50000");
            metArbol.datosAmplitud(raiz6);
        }
        if(opcion.equals("3")){
            System.out.println("Cantidad de asignaciones, comparaciones, "
                     + "lineas ejecutadas y tiempo de ejecucion del algoritmo con recorrido de amplitud");

            System.out.println("1-Grafo con tamaño 1000");
            metGrafo.llenarGrafo(1000);
            //vertice grafo1 = metGrafo.grafo;
            metGrafo.datosProfundidad(grafo1);
            System.out.println("2-Grafo con tamaño 5000");
            metGrafo.llenarGrafo(1000);
            //vertice grafo2 = metGrafo.grafo;
            metGrafo.datosProfundidad(grafo1);
            System.out.println("3-Grafo con tamaño 10000");
            metGrafo.llenarGrafo(1000);
           // vertice grafo3 = metGrafo.grafo;
            metGrafo.datosProfundidad(grafo1);
            System.out.println("4-Grafo con tamaño 20000");
            metGrafo.llenarGrafo(1000);
            //vertice grafo4 = metGrafo.grafo;
            metGrafo.datosProfundidad(grafo1);
            System.out.println("5-Grafo con tamaño 40000");
           metGrafo.llenarGrafo(1000);
           // vertice grafo5 = metGrafo.grafo;
            metGrafo.datosProfundidad(grafo1);
            System.out.println("6-Grafo con tamaño 50000");
            metGrafo.llenarGrafo(1000);
           // vertice grafo6 = metGrafo.grafo;
            metGrafo.datosProfundidad(grafo1);
            
        }
        if(opcion.equals("4")){
            System.out.println("Cantidad de asignaciones, comparaciones, "
                     + "lineas ejecutadas y tiempo de ejecucion del algoritmo con recorrido de amplitud");

            System.out.println("1-Grafo con tamaño 1000");
            metGrafo.llenarGrafo(1000);
            //vertice grafo1 = metGrafo.grafo;
            metGrafo.datosAmplitud(grafo1);
            System.out.println("2-Grafo con tamaño 5000");
            metGrafo.llenarGrafo(1000);
            //vertice grafo2 = metGrafo.grafo;
            metGrafo.datosAmplitud(grafo1);
            System.out.println("3-Grafo con tamaño 10000");
            metGrafo.llenarGrafo(1000);
            //vertice grafo3 = metGrafo.grafo;
            metGrafo.datosAmplitud(grafo1);
            System.out.println("4-Grafo con tamaño 20000");
            metGrafo.llenarGrafo(1000);
            //vertice grafo4 = metGrafo.grafo;
            metGrafo.datosAmplitud(grafo1);
            System.out.println("5-Grafo con tamaño 40000");
            metGrafo.llenarGrafo(1000);
            //vertice grafo5 = metGrafo.grafo;
            metGrafo.datosAmplitud(grafo1);
            System.out.println("6-Grafo con tamaño 50000");
            metGrafo.llenarGrafo(1000);
            //vertice grafo6 = metGrafo.grafo;
            metGrafo.datosAmplitud(grafo1);
            
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
