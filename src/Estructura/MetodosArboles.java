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
     public static MetodosArboles instance = null;
    public static MetodosArboles getInstance() {
        if (instance == null) {
            instance = new MetodosArboles();
        }
        return instance;
    }
    public Arbol raiz;
    String resultado;
      int global = 0;
    
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
                    insertarOrdenado( id, aux.izq);
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
        imprimirOrden(aux.izq);
        System.out.println(aux.id);
        imprimirOrden(aux.der);
    }

    public void imprimirPreOrden(Arbol aux) {
        if (aux == null) {
            return;
        }
        System.out.println(aux.id);
        imprimirPreOrden(aux.izq);
        imprimirPreOrden(aux.der);
    }



    
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
    
    public void amplitudP(Arbol a) {//SE RECIBE LA RAIZ DEL ARBOL

        Arbol aux; //DEFINICIÓN AUX DE TIPO NODOARBOL

        LinkedList cola, colaAux ;        //DEFINICIÓN DE 2 VARIABLES DE TIPO COLA
        if (a != null) //SI EL ÁRBOL CONTIENE NODOS...
        {
            cola = new LinkedList(); //SE INSTANCIA EL OBJETO COLA
            colaAux = new  LinkedList();//SE INSTANCIA EL OBJETO COLAAUX
            cola.push(a); //SE INSERTA EL NODOARBOL "A" (RAIZ) COMO PRIMER NODO EN LA COLA
            while (cola.peek() != null) //MIENTRAS HAYAN ELEMENTOS EN LA COLA...
            {
                colaAux.push(aux = (Arbol) cola.pop());
    
                /*EL ELEMENTO EXTRAIDO DE LA COLA PRINCIPAL ES ASIGNADO
A AUX Y A SU VEZ INSERTADO EN LA COLA AUXILIAR*/
                if (aux.izq != null) //SI EL HIJO IZQUIERDO DEL NODO ACTUAL EXISTE
                {
                    cola.push(aux.izq); //SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA COLA
                }
                if (aux.der != null) //SI EL HIJO DERECHO DEL NODO ACTUAL EXISTE
                {
                    cola.push(aux.der); //SE INSERTA ESE HIJO COMO ELEMENTO SIGUIENTE EN LA COLA
                }
          Arbol xxxxx = (Arbol) colaAux.poll();
            System.out.println(xxxxx.id);
            }
  
 //POR ÚLTIMO SE IMPRIME LA COLA AUXILIAR
        }
     }
    
    public void ImprimirPorNivel(Arbol aux, int cont, int nivel) {
        if (aux == null) {
            return;
        }
        cont++;
        if (cont == nivel) {
            System.out.println("Identificacion: " + "" + aux.id);
          System.out.println("<--------------------->");
        }

        ImprimirPorNivel(aux.izq, cont, nivel);
        ImprimirPorNivel(aux.der, cont, nivel);
    }
    
    public void Niveles(Arbol aux, int h) {
        if (aux == null) {
            return;
        }
        h++;
        Niveles(aux.izq, h);
        if (global < h) {
            global = h;
        }
        Niveles(aux.der, h);
    }

    public void ImprimirNiveles() {
        global = 0;
        Niveles(raiz, -1);
        for (int i = 0; i <= global; i++) {
            ImprimirPorNivel(raiz, -1, i);
        }
    }
    
}
