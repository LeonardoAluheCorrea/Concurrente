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
public class ArbolAVL {
    private NodoAVL raiz;
    
    public ArbolAVL(){
        raiz = null;
    }
    public boolean esVacio(){
        return raiz == null;
    }
    public boolean insertar(Comparable elem){
        boolean exito;
        exito = true;
        if (raiz == null){
            raiz = new NodoAVL(elem,null,null);
        }
        else{
            exito = insertarAux(raiz,elem);
        }
        return exito;
    }
    private boolean insertarAux(NodoAVL n, Comparable elem){
        boolean exito;
        exito = true;
        if (elem.compareTo(n.getElemento()) == 0){
            exito = false;
        }
        else{
            if (elem.compareTo(n.getElemento()) < 0){
                if (n.getIzquierdo() != null){
                    exito = insertarAux(n.getIzquierdo(),elem);
                    balancear(n);
                }
                else{
                    n.setIzquierdo(new NodoAVL(elem,null,null));
                }
            }
            else{
                if (n.getDerecho() != null){
                    exito = insertarAux(n.getDerecho(),elem);
                    balancear(n);
                }
                else{
                    n.setDerecho(new NodoAVL(elem,null,null));
                }
            }
        }
        return exito;
    }        
    private NodoAVL balancear(NodoAVL n){
        int balance, altDer, altIz;
        NodoAVL nuevaRaiz;
        nuevaRaiz = n;
        //Calculamos el balance del nodo n
        altDer = n.getDerecho().getAltura();
        altIz = n.getIzquierdo().getAltura();
        balance = altDer - altIz;
        //Nos fijamos si esta balanceado
        if (Math.abs(balance) >= 2){
            //Si no lo esta, buscamos el caso de balanceo correcto
            if (balance == 2){
                //Calculamos el balance del hijo derecho de n
                altDer = n.getDerecho().getDerecho().getAltura();
                altIz = n.getDerecho().getIzquierdo().getAltura();
                balance = altDer - altIz;
                //Aplicamos la rotacion correspondiente
                if (balance == 1){
                    nuevaRaiz = rotarDerecha(n);
                }
                if (balance == -1){
                    nuevaRaiz = rotarIzquierdaDerecha(n);
                }
            }
            if (balance == -2){
                //Calculamos el balance del hijo izquierdo de n
                altDer = n.getIzquierdo().getDerecho().getAltura();
                altIz = n.getIzquierdo().getIzquierdo().getAltura();
                balance = altDer - altIz;
                if (balance == -1){
                    nuevaRaiz = rotarIzquierda(n);
                }
                if (balance == 1){
                    nuevaRaiz = rotarDerechaIzquierda(n);
                }
            }
        }
        return nuevaRaiz;
    }
    private NodoAVL rotarIzquierda(NodoAVL n){
        NodoAVL h,temp;
        h = n.getDerecho();
        temp = h.getIzquierdo();
        h.setIzquierdo(n);
        n.setDerecho(temp);
        return h;
    }
    private NodoAVL rotarDerecha(NodoAVL n){
        NodoAVL h, temp;
        h = n.getIzquierdo();
        temp = h.getDerecho();
        h.setDerecho(n);
        n.setIzquierdo(temp);
        return h;
    }
    private NodoAVL rotarDerechaIzquierda(NodoAVL n){
        NodoAVL hijo,res;
        //En la variable hijo colocamos el subarbol derecho de n, rotado a la derecha
        hijo = rotarDerecha(n.getDerecho());
        n.setDerecho(hijo);
        //En la variable res colocamos la raiz del nuevo arbol balanceado
        res = rotarIzquierda(n);
        return res;
    }
    private NodoAVL rotarIzquierdaDerecha(NodoAVL n){
        NodoAVL hijo, res;
        //En la variable hijo colocamos el subarbol izquierdo de n rotado a la izquierda
        hijo = rotarIzquierda(n.getIzquierdo());
        //En la variable res colocamos la raiz del nuevo arbol balanceado
        res = rotarDerecha(n);
        return res;
    }
}
