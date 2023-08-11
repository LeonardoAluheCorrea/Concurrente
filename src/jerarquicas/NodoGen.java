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
public class NodoGen {
    private Object elemento;
    private NodoGen hijo;
    private NodoGen hermano;
    
    public NodoGen (Object elemento, NodoGen hijo, NodoGen hermano){
        this.elemento = elemento;
        this.hijo = hijo;
        this.hermano = hermano;
    }
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    public void setHermano(NodoGen hermano){
        this.hermano = hermano;
    }
    public void setHijo(NodoGen hijo){
        this.hijo = hijo;
    }
    public Object getElemento(){
        return elemento;
    }
    public NodoGen getHermano(){
        return hermano;
    }
    public NodoGen getHijo(){
        return hijo;
    }
}
