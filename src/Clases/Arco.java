/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 * Fecha inicio: 29/04/2020 
 * Ultima modificación: 29/04/2020
 */
public class Arco { //arco de un grafo

    public Arco antA, sigA;//Siguiente arco
    public Vertice destino;//Como es un grafo multilista, para hacer referencia al destino
    public int peso;//Peso del arco

    /**
     * constructor del arco
     *
     * @param p peso del arco
     */
    public Arco(int p) { // 
        peso = p;
    }
}
