/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;
/**
 *
 * @author Leo
 */
public class TestCadenas {
    public static Cola generar(Cola c1){
        //Precondicion: c1 tiene el formato a1#a2#...#an, donde ai es una cadena de letras mayusculas
        Cola res, clon, aux2;
        Pila aux;
        aux2 = new Cola();
        aux = new Pila();
        clon = c1.clone();
        res = new Cola();
        //Usamos un while para recorrer el clon hasta que quede vacio
        while(!clon.esVacia()){
            Object elem;
            elem = clon.obtenerFrente();
            //Usamos otro while para cargar la cadena en la cola res
            while (elem != null && !elem.equals('#')){
                res.poner(elem);
                //Cargamos la cadena en una pila, para luego obtener la inversa
                aux.apilar(elem);
                //Cargamos la cadena en otra cola para tenerla guardada
                aux2.poner(elem);
                clon.sacar();
                elem = clon.obtenerFrente();
            }
            //Quitamos el # de la cola clon
            clon.sacar();
            //Ahora cargamos los elementos de la pila en la cola res
            //Asi tendremos la cadena seguida de su inversa
            elem = aux.obtenerTope();
            while (elem != null){
                res.poner(elem);
                aux.desapilar();
                elem = aux.obtenerTope();
            }
            //Cargamos en la cola resultado los elementos de la cola auxiliar
            //Asi tendremos la cadena, seguida de su inversa, seguida de si misma
            elem = aux2.obtenerFrente();
            while (elem != null){
                res.poner(elem);
                aux2.sacar();
                elem = aux2.obtenerFrente();
            }
            //Por ultimo cargamos en la cola resultado el #
            res.poner('#');
        }
        return res;
    }
    
    public static boolean esApertura(Object n){
        boolean res;
        res = n.equals('{') || n.equals('[') || n.equals('(');
        return res;
    }
    public static boolean esCierre(Object n){
        boolean res;
        res = n.equals(')') || n.equals(']') || n.equals(')');
        return res;
    }
    public static boolean cierraA(Object cierre, Object apertura){
        boolean res;
        res = (apertura.equals('(') && cierre.equals(')')) ||
              (apertura.equals('{') && cierre.equals('}')) ||
              (apertura.equals('[') && cierre.equals(']'));
        return res;
    }
    public static boolean verificarBalanceo(Cola q){
        boolean continuar;
        Object elem;
        Cola clon;
        Pila aux;
        aux = new Pila();
        clon = q.clone();
        continuar = true;
        //Usamos un while para recorrer la cola con la expresion matematica
        while(!clon.esVacia() && continuar){
            elem = clon.obtenerFrente();
            //Si el elemento que encontramos es uno de apertura ({,[,( ) entonces lo cargamos la pila auxiliar
            if (esApertura(elem)){
                aux.apilar(elem);
            }
            else{
                //Si el elemento es de cierre (],),}) entonces nos fijamos si cierra al elemento en el tope de la pila
                if (esCierre(elem)){
                    continuar = cierraA(elem,aux.obtenerTope());
                    //Como ya encontramos el elemento que ciera al tope de la cola, lo quitamos
                    aux.desapilar();
                }
                //Si cierra el elemento en el tope de la pila entonces continuamos 
                //Si no lo hace entonces tenemos un signo de apertura sin cerrar correctamente y ya podemos decir que la expresion esta mal balanceada
            }
            //Por ultimo sacamos un elemento de la cola
            clon.sacar();
        }
        return continuar;
    }
}
