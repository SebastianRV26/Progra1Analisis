/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author edubi
 */
public class Cola {

    private Nodo inicioCola, finalCola;
    String cola = "";
    public int asignacionesCola = 0;
    public int comparacionesCola = 0;
    public int lineasCola = 0;

    public Cola() {
        this.inicioCola = null;
        this.finalCola = null;
    }

    /**
     * metodo que permite saber cuando una lista
     * tipo cola esta vacia o no
     */
    public boolean colaVacia() {
        if (inicioCola == null) {//1
            comparacionesCola++;
            lineasCola++;
            return true;//1
        } else {
            lineasCola++;
            return false;//1
        }
  //Total medicion analitica 3
    }

   /**
    * Metodo que permite insertar en la lista tipo cola
    * 
    * @param aux  es el nuevo nodo que se va insertar
    * en la lista tipo cola
    */
    public void Insertar(Arbol aux) {
        Nodo nuevo = new Nodo();//1
        nuevo.value = aux;//1
        nuevo.sig = null;//1
        asignacionesCola += 3;
        lineasCola += 3;
        if (colaVacia()) {//4
            inicioCola = nuevo;//1
            finalCola = nuevo;//1
            lineasCola += 3;
            comparacionesCola++;
            asignacionesCola += 3;
        } else {
            finalCola.sig = nuevo;//1
            finalCola = nuevo;//1
            lineasCola += 3;
            asignacionesCola += 2;
        }
        //  //Total medicion analitica 12
    }
    /**
     * metodo  que permite eliminar nodos de 
     * la lista tipo cola
     */
    public Arbol Extraer() {
        if (!colaVacia()) {//4
            Arbol aux = inicioCola.value;//1
            lineasCola+=2;
            comparacionesCola++;
            asignacionesCola+=2;
            if (inicioCola == finalCola) {//1
                inicioCola = null;//1
                finalCola = null;//1
                lineasCola += 3;
                comparacionesCola++;
                asignacionesCola += 2;
            } else {
                inicioCola = inicioCola.sig;//1
                lineasCola+=2;
                asignacionesCola++;
            }
            lineasCola++;
            return aux;//1
        } else {
            lineasCola ++;
            return null;//1
        }
          //Total medicion analitica 11
    }

    /**
     * 
     *Metodo que permite recorer el arbol nodo por nodo y  los va guardando
     * en una lista tipo cola, para su posterior impresion
     *
     */
    public void imprimirCola() {
        Nodo recorrido = inicioCola;//1
        ArrayList<Arbol> arbolesList = new ArrayList<>();//1
        lineasCola +=2;
        asignacionesCola += 2;
        while (recorrido != null) {//n
            arbolesList.add(recorrido.value);//1*n
            recorrido = recorrido.sig;//1*n
            lineasCola+=3;
            comparacionesCola++;
            asignacionesCola+=2;
        }
        Collections.reverse(arbolesList);//1
        lineasCola+=2;
        comparacionesCola++;
        asignacionesCola++;
        for (int i = 0; i < arbolesList.size(); i++) {//2n
            lineasCola++;
            comparacionesCola++;
            asignacionesCola++;
            System.out.println("Arbol con id " + arbolesList.get(i).id);
        }
        lineasCola++;
        asignacionesCola++;
    }
      //Total medicion analitica 5n + 3
}
