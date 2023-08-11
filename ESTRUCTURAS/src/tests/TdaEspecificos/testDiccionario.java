/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.TdaEspecificos;
import TDAEspecificos.Diccionario;
/**
 *
 * @author Leo
 */
public class testDiccionario {
    public static void main(String[]args){
        Diccionario tabla;
        tabla = new Diccionario();
        System.out.println("Insertamos 15. Debe dar true --> " + tabla.insertar(15,15));
        System.out.println("Arbol -->\n " + tabla.toString());
        System.out.println("\n");
        System.out.println("Insertamos 11. Debe dar true --> " + tabla.insertar(11,11));
        System.out.println("Arbol -->\n " + tabla.toString());
        System.out.println("\n");
        System.out.println("Insertamos 23. Debe dar true --> " + tabla.insertar(23,23));
        System.out.println("Arbol -->\n" + tabla.toString());
        System.out.println("\n");
        System.out.println("Insertamos 2. Debe dar true --> " + tabla.insertar(2,2));
        System.out.println("Arbol -->\n" + tabla.toString());
        System.out.println("\n");
        System.out.println("Insertamos 13. Debe dar true --> " + tabla.insertar(13,13));
        System.out.println("Arbol -->\n" + tabla.toString());
        System.out.println("\n");
        System.out.println("Insertamos 12. Debe dar true --> " + tabla.insertar(12,12));
        System.out.println("Arbol -->\n" + tabla.toString());
        System.out.println("\n");
        System.out.println("Insertamos 22. Debe dar true --> " + tabla.insertar(22,22));
        System.out.println("Arbol -->\n" + tabla.toString());
        System.out.println("\n");
        System.out.println("Insertamos 20. Debe dar true --> " + tabla.insertar(20,20));
        System.out.println("Arbol -->\n" + tabla.toString());
        System.out.println("\n");
        tabla.insertar(34,34);
                tabla.insertar(67,67);
                tabla.insertar(62,62);
                tabla.insertar(14,14);
                tabla.insertar(25,25);
                tabla.insertar(46,46);
                tabla.insertar(34,34);
                tabla.insertar(63,63);
                tabla.insertar(37,37);
        System.out.println(tabla.toString());        
        System.out.println("Eliminamos 2. Debe dar true --> " + tabla.eliminar(2));
        System.out.println("Arbol -->\n" + tabla.toString());
        System.out.println("\n");
        System.out.println("Eliminamos 12. Debe dar true --> " + tabla.eliminar(12));
        System.out.println("Arbol -->\n" + tabla.toString());
        System.out.println("\n");
        System.out.println("Eliminamos 15. Debe dar true --> " + tabla.eliminar(15));
        System.out.println("Arbol -->\n" + tabla.toString());
        System.out.println("\n");
        System.out.println("Eliminamos 11. Debe dar true --> " + tabla.eliminar(11));
        System.out.println("Arbol -->\n" + tabla.toString());
        System.out.println("\n");
        System.out.println("Eliminamos 23. Debe dar true --> " + tabla.eliminar(23));
        System.out.println("Arbol -->\n" + tabla.toString());
        System.out.println("\n");
    }
}
