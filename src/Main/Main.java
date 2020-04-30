/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Estructura.Arbol;
import Estructura.MetodosArboles;
<<<<<<< HEAD
import Estructura.MetodosGrafo;
=======
>>>>>>> task_binns

/**
 *
 * @author Sebas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
<<<<<<< HEAD
        MetodosArboles metArbol = MetodosArboles.getInstance();
        MetodosGrafo metGrafo = MetodosGrafo.getInstance();
        
        metArbol.llenarArbol(1000);
        Arbol raiz1 = metArbol.raiz;
        
        metArbol.llenarArbol(5000);
        Arbol raiz2 = metArbol.raiz;
        
        metArbol.llenarArbol(10000);
        Arbol raiz3 = metArbol.raiz;
        
        /*
        metArbol.llenarArbol(100000); //a partir de aquí manda java.lang.StackOverflowError
        Arbol raiz4 = metArbol.raiz;
        
        metArbol.llenarArbol(200000);
        Arbol raiz5 = metArbol.raiz;
        
        metArbol.llenarArbol(500000);
        Arbol raiz6 = metArbol.raiz;
        
        */
=======
        MetodosArboles ma = MetodosArboles.getInstance();

        ma.insertarOrdenado(5, ma.raiz);
        ma.insertarOrdenado(7, ma.raiz);
        ma.insertarOrdenado(10, ma.raiz);
        ma.insertarOrdenado(3, ma.raiz);
        ma.insertarOrdenado(2, ma.raiz);
        ma.insertarOrdenado(4, ma.raiz);
        ma.insertarOrdenado(6, ma.raiz);
        ma.amplitud(ma.raiz);
>>>>>>> task_binns
    }

}
