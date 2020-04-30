/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author edubi
 */

public class MetodosArboles {
    public static MetodosArboles instance = null; // instancia de la clase MetodosArboles
    public static MetodosArboles getInstance() { // singleton para que exista únicamente una instacia de la clase
        if (instance == null) {
            instance = new MetodosArboles();
        }
        return instance;
    }
<<<<<<< HEAD
    public Arbol raiz; // raíz del árbol
    public String resultado; // por si desea saber el estado del método insertarOrdenado
=======
    public Arbol raiz;
    String resultado;
      int global = 0;
>>>>>>> task_binns
    
    public String insertarOrdenado(int id, Arbol aux) { // método que inserta un nodo en el arbol de manera ordenada
        if (raiz == null) {
            Arbol nuevoArbol = new Arbol(id);
            raiz = nuevoArbol;
            return resultado = "insertado";
        } else {
            if (id == aux.id) {
                
                return resultado = "repetido";
            }
            if (id < aux.id) {
                if (aux.izq == null) {
                    aux.izq = new Arbol(id);
                    return resultado = "insertado";
                } else {
                    insertarOrdenado(id, aux.izq);
                }
            }
            if (id > aux.id) {
                if (aux.der == null) {
                    aux.der = new Arbol(id);
                    return resultado = "insertado";
                } else {
                    insertarOrdenado(id, aux.der);
                }
            }

            return resultado;
        }
    }
    public Arbol buscarArbol(int id, Arbol aux){ // buscar un nodo del Arbol, aux es un auxiliar de la raíz
         if (raiz == null) {
             return null;
        } else {
            if (id == aux.id) {
                return aux;
            }
            if (id < aux.id) {
                if (aux.izq == null) {
                    return null;
                } else {
                    return buscarArbol(id, aux.izq);
                }
            }
                if (aux.der == null) {
                    return null;
                } else {
                    return buscarArbol(id, aux.der);
                }
        }
    }
    public void imprimirPostorden(Arbol aux){  // método que imprime los nodos: izquierda, derecha y raiz 
        if (aux == null) { // condicion de parada para la recursividad
            return;
        }
        imprimirPostorden(aux.izq);
        imprimirPostorden(aux.der);
        System.out.println(aux.id);
    }

    public void imprimirOrden(Arbol aux) { // método que imprime los nodos: izquierda, raiz y derecha
        if (aux == null) { // condicion de parada para la recursividad
            return;
        }
        imprimirOrden(aux.izq);
        System.out.println(aux.id);
        imprimirOrden(aux.der);
    }

    public void imprimirPreOrden(Arbol aux) { // método que imprime los nodos: raiz izquierda y derecha
        if (aux == null) { // condicion de parada para la recursividad
            return;
        }
        System.out.println(aux.id);
        imprimirPreOrden(aux.izq);
        imprimirPreOrden(aux.der);
    }
<<<<<<< HEAD
    
    public void llenarArbol(int n){ // método que llena el arbol de forma ordenada
        raiz = null; // se iguala a null para poder crear otros árboles
        insertarOrdenado(n/2, raiz); 
        for (int i=0; i<=n; i++){
            insertarOrdenado(i, raiz);
        }
    }
=======



    
    public void amplitud(Arbol value){
        Arbol aux;
        Cola cola, colaAux;
        if(value != null){
            cola = new Cola();
            colaAux = new Cola();
            cola.Insertar(value);
            while (!cola.colaVacia()) {                
                colaAux.Insertar(aux = cola.Extraer());
                if(aux.izq != null){
                    cola.Insertar(aux.izq);
                }
                if(aux.der != null){
                    cola.Insertar(aux.der);
                }
            }
            colaAux.imprimirCola();
        }
    }
    

    
>>>>>>> task_binns
}
