/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

/**
 *
 * @author edubi
 */
public class MetodosArboles {
     public static MetodosArboles instance = null;
    public static MetodosArboles getInstance() {
        if (instance == null) {
            instance = new MetodosArboles();
        }
        return instance;
    }
    public Arbol raiz;
    public String resultado;
    
      public String insertarOrdenado(int id, Arbol aux) {
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
    public Arbol buscarArbol(int id, Arbol aux){
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
    public void imprimirPostorden(Arbol aux){
        if (aux == null) {
            return;
        }
        imprimirPostorden(aux.izq);
        imprimirPostorden(aux.der);
        System.out.println(aux.id);
    }

    public void imprimirOrden(Arbol aux) {
        if (aux == null) {
            return;
        }
        imprimirPostorden(aux.izq);
        System.out.println(aux.id);
        imprimirPostorden(aux.der);
    }

    public void imprimirPreOrden(Arbol aux) {
        if (aux == null) {
            return;
        }
        System.out.println(aux.id);
        imprimirPostorden(aux.izq);
        imprimirPostorden(aux.der);
    }
    
    public void llenarArbol(int n){
        for (int i=1; i<n;i++){
            insertarOrdenado(i, raiz);
        }
        
    }
}
