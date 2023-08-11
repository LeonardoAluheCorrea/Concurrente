/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
/**
 *
 * @author Leo
 */
public class ArbolBB {
    private NodoABB raiz;
    
    public ArbolBB (){
        raiz = null;
    }
    public boolean esVacio(){
        return raiz == null;
    }
    public void vaciar(){
        raiz = null;
    }
    public Lista listarRango(Comparable min, Comparable max){
        Lista intervalo;
        intervalo = new Lista();
        listarRangoAux(raiz,min,max,intervalo);
        return intervalo;
    }
    private void listarRangoAux(NodoABB n,Comparable min, Comparable max, Lista ls){
        if (n != null){
            boolean menor, mayor, igual;
            igual = n.getElemento().compareTo(min) == 0 || n.getElemento().compareTo(max) == 0;
            mayor = n.getElemento().compareTo(min) > 0;
            menor = n.getElemento().compareTo(max) < 0;
                if (mayor){
                    listarRangoAux(n.getIzquierdo(),min,max,ls);
                }
                if ((mayor && menor) || igual){
                    ls.insertar(n.getElemento(),ls.longitud() + 1);
                }
                if (menor){
                    listarRangoAux(n.getDerecho(),min,max,ls);
                }
        }
    }
    public void eliminarMinimo(){
        NodoABB auxiliar, padreAux;
        padreAux = raiz;
        if (raiz != null){
             auxiliar = raiz.getIzquierdo();
            //Si la raiz no tiene hijos entonces la eliminamos
            if (auxiliar == null){
                raiz = null;
            }
            else{        
                //Nos dirigimos hacia la izquierda para encontrar el minimo
                while (auxiliar.getIzquierdo() != null){
                    padreAux = auxiliar;
                    auxiliar = auxiliar.getIzquierdo();
                }           
                //Encontrado el minimo debemos borrarlo
                //Si el minimo tiene hijo derecho entonces lo colocamos como hijo izquierdo del padre del minimo
                if (auxiliar.getDerecho() != null){
                    padreAux.setIzquierdo(auxiliar.getDerecho());
                }
                //Si el minimo es hoja, borramos el enlace con su padre
                else{
                    padreAux.setIzquierdo(null);
                }
            }
        }
    }
    public void eliminarMaximo(){
        NodoABB auxiliar, padreAux;
        padreAux = raiz;
        if (raiz != null){
            auxiliar = raiz.getDerecho();
            //Si la raiz no tiene hijos la eliminamos
            if (auxiliar == null){
                raiz = null;
            }
            else{
                //Nos dirigimos hacia la derecha usando un auxiliar y su padre para encontrar el maximo
                while (auxiliar.getDerecho() != null){
                    padreAux = auxiliar;
                    auxiliar = auxiliar.getDerecho();
                }           
                //Encontrado el maximo debemos borrarlo
                //Si el maximo tiene un hijo izquierdo lo colocamos como hijo derecho del padre del maximo
                if (auxiliar.getIzquierdo() != null){
                    padreAux.setDerecho(auxiliar.getIzquierdo());
                }
                //Si el maximo es hoja, borramos el enlace con su padre
                else{
                    padreAux.setDerecho(null);
                }
            }
        }
    }
    public Comparable minimoElem(){
        Comparable res;
        NodoABB auxiliar;
        auxiliar = raiz;
        while (auxiliar.getIzquierdo() != null){
            auxiliar = auxiliar.getIzquierdo();
        }
        res = auxiliar.getElemento();
        return res;
    }
    public Comparable maximoElem(){
        Comparable res;
        NodoABB auxiliar;
        auxiliar = raiz;
        while (auxiliar.getDerecho() != null){
            auxiliar = auxiliar.getDerecho();
        }
        res = auxiliar.getElemento();
        return res;
    }
    public Lista listar(){
        Lista ls;
        ls = new Lista();
        listarAux(raiz,ls);
        return ls;
    }
    private void listarAux(NodoABB n, Lista arbol){
        if (n != null){
            listarAux(n.getIzquierdo(),arbol);
            arbol.insertar(n.getElemento(),arbol.longitud() + 1);
            listarAux(n.getDerecho(),arbol);
        }
    }
    public boolean pertenece (Comparable elem){
        boolean esta;
        esta = perteneceAux(raiz,elem);
        return esta;
    }
    private boolean perteneceAux(NodoABB n, Comparable elem){
        boolean esta;
        esta = false;
        if (n != null){
            if (n.getElemento().equals(elem)){
                esta = true;
            }
            else{
                if (n.getElemento().compareTo(elem) < 0){
                    esta = perteneceAux(n.getIzquierdo(),elem);
                }
                else{
                    esta = perteneceAux(n.getDerecho(),elem);
                }
            }
        }
        return esta;
    }
    public boolean insertar(Comparable elem){
        boolean exito;
        exito = true;
        if (raiz == null){
            raiz = new NodoABB(elem,null,null);
        }
        else{
            exito = insertarAux(raiz,elem);
        }
        return exito;
    }
    private boolean insertarAux(NodoABB n, Comparable elem){
        boolean exito;
        exito = true;
        if (elem.compareTo(n.getElemento()) == 0){
            exito = false;
        }
        else{
            if (elem.compareTo(n.getElemento()) < 0){
                if (n.getIzquierdo() != null){
                    exito = insertarAux(n.getIzquierdo(),elem);
                }
                else{
                    n.setIzquierdo(new NodoABB(elem,null,null));
                }
            }
            else{
                if (n.getDerecho() != null){
                    exito = insertarAux(n.getDerecho(),elem);
                }
                else{
                    n.setDerecho(new NodoABB(elem,null,null));
                }
            }
        }
        return exito;
    }    
    public boolean eliminar(Comparable elem){
        boolean exito;
        exito = eliminarAux(raiz,null,elem);
        return exito;
    }
    private boolean eliminarAux(NodoABB n,NodoABB padreN,Comparable elem){
        boolean exito;
        exito = false;
        if (n != null){
            //Vemos si el elemento buscado es menor al del nodo n
            if (elem.compareTo(n.getElemento()) < 0){
                exito = eliminarAux(n.getIzquierdo(),n,elem);
            }
            else{
                //Como no es menor entonces vemos si es mayor
                if (elem.compareTo(n.getElemento()) > 0){
                    exito = eliminarAux(n.getDerecho(),n,elem);
                }
                else{
                    //Si el elemento no es menor ni mayor, significa que es igual
                    //Encontramos el nodo a eliminar, utilizamos el caso de eliminacion correspondiente
                    if (n.getDerecho() == null && n.getIzquierdo() == null){
                        eliminarHoja(padreN,n);
                        exito = true;
                    }
                    else{
                        if (n.getDerecho() == null || n.getIzquierdo() == null){
                            eliminarConUnHijo(padreN,n);
                            exito = true;
                        }
                        else{
                            eliminarConDosHijos(padreN,n);
                            exito = true;
                        }
                    }
                }
            }
        }
        return exito;
    }
    private void eliminarConDosHijos(NodoABB padre, NodoABB hijo){
        //nota: "hijo" hace referencia al parametro
        NodoABB auxiliar , padreAuxiliar;
        auxiliar = hijo.getIzquierdo();
        padreAuxiliar = hijo;
        //Buscamos el candidato que reemplazara al nodo eliminado
        //Usaremos el mayor del subarbol izquierdo
        while (auxiliar.getDerecho() != null){
            padreAuxiliar = auxiliar;
            auxiliar = auxiliar.getDerecho();
        }
        //Colocamos el elemento del nodo candidato en el nodo a eliminar
        hijo.setElemento(auxiliar.getElemento());
        //Eliminamos el candidato con el caso correspondiente
        if (auxiliar.getIzquierdo() != null){
            eliminarConUnHijo(padreAuxiliar,auxiliar);
        }
        else{
            eliminarHoja(padreAuxiliar,auxiliar);
        }
        //Colocamos el elemento del nodo candidato en el nodo a eliminar
        hijo.setElemento(auxiliar.getElemento());
    }
    private void eliminarConUnHijo(NodoABB padre, NodoABB hijo){
        //nota: "hijo" hace referencia al parametro
        //Evaluamos si el nodo a eliminar es raiz
        if (padre == null){
            //Si lo es entonces nos fijamos si el hijo de "hijo" es izquierdo o derecho y lo convertimos en la nueva raiz
            if (hijo.getDerecho() != null){
                raiz = hijo.getDerecho();
            }
            else{
                raiz = hijo.getIzquierdo();
            }
        }
        else{
            //Si no lo es entonces nos fijamos cual hijo de padre es "hijo", luego que hijo tiene "hijo" y reemplazamos el enlace correspondiente
            if (padre.getDerecho().equals(hijo)){
                if (hijo.getDerecho()!= null){
                    padre.setDerecho(hijo.getDerecho());
                }
                else{
                    padre.setDerecho(hijo.getIzquierdo());
                }
            }
            else{
                if (hijo.getDerecho() != null){
                    padre.setIzquierdo(hijo.getDerecho());
                }
                else{
                    padre.setIzquierdo(hijo.getIzquierdo());
                }
            }
        }
    }
    private void eliminarHoja(NodoABB padre, NodoABB hijo){
        //nota: "hijo" hace referencia al parametro
        //Evaluamos primero si el nodo a eliminar es raiz
        if (padre == null){
            raiz = null;
        }
        else{
            //Si no lo es entonces nos fijamos si "hijo" es hijo izquierdo o derecho de padre y eliminamos el enlace correspondiente
            if (padre.getIzquierdo() != null){
                //Si padre tiene hijo izquierdo nos fijamos si es el que debemos eliminar
                if (padre.getIzquierdo().equals(hijo)){
                    padre.setIzquierdo(null);
                }
                else{
                    //Si el hijo izquierdo no es el que se dbe eliminar, entonces es el derecho
                    padre.setDerecho(null);
                }
            }
            else{
                //Si padre no tiene hijo izquierdo entonces se debe eliminar al derecho
                padre.setDerecho(null);
            }
        }
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
                NodoABB nodoActual;
                nodoActual = (NodoABB) colaAux.obtenerFrente();
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
    //Practica para el segundo parcial 
    
    
    
    
    public Lista listarMayoresQue(Comparable valor, Comparable elem){
        Lista ls;
        NodoABB n;
        ls = new Lista();
        n = buscarNodo(raiz,elem);
        if (n != null){
            listarMayoresQueAux(n,valor,ls);
        }
        return ls;
    }
    private NodoABB buscarNodo(NodoABB n, Comparable elem){
        NodoABB res;
        res = null;
        if (n != null){
            if (n.getElemento().compareTo(elem) == 0){
                res = n;
            }
            else{
                if (elem.compareTo(n.getElemento()) > 0){
                    res = buscarNodo(n.getDerecho(),elem);
                }
                else{
                    if (elem.compareTo(n.getElemento()) < 0){
                        res = buscarNodo(n.getIzquierdo(),elem);
                    }
                }
            }
        }
        return res;
    }
    private void listarMayoresQueAux(NodoABB n, Comparable valor, Lista ls){
        if (n != null){
            if (n.getElemento().compareTo(valor) <= 0){
                listarMayoresQueAux(n.getDerecho(),valor,ls);
            }
            else{
                listarMayoresQueAux(n.getIzquierdo(),valor,ls);
                ls.insertar(n.getElemento(),ls.longitud() + 1);
                listarMayoresQueAux(n.getDerecho(),valor,ls);
            }
        }
    }
    public double diferenciaCandidatos(Comparable elemento){
        double res;
        res = diferenciaCandidatosAux(raiz,elemento);
        return res;
    }
    private double diferenciaCandidatosAux(NodoABB n, Comparable elemento){
        double res;
        res = -1;
        if (n != null){
            //Nos fijamos si n es el nodo buscado
            if (n.getElemento().compareTo(elemento) == 0){
                res = calcularDiferencia(n);
            }
            else{
                //Si el elemento buscado es menor al de n entonces buscamos por la izquierda
                if (elemento.compareTo(n.getElemento()) < 0){
                    res = diferenciaCandidatosAux(n.getIzquierdo(),elemento);
                }
                else{
                    //Si no es menor o igual entonces es mayor, buscamos por la derecha
                    res = diferenciaCandidatosAux(n.getDerecho(),elemento);
                }
            }
        }
        return res;
    }
    private double calcularDiferencia(NodoABB n){
        double res;
        res = -2;
        //Nos fijamos que los subarboles no sean nulos
        if (n.getIzquierdo() != null && n.getDerecho() != null){
            double menorEnDer, mayorEnIzq;
            NodoABB auxiliar;
            //Recorremos iterativamente para encontrar lo que buscamos en los subarboles
            //Comenzamos por el izquierdo
            auxiliar = n.getIzquierdo();
            while(auxiliar.getDerecho() != null){
                auxiliar = auxiliar.getDerecho();
            }
            mayorEnIzq = (double) auxiliar.getElemento();
            //Ahora hacemos lo opuesto para el derecho
            auxiliar = n.getDerecho();
            while (auxiliar.getIzquierdo() != null){
                auxiliar = auxiliar.getIzquierdo();
            }
            menorEnDer =(double) auxiliar.getElemento();
            //Ahora que tenemos los nodos, calculamos la diferencia
            res = menorEnDer - mayorEnIzq;
        }
        return res;
    }
}
