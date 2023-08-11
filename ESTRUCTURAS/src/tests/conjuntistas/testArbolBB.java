/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.conjuntistas;
import conjuntistas.ArbolBB;
/**
 *
 * @author Leo
 */
public class testArbolBB {

public static void main(String[] args) {
    ArbolBB arbol, arbol2;
    arbol = new ArbolBB();
    arbol2 = new ArbolBB();
    System.out.println("Insertamos 5 primero");
    System.out.println("true --> " + arbol.insertar(5));
    System.out.println("Probamos eliminar minimo y luego maximo");
    arbol.eliminarMinimo();
    System.out.println("Debe dar: Arbol vacio --> " + arbol.toString());
    System.out.println("Reinsertamos el 5 y probamos borrando maximo");
    arbol.insertar(5);
    arbol.eliminarMaximo();
    System.out.println("Debe dar: Arbol vacio --> " + arbol.toString());
    System.out.println("Reinsertamos 5");
    arbol.insertar(5);
    System.out.println("Insertamos 1, debe quedar como hijo izquierdo de 5");
    System.out.println("true --> " + arbol.insertar(1));
    System.out.println("Insertamos 4, debe quedar como hijo derecho de 1");
    System.out.println("true --> " + arbol.insertar(4));
    System.out.println("Insertamos 2, debe quedar como hijo izquierdo de 4");
    System.out.println("true --> " + arbol.insertar(2));
    System.out.println("Insertamos 3, debe quedar como hijo derecho de 2");
    System.out.println("true --> " + arbol.insertar(3));
    System.out.println("Insertamos 7, debe quedar como hijo derecho de 5");
    System.out.println("true --> " + arbol.insertar(7));
    System.out.println("Insertamos 6, debe quedar como hijo izquierdo de 7");
    System.out.println("true --> " + arbol.insertar(6));
    System.out.println("Insertamos 8, debe quedar como hijo derecho de 7");
    System.out.println("true --> " + arbol.insertar(8));
    System.out.println("Insertamos 10, debe quedar como hijo derecho de 8");
    System.out.println("true --> " + arbol.insertar(10));
    System.out.println("Insertramos 9, debe quedar como hijo izquierdo de 10");
    System.out.println("true --> " + arbol.insertar(9));
    System.out.println("Insertamos un elemento que ya existe: false --> " + arbol.insertar(5));
    System.out.println("Arbol resultante: \n " + arbol.toString() + "\n \n");
    System.out.println("Probamos eliminar el minimo y maximo del arbol");
    arbol.eliminarMinimo();
    System.out.println("Arbol resultante sin el minimo(1), que tenia HD 4:\n " + arbol.toString());
    arbol.eliminarMaximo();
    System.out.println("Arbol resultante sin el maximo(10), que tenia HI 9:\n " + arbol.toString());
    System.out.println("Realizamos ambos nuevamente");
    System.out.println("Primero insertamos -1, para que el minimo ahora sea hoja");
    arbol.insertar(-1);
    System.out.println("Arbol resultante: \n" + arbol.toString());
    arbol.eliminarMinimo();
    System.out.println("Arbol resultante sin el minimo(-1), que es hoja: \n" + arbol.toString());
    arbol.eliminarMaximo();
    System.out.println("Arbol resultante sin el maximo (9), que es hoja: \n" + arbol.toString());
    System.out.println("\n \n");
    System.out.println("A continuacion probamos el metodo listar rango");
    System.out.println("Obtenemos un rango de numeros por debajo del minimo");
    System.out.println("Debe dar: lista vacia --> " + arbol.listarRango(-25,-5));
    System.out.println("Obtenemos un rango de numeros por encima del maximo");
    System.out.println("Debe dar: lista vacia --> " + arbol.listarRango(20,25));
    System.out.println("Obtenemos todos los mayores a la raiz");
    System.out.println("Debe dar: 6 , 7 , 8 --> " + arbol.listarRango(5, 10));
    System.out.println("Obtenemos todos los menores a la raiz");
    System.out.println("Debe dar: 2 , 3 , 4 --> " + arbol.listarRango(0, 5));
    System.out.println("Obtenemos algunos menores y otros mayores a la raiz");
    System.out.println("Debe dar: 3 , 4 , 5 , 6 , 7 , 8 --> " + arbol.listarRango(2,9));
    System.out.println("Obtenemos todos los numeros del arbol");
    System.out.println("Debe dar: 2 , 3 , 4 , 5 , 6 , 7 , 8 --> " + arbol.listarRango(0, 20));
    System.out.println("Buscamos intervalo en un arbol vacio");
    arbol.vaciar();
    System.out.println("Debe dar: lista vacia --> " + arbol.listarRango(1, 10));
    }
}
