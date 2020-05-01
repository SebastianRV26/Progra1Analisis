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

/**
 *
 * @author Sebas
 */
public class Main {

    public static void menuAlgoritmos(){
       System.out.println("Digite un numero del 1 al 4 para ver los resultados de los algoritmos "
               + "1-Algoritmo de recorrido en profundidad Arbol binario"
               + "2-Algoritmo de recorrido en anchura Arbol binario "
               + "3-Algoritmo de recorrido en profundidad Grafo"
               + "4-Algoritmo de recorrido en anchura grafo");
       
       String opcion = System.console().readLine();
       
      if(opcion == "1"){
          
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
      if (opcion == "2"){
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
      if(opcion =="3"){
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
      if(opcion == "4"){
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
        
        
        
        //metArbol.imprimirOrden(metArbol.raiz);
        
        metArbol.llenarArbol(100);
        
        metArbol.imprimirOrden(metArbol.raiz);
    }

    private static void Switch(String opcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
