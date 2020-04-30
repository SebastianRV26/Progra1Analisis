/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import javax.swing.JOptionPane;

/**
 *
 * @author edubi
 */
public class Cola {
    private Nodo inicioCola, finalCola;
    String  cola = "";

    public Cola() {
        this.inicioCola = null;
        this.finalCola = null;
    }
    
    //Cola vacia
    
    public boolean colaVacia(){
        return inicioCola == null;
    }
    
    public void Insertar(Arbol aux){
        Nodo nuevo = new Nodo();
        nuevo.value = aux;
        nuevo.sig = null;
        
        if (colaVacia()) {
            inicioCola = nuevo;
            finalCola = nuevo;
        } else {
            finalCola.sig = nuevo;
            finalCola = nuevo;
        }
    }

    public Arbol Extraer() {
        if (!colaVacia()) {
            Arbol  aux = inicioCola.value;
            
            if (inicioCola == finalCola) {
                inicioCola = null;
                finalCola = null;
            } else {
                inicioCola = inicioCola.sig;
            }
            return aux;
        } else {
            return null;
        }
    }
    
    public void imprimirCola(){
        Nodo recorrido = inicioCola;
        String colaInvertida = "";
        
        while (recorrido != null) {            
            cola += recorrido.value.id + " ";
            recorrido = recorrido.sig;
        }
        String cadena [] = cola.split(" ");
        for (int i = cadena.length - 1; i  >= 0; i--) {
            
            colaInvertida += " " + cadena[i];
        }
         System.out.println(colaInvertida);
        cola =  "";
    }
}
