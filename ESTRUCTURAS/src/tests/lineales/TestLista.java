/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;
import Utiles.TecladoIn;
import lineales.dinamicas.Lista;
/**
 *
 * @author Leo
 */
public class TestLista {
    public static void main(String[]args){
        boolean continuar;
        Lista lista;
        lista = new Lista();
        continuar = true;
        while (continuar){
            switch (menu()){
                case 1:
                    añadirElemento(lista);
                    break;
                case 2:
                    quitarElemento(lista);
                    break;
                case 3:
                    recuperarElemento(lista);
                    break;
                case 4:
                    localizarElemento(lista);
                    break;
                case 5:
                    vacio(lista);
                    break;
                case 6:
                    clon(lista);
                    break;
                case 7:
                    System.out.println(lista.toString());
                    break;
                case 8:
                    System.out.println("Ingrese el numero deseado. >= 1");;
                    System.out.println(lista.obtenerMultiplos(TecladoIn.readLineInt()).toString());
                    break;
                case 9:
                    continuar = false;
                    break;
            }
        }
    }
    
    public static void clon (Lista lista){
        Lista copia;
        copia = lista.clone();
        System.out.println("Lista original: " + lista.toString());
        System.out.println("Copia: " + copia.toString());
    }
    
    public static void vacio (Lista lista){
        if (lista.esVacia())
            System.out.println("La lista se encuentra vacia");
        else
            System.out.println("La lista no esta vacia");
        System.out.println(lista.toString());
    }
    
    public static void localizarElemento (Lista lista){
        int i;
        System.out.println("Ingrese el numero entero que desea localizar");
        i = TecladoIn.readLineInt();
        System.out.println("La primera ocurrencia de " + i + " en la lista es en la posicion " + lista.localizar(i));
        System.out.println("Si el elemento esta en la posicion -1 significa que no se encuentra en la lista");
        System.out.println(lista.toString());
    }
    
    public static void recuperarElemento (Lista lista){
        int pos;
        System.out.println("Ingrese la posicion cuyo elemento desea recuperar");
        pos = TecladoIn.readLineInt();
        System.out.println("El elemento en la posicion " + pos + " es " + lista.recuperar(pos));
        System.out.println(lista.toString());
    }
    
    public static void quitarElemento (Lista lista){
        int pos, n, elemento;
        n = lista.longitud();
        System.out.println("Ingrese la posicion de la cual desea quitar un elemento");
        pos = TecladoIn.readLineInt();
        System.out.println("Lista sin cambios: " + lista.toString());
        if (!lista.eliminar(pos)){
            System.out.println("La posicion pedida es invalida o la lista ya esta vacia, no se ha podido eliminar el elemento");
        }
            System.out.println("Lista con posicion eliminada (si se elimino alguna): " + lista.toString());
    }
    
    public static void añadirElemento (Lista lista){
        int pos, n, elemento;
        n = lista.longitud();
        pos = 1;
        System.out.println("Ingrese un numero entero para insertar en la lista");     
        elemento = TecladoIn.readLineInt();
        System.out.println("Ingrese la posicion donde desea insertarlo");
        System.out.println("La posiciones disponibles son las que van de 1 a " + (lista.longitud()+1));
        pos = TecladoIn.readLineInt();
        System.out.println("Lista sin cambios: " + lista.toString());
        if (!lista.insertar(elemento, pos)){
            System.out.println("La posicion pedida es invalida, no se ha podido añadir el elemento");
        }
        System.out.println("Lista con nuevo elemento (si se añadio uno): " + lista.toString());
    }
     
    public static int menu (){
        int opcion;
        System.out.println("1. Ingresar un elemento a la lista");
        System.out.println("2. Eliminar un elemento de la lista");
        System.out.println("3. Recuperar el elemento en cierta posicion");
        System.out.println("4. Localizar la posicion  de cierto elemento ");
        System.out.println("5. Comprobar si la lista esta vacia");
        System.out.println("6. Clonar la lista");
        System.out.println("7. Listar los elementos de la lista");
        System.out.println("8. Usar obtenerMultiplos");
        System.out.println("9. Salir");
        opcion = TecladoIn.readLineInt();
        return opcion;
    }
}
