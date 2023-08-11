/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author Leo
 */
public class Pila {
    private int tope;
    private Object[] arreglo;
    private static final int TAMANIO = 10;
    
    public Pila(){
        this.tope = -1;
        this.arreglo = new Object[TAMANIO];
    }
    
    public boolean apilar(Object elto){
        boolean exito;
        if (tope+1 >= TAMANIO)
            exito = false;
        else{
            tope++;
            arreglo[tope] = elto;
            exito = true;
        }
        return exito;
    }
    
    public boolean desapilar (){
        boolean exito;
        if (tope < 0)
            exito = false;
        else{
            arreglo[tope] = null;
            tope--;
            exito = true;
        }
        return exito;
    }
    
    public Object obtenerTope (){
        Object elto;
        if (tope < 0)
            elto = null;
        else 
            elto = arreglo[tope];
        return elto;
    }
    
    public boolean esVacia(){
        boolean vacia;
        vacia = tope < 0;
        return vacia;
    }
    
    public void vaciar(){
        if (tope >= 0){
            for (int i = 0; i <= tope; i++){
                arreglo[i] = null;
            }
            tope = -1;
        }
    }
    
    public Pila clone(){
        Pila copia;
        copia = new Pila();
        copia.tope = this.tope;
        if (this.tope >= 0){
            for (int i = 0; i <= this.tope; i++)
                copia.arreglo[i] = this.arreglo[i];
        }
        return copia;
    }
    
    public String toString(){
        String pila;
        pila = "";
        if (tope < 0)
            pila = "La pila esta vacia";
        else {
            for (int i = 0; i <= tope ; i++)
                pila = pila + arreglo[i];
        }
        return pila;
    }
    
}
