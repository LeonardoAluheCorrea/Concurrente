/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAEspecificos;
import conjuntistas.NodoAVL;
/**
 *
 * @author Leo
 */
public class NodoAVLDicc {
    private Comparable clave;
    private Object dato;
    private NodoAVLDicc izquierdo;
    private NodoAVLDicc derecho;
    private int altura;

    public NodoAVLDicc(Comparable clave, Object dato, NodoAVLDicc izquierdo, NodoAVLDicc derecho) {
        this.clave = clave;
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.altura = 0;
    }

    public Comparable getClave() {
        return clave;
    }

    public void setClave(Comparable clave) {
        this.clave = clave;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoAVLDicc getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVLDicc izquierdo) {
        this.izquierdo = izquierdo;
        this.recalcularAltura();
    }

    public NodoAVLDicc getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVLDicc derecho) {
        this.derecho = derecho;
        this.recalcularAltura();
    }

    public int getAltura() {
        return altura;
    }

    public void recalcularAltura() {
        int altDer, altIz;
        altDer = -1;
        altIz = -1;
        if (derecho != null){
            altDer = derecho.getAltura();
        }
        if (izquierdo != null){
            altIz = izquierdo.getAltura();
        }
        if (altDer > altIz){
            altura = 1 + altDer;
        }
        else{
            altura = 1 + altIz;
        }
    }
    
    public int calcularBalance(){
        int balance, altDer, altIz;
        altDer = -1;
        altIz = -1;
        if (derecho != null){
            altDer = derecho.getAltura();
        }
        if (izquierdo != null){
            altIz = izquierdo.getAltura();
        }
        balance = altIz - altDer;
        return balance;
    }
    
    private int alturaAux(NodoAVLDicc n){
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
