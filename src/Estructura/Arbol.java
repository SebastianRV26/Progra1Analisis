/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 * Fecha inicio: 29/04/2020 
 * Ultima modificación: 29/04/2020
 */
public class Arbol { // clase árbol para árboles binarios

    int id;
    public Arbol izq, der;

    /**
     * constructor del árbol
     *
     * @param id identificador del nodo del árbol
     */
    public Arbol(int id) {
        this.id = id;
    }
}
