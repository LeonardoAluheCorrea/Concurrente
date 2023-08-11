/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

import jerarquicas.NodoArbol;

/**
 *
 * @author Leo
 */
public class NodoABB {
    private Comparable elemento;
    private NodoABB derecho;
    private NodoABB izquierdo;
    
     public NodoABB (Comparable elem, NodoABB iz, NodoABB der){
        elemento = elem;
        izquierdo = iz;
        derecho = der;
    }
    public Comparable getElemento (){
       return elemento; 
    }
    public NodoABB getDerecho (){
        return derecho;
    }
    public NodoABB getIzquierdo (){
        return izquierdo;
    }
    public void setElemento (Comparable elem){
        elemento = elem;
    }
    public void setIzquierdo (NodoABB iz){
        izquierdo = iz;
    }
    public void setDerecho (NodoABB der){
        derecho = der;
    }
}
