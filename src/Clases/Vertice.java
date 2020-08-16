/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *  Fecha inicio: 29/04/2020 
  * Ultima modificación: 29/04/2020
 */
public class Vertice { //vertice de un grafo

    public int ID; // identificador del vertice
    public Vertice sigV; // Puntero para referenciar a los siguientes vertices
    public Arco sigA; // Puntero para hacer referencia a los arcos
    public boolean marca; // Marca, utilizado para los diferentes imprimir y recorridos recursivos

    /**
     * constructor del vértice
     *
     * @param ID identificador del vertice
     * @param m marca del vértice
     */
    public Vertice(int ID, boolean m) {
        this.ID = ID;
        this.marca = m;
    }

}
