/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author Leo
 */
public class NodoAVL {
    private Comparable elemento;
    private NodoAVL derecho;
    private NodoAVL izquierdo;
    private int altura;
    
    public NodoAVL(Comparable elem, NodoAVL der, NodoAVL iz){
        elemento = elem;
        derecho = der;
        izquierdo = iz;
        altura = alturaAux(this);
    }
    public int getAltura(){
        return altura;
    }
    public void recalcularAltura(){
        altura = alturaAux(this);
    }
    public NodoAVL getIzquierdo(){
        return izquierdo;
    }
    public NodoAVL getDerecho(){
        return derecho;
    }
    public Comparable getElemento(){
        return elemento;
    }
    public void setDerecho(NodoAVL n){
        derecho = n;
        recalcularAltura();
    }
    public void setIzquierdo(NodoAVL n){
        izquierdo = n;
        recalcularAltura();
    }
    private int alturaAux(NodoAVL n){
        int res;
           res = -1;
           //La altura de un arbol vacio es -1
           //La altura de un arbol no vacio es 1 + la altura mayor entre sus subarboles izquierdo y derecho
           if (n != null){
               int altDer, altIz;
               altIz = 1 + alturaAux(n.getIzquierdo());
               altDer = 1 + alturaAux(n.getDerecho());
               if (altDer > altIz){
                   res = altDer;
               }
               else{
                   res = altIz;
               }
           }
        return res;
    }   
}
