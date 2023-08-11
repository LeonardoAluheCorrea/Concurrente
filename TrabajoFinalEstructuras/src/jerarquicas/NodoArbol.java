/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author Leo
 */
public class NodoArbol {
    private Object elemento;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    public NodoArbol (Object elem, NodoArbol iz, NodoArbol der){
        elemento = elem;
        izquierdo = iz;
        derecho = der;
    }
    public Object getElemento (){
       return elemento; 
    }
    public NodoArbol getDerecho (){
        return derecho;
    }
    public NodoArbol getIzquierdo (){
        return izquierdo;
    }
    public void setElemento (Object elem){
        elemento = elem;
    }
    public void setIzquierdo (NodoArbol iz){
        izquierdo = iz;
    }
    public void setDerecho (NodoArbol der){
        derecho = der;
    }
}
