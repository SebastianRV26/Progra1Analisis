/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 *
 * @author Sebas
 */
public class vertice { //vertice de un grafo
    public int ID;//Nombre del vertice
    public vertice sigV;//Puntero para referenciar a los siguientes vertices
    public arco sigA;//Puntero para hacer referencia a los arcos
    public boolean marca;//Marca, utilizado para los diferentes imprimir y recorridos recursivos
    public vertice(int ID, boolean m){ // constructor
        this.ID = ID;
        this.marca = m;
    }

}
