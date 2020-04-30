/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Estructura.Arbol;
import Estructura.MetodosArboles;

/**
 *
 * @author Sebas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MetodosArboles ma = MetodosArboles.getInstance();

        ma.insertarOrdenado(5, ma.raiz);
        ma.insertarOrdenado(7, ma.raiz);
        ma.insertarOrdenado(10, ma.raiz);
        ma.insertarOrdenado(3, ma.raiz);
        ma.insertarOrdenado(2, ma.raiz);
        ma.insertarOrdenado(4, ma.raiz);
        ma.insertarOrdenado(6, ma.raiz);
        ma.amplitud(ma.raiz);
    }

}
