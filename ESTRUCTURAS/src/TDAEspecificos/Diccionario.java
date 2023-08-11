/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAEspecificos;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 *
 * @author Leo
 */
public class Diccionario {
    private NodoAVLDicc raiz;

    public Diccionario() {
        raiz = null;
    }
    
    public boolean esVacio(){
        return raiz == null;
    }
    
    public Lista listarRango(Comparable min, Comparable max){
        Lista intervalo;
        intervalo = new Lista();
        listarRangoAux(raiz,min,max,intervalo);
        return intervalo;
    }
    private void listarRangoAux(NodoAVLDicc n, Comparable min, Comparable max, Lista ls){
        if (n != null){
            boolean menor, mayor, igual;
            igual = n.getClave().compareTo(min) == 0 || n.getClave().compareTo(max) == 0;
            mayor = n.getClave().compareTo(min) > 0;
            menor = n.getClave().compareTo(max) < 0;
                if (mayor){
                    listarRangoAux(n.getIzquierdo(),min,max,ls);
                }
                if ((mayor && menor) || igual){
                    ls.insertar(n.getClave(),ls.longitud() + 1);
                }
                if (menor){
                    listarRangoAux(n.getDerecho(),min,max,ls);
                }
        }
    }

    
    public boolean pertenece (Comparable clave){
        boolean esta;
        esta = perteneceAux(raiz, clave);
        return esta;
    }
    private boolean perteneceAux(NodoAVLDicc n, Comparable clave){
        boolean esta;
        esta = false;
        if (n != null){
            //Nos fijamos si la clave en el nodo n es la que buscamos
            if (n.getClave().compareTo(clave) == 0){
                esta = true;
            }
            else{
                //Nos fijamos si la clave que buscamos es menor a la del nodo n
                if (clave.compareTo(n.getClave()) < 0){
                    //Como es menor llamamamos recursivamente con el hijo izquierdo
                    esta = perteneceAux(n.getIzquierdo(),clave);
                }
                else{
                    //Ccmo la clave del nodo n no es igual ni menor a la que buscamos entonces es mayor
                    //Como es mayor llamamamos recursivamente con el hijo derecho
                    esta = perteneceAux(n.getDerecho(),clave);
                }
            }
        }
        return esta;
    }
    
    public Object obtenerInformacion(Comparable clave){
        //Nos devuelve el objeto asociado a clave
        Object buscado;
        buscado = obtenerInformacionAux(raiz, clave);
        return buscado;
    }
    
    private Object obtenerInformacionAux(NodoAVLDicc n, Comparable clave){
        Object res;
        res = null;
        if (n != null){
            //Nos fijamos si el nodo n contiene la clave que buscamos
            if (clave.compareTo(n.getClave()) == 0){
                //Si es igual entonces devolvemos el objeto asociado
                res = n.getDato();
            }
            else{
                //Nos fijamos si clave es menor que la clave del nodo n
                if (clave.compareTo(n.getClave()) < 0){
                    //Si lo es entoncea llamamos recursivamente con el hijo izquierdo
                    res = obtenerInformacionAux(n.getIzquierdo(),clave);
                }
                else{
                    //Si clave no es menor ni igual a la clave del nodo n entonces es mayor
                    res = obtenerInformacionAux(n.getDerecho(),clave);
                }
            }
        }
        return res;
    }
    
    public boolean eliminar(Comparable elem){
        boolean exito;
        exito = eliminarAux(raiz,null,elem);
        return exito;
    }
    
    private boolean eliminarAux(NodoAVLDicc n,NodoAVLDicc padreN,Comparable elem){
        boolean exito;
        exito = false;
        if (n != null){
            //Vemos si el elemento buscado es menor al del nodo n
            if (elem.compareTo(n.getClave()) < 0){
                exito = eliminarAux(n.getIzquierdo(),n,elem);
                //Caso especial: el pivote de la rotacion es raiz. Debemos definir la nueva raiz
                if(n.equals(raiz)){
                    raiz = balancear(n);
                }
                //Caso general: el pivote no es raiz. Debemos conectar la raiz del nuevo arbol con su padre
                else{
                    if (padreN.getDerecho().equals(n)){
                        padreN.setDerecho(balancear(n));
                    }
                    else{
                        padreN.setIzquierdo(balancear(n));
                    }
                }
            }
            else{
                //Como no es menor entonces vemos si es mayor
                if (elem.compareTo(n.getClave()) > 0){
                    exito = eliminarAux(n.getDerecho(),n,elem);
                    //Caso especial: el pivote de la rotacion es raiz. Debemos definir la nueva raiz
                    if(n.equals(raiz)){
                        raiz = balancear(n);
                    }
                    //Caso general: el pivote no es raiz. Debemos conectar la raiz del nuevo arbol con su padre
                    else{
                        if (padreN.getDerecho().equals(n)){
                            padreN.setDerecho(balancear(n));
                        }
                        else{
                            padreN.setIzquierdo(balancear(n));
                        }
                    }
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
     
    private void eliminarConDosHijos(NodoAVLDicc padre, NodoAVLDicc hijo){
        //nota: "hijo" hace referencia al parametro
        NodoAVLDicc auxiliar , padreAuxiliar;
        auxiliar = hijo.getIzquierdo();
        padreAuxiliar = hijo;
        //Buscamos el candidato que reemplazara al nodo eliminado
        //Usaremos el mayor del subarbol izquierdo
        while (auxiliar.getDerecho() != null){
            padreAuxiliar = auxiliar;
            auxiliar = auxiliar.getDerecho();
        }
        //Colocamos el elemento del nodo candidato en el nodo a eliminar
        hijo.setClave(auxiliar.getClave());
        //Eliminamos el candidato con el caso correspondiente
        if (auxiliar.getIzquierdo() != null){
            eliminarConUnHijo(padreAuxiliar,auxiliar);
        }
        else{
            eliminarHoja(padreAuxiliar,auxiliar);
        }
        //Colocamos el elemento del nodo candidato en el nodo a eliminar
        hijo.setClave(auxiliar.getClave());
    }
    private void eliminarConUnHijo(NodoAVLDicc padre, NodoAVLDicc hijo){
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
    private void eliminarHoja(NodoAVLDicc padre, NodoAVLDicc hijo){
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
    
    
public boolean insertar(Comparable clave,Object dato){
        boolean exito;
        exito = true;
        if (raiz == null){
            raiz = new NodoAVLDicc(clave,dato,null,null);
        }
        else{
            exito = insertarAux(raiz,raiz,clave,dato);
        }
        return exito;
    }
    
    private boolean insertarAux(NodoAVLDicc n, NodoAVLDicc padreN, Comparable clave, Object dato){
        boolean exito;
        exito = true;
        //Si el elemento es igual al del nodo n la insercion falla
        if (clave.compareTo(n.getClave()) == 0){
            exito = false;
        }
        else{
            //Si no entonces nos fijamos si el elemento en menor que el del nodo n
            if (clave.compareTo(n.getClave()) < 0){
                //Si lo es entonces nos fijamos si n tiene HI
                //Si tiene HI entonces llamamos recursivamente con ese HI
                if (n.getIzquierdo() != null){
                    exito = insertarAux(n.getIzquierdo(),n,clave,dato);
                    //A la vuelta de la recusrion actualizamos la altura y balanceamos
                    padreN.recalcularAltura();
                    //Caso especial: el pivote de la rotacion es raiz. Debemos definir la nueva raiz
                    if(n.equals(raiz)){
                        raiz = balancear(n);
                    }
                    //Caso general: el pivote no es raiz. Debemos conectar la raiz del nuevo arbol con su padre
                    else{
                        if (padreN.getDerecho().equals(n)){
                            padreN.setDerecho(balancear(n));
                        }
                        else{
                            padreN.setIzquierdo(balancear(n));
                        }
                    }
                }
                //Si no tiene HI entonces aca debemos insertar el nuevo elemento
                else{
                    n.setIzquierdo(new NodoAVLDicc(clave,dato,null,null));
                    padreN.recalcularAltura();
                }
            }
            else{
                //Si el elemento no es menor o igual al del nodo n entonces es mayor
                //Realizamos un proceso similar al que se hace si el elemento es menor al del nodo n, en cambio utilizando el hijo derecho
                if (n.getDerecho() != null){
                    exito = insertarAux(n.getDerecho(),n,clave,dato);
                    padreN.recalcularAltura();
                    //Caso especial: el pivote de la rotacion es raiz. Debemos definir la nueva raiz
                    if (n.equals(raiz)){
                        raiz = balancear(n);
                    }
                    //Caso general: el pivote no es raiz. Debemos conectar la raiz del nuevo arbol con su padre
                    else{
                        if (padreN.getDerecho().equals(n)){
                            padreN.setDerecho(balancear(n));
                        }
                        else{
                            padreN.setIzquierdo(balancear(n));
                        }
                    }
                }
                else{
                    n.setDerecho(new NodoAVLDicc(clave,dato,null,null));
                    padreN.recalcularAltura();
                }
            }
        }
        return exito;
    } 
    
    private NodoAVLDicc balancear(NodoAVLDicc n){
        int balance, altDer, altIz;
        NodoAVLDicc nuevaRaiz;
        nuevaRaiz = n;
        //Calculamos el balance del nodo n
        balance = n.calcularBalance();
        //Nos fijamos si esta balanceado
        if (Math.abs(balance) >= 2){
            //Si no lo esta, buscamos el caso de balanceo correcto
            if (balance == 2){
                //Calculamos el balance del hijo izquierdo de n
                balance = n.getIzquierdo().calcularBalance();
                //Aplicamos la rotacion correspondiente
                if (balance == 1 || balance == 0){
                    nuevaRaiz = rotarDerecha(n);
                }
                if (balance == -1){
                    nuevaRaiz = rotarIzquierdaDerecha(n);
                }
            }
            if (balance == -2){
                //Calculamos el balance del hijo derecho de n        
                balance = n.getDerecho().calcularBalance();
                if (balance == -1 || balance == 0){
                    nuevaRaiz = rotarIzquierda(n);
                }
                if (balance == 1){
                    nuevaRaiz = rotarDerechaIzquierda(n);
                }
            }
        }
        return nuevaRaiz;
    }
    private NodoAVLDicc rotarIzquierda(NodoAVLDicc n){
        NodoAVLDicc h,temp;
        h = n.getDerecho();
        temp = h.getIzquierdo();
        h.setIzquierdo(n);
        n.setDerecho(temp);
        return h;
    }
    private NodoAVLDicc rotarDerecha(NodoAVLDicc n){
        NodoAVLDicc h, temp;
        h = n.getIzquierdo();
        temp = h.getDerecho();
        h.setDerecho(n);
        n.setIzquierdo(temp);
        return h;
    }
    private NodoAVLDicc rotarDerechaIzquierda(NodoAVLDicc n){
        NodoAVLDicc hijo,res;
        //En la variable hijo colocamos el subarbol derecho de n, rotado a la derecha
        hijo = rotarDerecha(n.getDerecho());
        n.setDerecho(hijo);
        //En la variable res colocamos la raiz del nuevo arbol balanceado
        res = rotarIzquierda(n);
        return res;
    }
    private NodoAVLDicc rotarIzquierdaDerecha(NodoAVLDicc n){
        NodoAVLDicc hijo, res;
        //En la variable hijo colocamos el subarbol izquierdo de n rotado a la izquierda
        hijo = rotarIzquierda(n.getIzquierdo());
        n.setIzquierdo(hijo);
        //En la variable res colocamos la raiz del nuevo arbol balanceado
        res = rotarDerecha(n);
        return res;
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
                NodoAVLDicc nodoActual;
                nodoActual = (NodoAVLDicc) colaAux.obtenerFrente();
                colaAux.sacar();
                res = res + "P: " + nodoActual.getDato().toString();
                if (nodoActual.getIzquierdo() != null){
                    res = res + "      HI: " + nodoActual.getIzquierdo().getDato().toString();
                    colaAux.poner(nodoActual.getIzquierdo());
                }
                if (nodoActual.getDerecho() != null){
                    res = res + "      HD: " + nodoActual.getDerecho().getDato().toString();
                    colaAux.poner(nodoActual.getDerecho());
                }
                res = res + "\n";
            }
        }
        return res;
    }
}
