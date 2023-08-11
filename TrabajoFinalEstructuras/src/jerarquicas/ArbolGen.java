/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
/**
 *
 * @author Leo
 */
public class ArbolGen {
    private NodoGen raiz;
    
    public ArbolGen(){
        raiz = null;
    }
    public boolean esVacio(){
        return raiz == null;
    }
    public void vaciar(){
        raiz = null;
    }
    public Lista frontera(){
        Lista res;
        res = new Lista();
        fronteraAux(raiz,res);
        return res;
    }
    private void fronteraAux(NodoGen n, Lista ls){
        if (n != null){
            //Si el nodo "n" no tiene hijos entonces es parte de la frontera
            //Insertamos su elemento en la lista
            if (n.getHijo() == null){
                ls.insertar(n.getElemento(),ls.longitud() + 1);
            }
            else{
                NodoGen hijo;
                hijo = n.getHijo();
                //Usamos un while para recorrer los hijos del nodo "n"
                //Llamamos recursivamente para todos ellos
                while (hijo != null){
                    fronteraAux(hijo,ls);
                    hijo = hijo.getHermano();
                }
            }
        }
    }
    public Lista ancestros(Object elem){
        Lista ls;
        ls = new Lista();
        ancestroAux(raiz,elem,ls);
        return ls;
    }
    private boolean ancestroAux(NodoGen n, Object elem, Lista ls){
        boolean encontrado; 
        encontrado = false;
        if (n != null){
            if (n.getElemento().equals(elem)){
                encontrado = true;
            }
            else{
                if (n.getHijo() != null){
                    NodoGen hijo;
                    hijo = n.getHijo();
                    while(hijo != null && !encontrado){
                        encontrado = ancestroAux(hijo,elem,ls);
                        hijo = hijo.getHermano();
                    }
                    if(encontrado){
                        ls.insertar(n.getElemento(), ls.longitud() + 1);
                    }
                }
            }
        }
        return encontrado;
    }
    public boolean insertar(Object elem, Object elemPadre){
        boolean exito;
        exito = false;
        if (raiz != null){
            NodoGen padre;
            //Usamos el metodo obtener nodo para buscar al nodo que sera padre del nuevo nodo
            padre = obtenerNodo(elemPadre,raiz);
            if (padre != null){
                //Guardamos al hijo de "padre" y generamos el nuevo nodo
                NodoGen nuevo, hijo;
                nuevo = new NodoGen(elem,null,null);
                hijo = padre.getHijo();
                //Si "padre" no tenia hijos simplemente enlazamos el nuevo nodo
                if(hijo == null){
                    padre.setHijo(nuevo);
                    exito = true;
                }
                else{
                    //Si "padre" tiene hijos entonces insertamos el nuevo nodo como hermano del ultimo hijo
                    while(hijo != null && !exito){
                        if (hijo.getHermano() == null){
                            hijo.setHermano(nuevo);
                            exito = true;
                        }
                        hijo = hijo.getHermano();
                    }
                }
            }
        }
        else{
            //Si el arbol esta vacio el nuevo nodo sera raiz
            raiz = new NodoGen(elem,null,null);
            exito = true;
        }
        return exito;
    }
    private NodoGen obtenerNodo(Object elem, NodoGen n){
        NodoGen res;
        res = null;
        if (n != null){
            //Nos fijamos si "n" es el nodo que buscamos
            if (n.getElemento().equals(elem)){
                res = n;
            }
            else{
                if (n.getHijo() != null){
                    NodoGen hijo;
                    hijo = n.getHijo();
                    //Recorremos los hijos de "n" y llamamos recursivamente hasta encontrar el nodo buscado
                    while (hijo != null && res == null){
                        res = obtenerNodo(elem,hijo);
                        hijo = hijo.getHermano();
                    }
                }
            }
        }
        return res;
    }
    public int nivel(Object elem){
        int res;
        res = nivelAux(raiz, elem, 0);
        return res;
    }
    private int nivelAux(NodoGen n, Object elem, int nivel) {
        int res = -1;
        if (n != null) {
            //Nos fijamos si "n" es el nodo buscado
            if (n.getElemento().equals(elem)) {
                res = nivel;
            } 
            else {
                if (n.getHijo() != null) {
                    NodoGen hijo = n.getHijo();
                    //Recorremos los hijos de "n" y llamamos recursivamente hasta encontrar el nodo buscado
                    while (hijo != null && res == -1) {
                        res = nivelAux(hijo, elem, nivel + 1);
                        hijo = hijo.getHermano();
                    }
                }
            }
        }
        return res;
    }
    public boolean pertenece(Object elem){
        return perteneceAux(raiz,elem);
    }
    private boolean perteneceAux(NodoGen n, Object elem){
        boolean encontrado;
        encontrado = false;
        if (n != null){
            //Nos fijamos si "n" es el nodo que buscamos
            if (n.getElemento().equals(elem)){
                encontrado = true;
            }
            else{
                if (n.getHijo() != null){
                    NodoGen hijo;
                    hijo = n.getHijo();
                    //Recorremos todo los hijos de "n" y llamamos recursivamente hasta encontrar el que buscamos
                    while (hijo != null && !encontrado){
                        encontrado = perteneceAux(hijo,elem);
                        hijo = hijo.getHermano();
                    }
                }
            }
        }
        return encontrado;
    }
    public Object padre(Object elem){
        Object res;
        res = null;
        //Solo llamamos al mensaje auxiliar si el arbol no esta vacio
        if (raiz != null){
            //Nos fijamos si la raiz es el nodo buscado antes de llamar al mensaje auxiliar
            if (!raiz.getElemento().equals(elem)){
                res = padreAux(raiz,elem);
            }
        }
        return res;
    }
    private Object padreAux(NodoGen n, Object elem){
        Object padre;
        padre = null;
        if (n != null){
            if (n.getHijo() != null){
                NodoGen hijo;
                hijo = n.getHijo();
                //Recorremos los hijos de "n"
                while (hijo != null && padre == null){
                    //Nos fijamos si "hijo" es el nodo buscado
                    if (hijo.getElemento().equals(elem)){
                        padre = n.getElemento();
                    }
                    //Si no lo es llamamos recusivamente sobre el
                    else{
                        padre = padreAux(hijo,elem);
                    }
                    hijo = hijo.getHermano();
                }
            }
        }
        return padre;
    }
    public Lista listarPosorden(){
        Lista res;
        res = new Lista();
        listarPosOrdenAux(raiz,res);
        return res;
    }
    public void listarPosOrdenAux(NodoGen n, Lista ls){
        if (n != null){
            if (n.getHijo() != null){
                NodoGen hijo;
                hijo = n.getHijo();
                while (hijo != null){
                    listarPosOrdenAux(hijo, ls);
                    hijo = hijo.getHermano();
                }
            }
            ls.insertar(n.getElemento(), ls.longitud() + 1);
        }
    }
    public Lista listarPreorden(){
        Lista res;
        res = new Lista();
        listarPreOrdenAux(raiz,res);
        return res;
    }
    private void listarPreOrdenAux(NodoGen n, Lista ls){
        if (n != null){
            ls.insertar(n.getElemento(), ls.longitud() + 1);
            if (n.getHijo() != null){
                NodoGen hijo;
                hijo = n.getHijo();
                while (hijo != null){
                    listarPreOrdenAux(hijo, ls);
                    hijo = hijo.getHermano();
                }
            }
        }
    }
    public Lista listarInorden(){
        Lista res;
        res = new Lista();
        listarInOrdenAux(raiz,res);
        return res;
    }
    private void listarInOrdenAux(NodoGen n, Lista ls){
        if (n != null){
            if (n.getHijo() != null){
                listarInOrdenAux(n.getHijo(),ls);
            }
            ls.insertar(n.getElemento(), ls.longitud() + 1);
            if (n.getHijo() != null){
                NodoGen hijo;
                hijo = n.getHijo().getHermano();
                while (hijo != null){
                    listarInOrdenAux(hijo, ls);
                    hijo = hijo.getHermano();
                }
            }
        }
    }
    public int altura(){
        int res;
        res = alturaAux(raiz);
        return res;
    }
    private int alturaAux(NodoGen n){
        int altura;
        altura = -1;
        if (n != null){
            altura = 0;
            if (n.getHijo() != null){
                NodoGen hijo;
                int altHijo, altHermano;
                hijo = n.getHijo().getHermano();
                altHijo = 1 + alturaAux(n.getHijo());
                //Usamos altHijo para guardar la altura del HEI
                while (hijo != null){
                    //Usamos altHermano para guardar la altura de su hermano
                    altHermano = 1 + alturaAux(hijo);
                    //Luego comparamos altHijo con altHermano y guardamos en altHijo la mayor
                    if (altHermano > altHijo){
                        altHijo = altHermano;
                    }
                    hijo = hijo.getHermano();
                }
                //Cuando revisamos todos los hermanos y tenemos la mayor altura la retornamos
                altura = altHijo;
            }
        }
        return altura;
    }
    public Lista porNivel() {
        Cola cola = new Cola();
        Lista lista = new Lista();
        cola.poner(this.raiz);
        while (cola.esVacia() != true) {
            NodoGen nodo = (NodoGen) cola.obtenerFrente();
            cola.sacar();
            lista.insertar(nodo.getElemento(), lista.longitud() + 1);
            if (nodo.getHijo() != null) {
                cola.poner(nodo.getHijo());
            }
            if (nodo.getHijo() != null) {
                NodoGen hijo = nodo.getHijo().getHermano();
                while (hijo != null) {
                    cola.poner(hijo);
                    hijo = hijo.getHermano();
                }
            }
        }
        return lista;
    }
    public ArbolGen clone(){
        ArbolGen copia;
        copia = new ArbolGen();
        copia.raiz = cloneAux(this.raiz);
        return copia;
    }
    private NodoGen cloneAux(NodoGen n){
        NodoGen nuevo;
        nuevo = null;
        if (n != null){
            //Creamos un nuevo nodo
            nuevo = new NodoGen(n.getElemento(), null, null);
            //Si "n" tiene hijos
            if (n.getHijo() != null){
                //Colocamos como hijo del nuevo nodo al resultado de llamar recursivamente con el hijo de "n"
                nuevo.setHijo(cloneAux(n.getHijo()));
            }
            //Si "n" tiene hermanos
            if (n.getHermano() != null){
                //Colocamos como hijo del nuevo nodo al resultado de llamar recursivamente con el hijo de "n"
                nuevo.setHermano(cloneAux(n.getHermano()));
            }
        }
        return nuevo;
    }
    public String toString(){
        return toStringAux(raiz);
    }
    private String toStringAux(NodoGen n){
        String res;
        res = "";
        if (n != null){
            res += n.getElemento().toString() + "-->";
            NodoGen hijo;
            hijo = n.getHijo();
            while (hijo != null){
                res += hijo.getElemento().toString() + ", ";
                hijo = hijo.getHermano();
            }
            hijo = n.getHijo();
            while (hijo != null){
                res += "\n" + toStringAux(hijo);
                hijo = hijo.getHermano();
            }
        }
        return res;
    }
}
