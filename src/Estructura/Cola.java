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

    //Cola vacia
    public boolean colaVacia() {
        if (inicioCola == null) {
            comparacionesCola++;
            lineasCola++;
            return true;
        } else {
            lineasCola++;
            return false;
        }

    }

    public void Insertar(Arbol aux) {
        Nodo nuevo = new Nodo();
        nuevo.value = aux;
        nuevo.sig = null;
        asignacionesCola += 3;
        lineasCola += 3;
        if (colaVacia()) {
            inicioCola = nuevo;
            finalCola = nuevo;
            lineasCola += 3;
            comparacionesCola++;
            asignacionesCola += 3;
        } else {
            finalCola.sig = nuevo;
            finalCola = nuevo;
            lineasCola += 3;
            asignacionesCola += 2;
        }
    }

    public Arbol Extraer() {
        if (!colaVacia()) {//5
            Arbol aux = inicioCola.value;//1
            lineasCola+=2;
            comparacionesCola++;
            asignacionesCola+=2;
            if (inicioCola == finalCola) {//1
                inicioCola = null;
                finalCola = null;//2
                lineasCola += 3;
                comparacionesCola++;
                asignacionesCola += 2;
            } else {
                inicioCola = inicioCola.sig;
                lineasCola+=2;
                asignacionesCola++;
            }
            lineasCola++;
            return aux;
        } else {
            lineasCola ++;
            return null;
        }
    }

    public void imprimirCola() {
        Nodo recorrido = inicioCola;
        ArrayList<Arbol> arbolesList = new ArrayList<>();
        lineasCola +=2;
        asignacionesCola += 2;
        while (recorrido != null) {
            arbolesList.add(recorrido.value);
            recorrido = recorrido.sig;
            lineasCola+=3;
            comparacionesCola++;
            asignacionesCola+=2;
        }
        Collections.reverse(arbolesList);
        lineasCola+=2;
        comparacionesCola++;
        asignacionesCola++;
        for (int i = 0; i < arbolesList.size(); i++) {
            lineasCola++;
            comparacionesCola++;
            asignacionesCola++;
            System.out.println("Arbol con id " + arbolesList.get(i).id);
        }
        lineasCola++;
        asignacionesCola++;
    }
}
