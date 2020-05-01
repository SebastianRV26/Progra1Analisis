/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author edubi
 */
public class Cola {

    private Nodo inicioCola, finalCola;
    String cola = "";
    public int asignacionesCola = 0;
    public int comparacionesCola = 0;

    public Cola() {
        this.inicioCola = null;
        this.finalCola = null;
    }

    //Cola vacia
    public boolean colaVacia() {
        if (inicioCola == null) {
            comparacionesCola++;
            return true;
        } else {
            return false;
        }

    }

    public void Insertar(Arbol aux) {
        Nodo nuevo = new Nodo();
        nuevo.value = aux;
        nuevo.sig = null;
        asignacionesCola += 3;
        if (colaVacia()) {
            comparacionesCola++;
            inicioCola = nuevo;
            finalCola = nuevo;
            asignacionesCola += 2;
        } else {
            finalCola.sig = nuevo;
            finalCola = nuevo;
            asignacionesCola += 2;
        }
    }

    public Arbol Extraer() {
        if (!colaVacia()) {
            comparacionesCola++;
            Arbol aux = inicioCola.value;
            asignacionesCola++;
            if (inicioCola == finalCola) {
                comparacionesCola++;
                inicioCola = null;
                finalCola = null;
                asignacionesCola += 2;
            } else {
                inicioCola = inicioCola.sig;
                asignacionesCola += 2;
            }
            return aux;
        } else {
            return null;
        }
    }

    public void imprimirCola() {
        Nodo recorrido = inicioCola;
        ArrayList<Arbol> arbolesList = new ArrayList<>();
        asignacionesCola += 2;
        while (recorrido != null) {
            comparacionesCola++;
            arbolesList.add(recorrido.value);
            recorrido = recorrido.sig;
            asignacionesCola++;
        }
        Collections.reverse(arbolesList);
        for (int i = 0; i < arbolesList.size(); i++) {
            comparacionesCola++;
            System.out.println("Arbol con id " + arbolesList.get(i).id);
        }

    }
}
