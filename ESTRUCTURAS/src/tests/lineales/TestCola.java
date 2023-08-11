/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.lineales;
import lineales.dinamicas.Cola;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class TestCola {
    public static void main (String[]args){
        Cola cola;
        boolean continuar;
        continuar = true;
        cola = new Cola();
        while (continuar){
            switch (menu()){
                case 1:
                    añadirElemento(cola);
                    break;
                case 2:
                    quitarElemento(cola);
                    break;
                case 3:
                    System.out.println("El frente de la cola es: "+cola.obtenerFrente());       
                    break;
                case 4:
                    verificarVacia(cola);
                    break;
                case 5:
                    vaciar(cola);
                    break;
                case 6:  
                    copiar(cola);
                    break;
                case 7:
                    System.out.println(cola.toString());
                    break;
                case 8:    
                    continuar = false;
            }
        }
    }
    
    public static void copiar (Cola cola){
        Cola copia;
        copia = cola.clone();
        System.out.println("Cola original: "+cola.toString());
        System.out.println("Cola copiada: "+copia.toString());
    }
    
    public static void vaciar (Cola cola){
        cola.vaciar();
        if (cola.esVacia())
            System.out.println("La cola se vacio exitosamente");
        else{
            System.out.println("La cola no se vacio correctamente");
            System.out.println(cola.toString());
        }
    }
    
    public static void verificarVacia (Cola cola){
        if (cola.esVacia())
            System.out.println("La cola esta vacia");
        else{
            System.out.println("La cola no esta vacia");
            System.out.println(cola.toString());
        }
    }
    
    public static void quitarElemento (Cola cola){
        if (cola.sacar())
            System.out.println("El elemento se quito exitosamente");
        else
            System.out.println("El elemento no se pudo quitar");
    }
    
    public static void añadirElemento (Cola cola){
        Object elemento;
        boolean llena;
        int cantidad, i;
        llena = true;
        i = 0;
        System.out.println("Ingrese la cantidad de elementos que desea añadir a la cola. Max = 4");
        cantidad = TecladoIn.readLineInt();
        while (llena && i < cantidad){
            System.out.println("Ingrese un numero entero");
            llena = cola.poner(TecladoIn.readLineInt());
            if (!llena)
                System.out.println("La cola esta llena, el ultimo numero no se pudo añadir");
            i++;
        }
    }
    
    public static int menu (){
        int opcion;
        System.out.println("1. Anadir un elemento a la cola");
        System.out.println("2. Quitar un elemento de la cola");
        System.out.println("3. Obtener el elemento al frente de la cola");
        System.out.println("4. Comprobar si la cola esta vacia");
        System.out.println("5. Vaciar la cola y asegurarse que quedo vacia");
        System.out.println("6. Clonar la cola");
        System.out.println("7. Listar los elementos de la cola");
        System.out.println("8. Salir");
        opcion = TecladoIn.readLineInt();
        return opcion;
    }
}
