/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
/**
 *
 * @author Leo
 */
public class ArbolBin {
    private NodoArbol raiz;
    
    public ArbolBin (){
        raiz = null;
    }
    public Lista listarPosOrden(){
        Lista arbol;
        arbol = new Lista();
        posOrdenAux(raiz,arbol);
        return arbol;
    }
    private void posOrdenAux(NodoArbol n,Lista arbol){
        if(n != null){
            posOrdenAux(n.getIzquierdo(),arbol);
            posOrdenAux(n.getDerecho(),arbol);
            arbol.insertar(n.getElemento(),arbol.longitud() + 1);
            //El metodo longitud() de la clase Lista es de orden 1 porque se implemento la lista mejorada
        }
    }
    public Lista listarInOrden(){
        Lista lista;
        lista = new Lista();
        inOrdenAux(raiz,lista);
        return lista;
    }
    private void inOrdenAux(NodoArbol n,Lista arbol){
        if (n != null){
            inOrdenAux(n.getIzquierdo(),arbol);
            arbol.insertar(n.getElemento(),arbol.longitud() + 1);
            //El metodo longitud() de la clase Lista es de orden 1 porque se implemento la lista mejorada
            inOrdenAux(n.getDerecho(),arbol);
        }
    }
    public Lista listarPreOrden (){
        Lista arbol;
        arbol = new Lista();
        preOrdenAux(raiz,arbol);
        return arbol;
    }
    private void preOrdenAux (NodoArbol nodo,Lista arbol){
        if (nodo != null){
            arbol.insertar(nodo.getElemento(),arbol.longitud() + 1);
            //El metodo longitud() de la clase Lista es de orden 1 porque se implemento la lista mejorada
            preOrdenAux(nodo.getIzquierdo(),arbol);
            preOrdenAux(nodo.getDerecho(),arbol);
        }
    }
    public Lista listarPorNiveles(){
        Lista arbol;
        Cola colaAux;
        colaAux = new Cola();
        arbol = new Lista();
        colaAux.poner(raiz);
        while (!colaAux.esVacia()){
            NodoArbol nodoActual;
            nodoActual = (NodoArbol)colaAux.obtenerFrente();
            colaAux.sacar();
            arbol.insertar(nodoActual.getElemento(), arbol.longitud() + 1);
            //El metodo longitud() de la clase Lista es de orden 1 porque se implemento la lista mejorada
            if (nodoActual.getIzquierdo() != null){
                colaAux.poner(nodoActual.getIzquierdo());
            }
            if (nodoActual.getDerecho() != null){
                colaAux.poner(nodoActual.getDerecho());
            }
        }
        return arbol;
    }
    private NodoArbol obtenerNodo (NodoArbol n, Object buscado){
        NodoArbol resultado;
        resultado = null;
        if (n != null){
            if (n.getElemento().equals(buscado)){
            resultado = n;
            }
            else{
                resultado = obtenerNodo (n.getIzquierdo(), buscado);
                if (resultado == null){
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }
    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        boolean exito = true;
        if (this.raiz == null) {
            //Si el arbol no tiene raiz ahi colocaremos el nuevo elemento
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } 
        else {
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            //Buscamos el nodo padre;
            if (nodoPadre != null) {
                //Parametro lugar nos indica si debemos añadir como hijo izquierdo o derecho
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    //Si el nodo padre no tiene hijo izquierdo entonces colocamos el elemento
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                } 
                else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        //Si el nodo padre no tiene hijo derecho entonces colocamos ahi el elemento
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                    } 
                    else {
                        exito = false;
                    }
                }
            } 
            else {
                exito = false;
            }
        }
        return exito;
    }
    public boolean esVacio (){
        return raiz == null;
    }
    public Object padre(Object elemento){
        //Devuelve el padre de un elemento del arbol
        Object res;
        res = padreAux(raiz,elemento);
        return res;
    }
    private Object padreAux(NodoArbol n, Object elemento){
        Object res;
        res = null;
        if (n != null){
            if (n.getElemento().equals(elemento)){
                res = null;
            }
            else{
                if (n.getIzquierdo() != null ){
                    if (n.getIzquierdo().getElemento().equals(elemento)){
                        res = n.getElemento();
                    }
                    else{
                        res = padreAux(n.getIzquierdo(),elemento);
                    }
                }
                if (n.getDerecho() != null && res == null){
                    if (n.getDerecho().getElemento().equals(elemento)){
                        res = n.getElemento();
                    }
                    else{
                        res = padreAux(n.getDerecho(),elemento);
                    }
                }
            }
        }
        return res;
    }
    public int nivel(Object elemento){
        //Devuelve el nivel de un elemento del arbol
        int res;
        res = nivelAux(raiz,elemento);
        return res;
    }
    private int nivelAux(NodoArbol n,Object elemento){
        //Metodo recursivo privado para obtener el nivel de un nodo
        int res;
        res = -1;
        if (n != null){
            if (n.getElemento().equals(elemento)){
                res = 0;
            }
            else{
            //Buscamos el elemento pedido en subarbol izquierdo
                if (obtenerNodo(n.getIzquierdo(),elemento) != null){
                    res = 1 + nivelAux(n.getIzquierdo(),elemento);
                }
                else{
                    //Si no se encuentra, los buscamos en el subarbol derecho
                    if (obtenerNodo(n.getDerecho(),elemento) != null){
                        res = 1 + nivelAux(n.getDerecho(),elemento);
                    }
                }
            }
        }
        return res;
    }
    public int altura (){
        int altura;
        altura = alturaAux(raiz);
        return altura;
    }
    private int alturaAux (NodoArbol n){
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
    public void vaciar (){
        raiz = null;
    }
    public ArbolBin clone (){
        ArbolBin copia;
        copia = new ArbolBin();
        if (raiz != null){
            copia.raiz = cloneAux(this.raiz);
        }
        return copia;
    }
    private NodoArbol cloneAux (NodoArbol n){
        NodoArbol nuevo;
        nuevo = new NodoArbol(n.getElemento(),null,null);
        if (n.getIzquierdo() != null){
            nuevo.setIzquierdo(cloneAux(n.getIzquierdo()));
        }
        if (n.getDerecho() != null){
            nuevo.setDerecho(cloneAux(n.getDerecho()));
        }
        return nuevo;
    }
    public String toString (){
        String res;
        Cola colaAux;
        res = "";
        colaAux = new Cola();
        colaAux.poner(raiz);
        if (raiz == null){
            res = "Arbol vacio";
        }
        else{
            while (!colaAux.esVacia()){
                NodoArbol nodoActual;
                nodoActual = (NodoArbol)colaAux.obtenerFrente();
                colaAux.sacar();
                res = res + "P: " + nodoActual.getElemento().toString();
                if (nodoActual.getIzquierdo() != null){
                    res = res + "  HI: " + nodoActual.getIzquierdo().getElemento().toString();
                    colaAux.poner(nodoActual.getIzquierdo());
                }
                if (nodoActual.getDerecho() != null){
                    res = res + "  HD: " + nodoActual.getDerecho().getElemento().toString();
                    colaAux.poner(nodoActual.getDerecho());
                }
                res = res + "\n";
            }
        }
        return res;
    }
}    
