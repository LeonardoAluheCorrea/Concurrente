/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Leo
 */
public class Pila {
    private Nodo tope;
    
    public Pila (){
        tope = null;
    }
    public boolean apilar (Object nuevoElemento){
        Nodo nuevoNodo;
        nuevoNodo = new Nodo (nuevoElemento, tope);
        tope = nuevoNodo;
        return true;
    }
    public boolean desapilar (){
        boolean exito;
        if (tope == null)
            exito = false;
        else{
            tope = tope.getEnlace();
            exito = true;
        }
        return exito;
    }
    public Object obtenerTope (){
        Object res;
        if (tope != null)
            res = tope.getElemento();
        else
            res = null;
        return res;
    }
    public boolean esVacia (){
        boolean vacia;
        vacia = tope == null;
        return vacia;
    }
    public void vaciar (){
        tope = null;
    }
    public Pila clone (){
        Pila copia;
        Nodo auxiliar1, auxiliar2;
        if (tope == null)
            copia = new Pila();
        else{
            auxiliar2 = new Nodo(tope.getElemento(), tope.getEnlace());
            copia = new Pila();
            copia.tope = auxiliar2;
            auxiliar1 = tope.getEnlace();
            while (auxiliar1 != null){
                auxiliar2.setEnlace(new Nodo(auxiliar1.getElemento(), auxiliar1.getEnlace()));
                auxiliar2 = auxiliar2.getEnlace();
                auxiliar1 = auxiliar1.getEnlace();
            }
        }
        return copia;
    }
    public String toString (){
        String result;
        result = "";
        if (tope == null)
            result = "Pila vacia";
        else{
            Nodo auxiliar;
            auxiliar = tope;
            while (auxiliar != null){
                result = auxiliar.getElemento() + result;
                auxiliar = auxiliar.getEnlace();
            }
        }
        return result;
    }
    
}
