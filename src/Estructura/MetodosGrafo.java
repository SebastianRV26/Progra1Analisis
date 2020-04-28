/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import javax.swing.DefaultListModel;

/**
 *
 * @author Sebas
 */
public class MetodosGrafo {

    DefaultListModel<String> listModel = new DefaultListModel<>();

    vertice grafo;

    public String insertarVertices(String nombre) {
        vertice nuevo = new vertice(nombre, false);
        if (grafo == null) {
            grafo = nuevo;
            return "Insertado";
        }
        nuevo.sigV = grafo; //insersion al inicio de una lista
        grafo = nuevo;
        return "";
    }

    public vertice buscar(String nombre) {
        vertice aux = grafo;
        while (aux != null) {
            if (aux.nombre.equals(nombre)) {
                return aux;
            }
            aux = aux.sigV;
        }
        return null;
    }

    public String insertarArco(vertice origen, vertice destino, int peso) {
        if (buscar(origen, destino) == null) {
            arco nuevo = new arco(peso);
            nuevo.destino = destino;
            if (origen.sigA == null) {
                origen.sigA = nuevo;
            } else {
                nuevo.sigA = origen.sigA;
                origen.sigA.antA = nuevo;
                origen.sigA = nuevo;
            }
            return "Insertado";
        }
        return "No se pueden repetir arcos";
    }

    public arco buscar(vertice origen, vertice destino) {
        if (origen.sigA != null) {
            arco aux = origen.sigA;
            while (aux != null) {
                if (aux.destino == destino) {
                    return aux;
                }
                aux = aux.sigA;
            }
        }
        return null;
    }

    void profundidad(vertice grafo) //metodo que imprime el inicio en profundidad
    {
        if ((grafo == null) | (grafo.marca == true)) {
            return;
        } else {
            grafo.marca = true;
            arco aux = grafo.sigA;
            while (aux != null) {
                listModel.addElement("Origen: " + grafo.nombre);
                listModel.addElement("Peso: " + aux.peso);
                listModel.addElement("Destino: " + aux.destino.nombre);
                profundidad(aux.destino);
                aux = aux.sigA;
            }
        }
    }

    void amplitud(vertice grafo) // metodo para imprimir el inicio en amplitud
    {
        if (grafo == null) {
            System.out.println("No hay grafo");
        } else {
            vertice temp = grafo;
            while (temp != null) {
                listModel.addElement("Vertice: " + temp.nombre);
                arco aux = temp.sigA;
                while (aux != null) {
                    //listModel.addElement("Peso: " + aux.peso);
                    listModel.addElement("Destino: " + aux.destino.nombre);
                    aux = aux.sigA;
                }
                listModel.addElement("-----------");
                temp = temp.sigV;
            }
        }
    }

    public boolean eliminaArco(vertice origen, vertice destino) {
        //origen destino y elimina el arco si existe (un arco directo)
        //en la interfaz primero buscar vertice 

        arco aux = buscar(origen, destino);
        if (aux != null) {
            if (origen.sigA == aux) { //es el primero
                origen.sigA = aux.sigA;
                if (origen.sigA != null) { //si hay otro nodo
                    aux.sigA.antA = null;
                }
                return true;
            }//si no es el primero
            aux.antA.sigA = aux.sigA;
            if (aux.sigA != null) {
                aux.sigA.antA = aux.antA;
            }
            return true;
        }
        return false;
    }

    public boolean eliminarVertice(vertice verticePorEliminar) {
        //antes de eiliminar un vertice tiene que eliminar los arcos que apuntan a este   
        vertice aux = grafo;
        vertice ant = grafo;
        while (aux != null) { //se eliminan los arcos que apunten al vertice por eliminar
            eliminaArco(aux, verticePorEliminar);

            //para el anterior
            if (aux.sigV.equals(verticePorEliminar)) {
                ant = aux;
            }
            aux = aux.sigV;
        }//eliminar el vertice
        if (verticePorEliminar.equals(grafo)) { //si es el primero
            grafo = verticePorEliminar.sigV;
        }
        ant.sigV = verticePorEliminar.sigV;
        return true;
    }

    public void quitarMarca() {
        vertice aux = grafo;
        while (aux != null) {
            aux.marca = false;
            aux = aux.sigV;
        }
    }

}
