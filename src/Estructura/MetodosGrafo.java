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

    public static MetodosGrafo instance = null;
    public static MetodosGrafo getInstance() {
        if (instance == null) {
            instance = new MetodosGrafo();
        }
        return instance;
    }
    
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
                    listModel.addElement("Destino: " + aux.destino.nombre);
                    aux = aux.sigA;
                }
                listModel.addElement("-----------");
                temp = temp.sigV;
            }
        }
    }

    boolean flag = false;

    public void hayRuta(vertice origen, vertice destino) //metodo que imprime el inicio en profundidad
    {
        if ((origen == null) | (origen.marca == true)) {
            return;
        } else {
            origen.marca = true;
            arco aux = origen.sigA;
            while (aux != null) {
                if (aux.destino.equals(destino)) {
                    flag = true;
                }
                hayRuta(aux.destino, destino);
                aux = aux.sigA;
            }
        }
    }
    
    public boolean grafoConexo() { // Método para VERIFICAR si un grafo es conexo, luego ELIMINAR 
        if (grafo != null) {
            vertice aux = grafo;
            while (aux != null) {
                vertice aux2 = grafo;
                while (aux2 != null) {
                    if (aux2 != aux) {
                        flag = false;
                        hayRuta(aux, aux2);
                        if (flag == false) {
                            return false;
                        }
                    }
                    aux2 = aux2.sigV;
                }
            }
            return true;
        }
        return false;
    }
}
