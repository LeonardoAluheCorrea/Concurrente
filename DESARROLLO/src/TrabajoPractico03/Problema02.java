/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico03;
import Utiles.TecladoIn;
import Utiles.Arreglos;
/**
 *
 * @author Leo
 */
public class Problema02 {
    public static void main (String[]args){
        //Lee un arreglo de enteros y utiliza modulos para realizar distintas operaciones
        int []entero;
        int tamaño, num;
        System.out.println("Cuantos numeros desea ingresar?");
        tamaño = TecladoIn.readLineInt();
        entero = new int[tamaño];
        for (int i = 0; i < entero.length; i++){
            System.out.println("Ingrese un numero entero");
            entero[i] = TecladoIn.readLineInt();
        }
        switch(menu()){
            case 1:
                System.out.println("En el arreglo hay "+Arreglos.contarPares(entero)+" pares53");
                break;
            case 2: 
                System.out.println("La sumatoria de los valores del arreglo es: "+Arreglos.sumatoria(entero));
                break;
            case 3: 
                System.out.println("Ingrese el numero que desea buscar");
                num = TecladoIn.readLineInt();
                if (Arreglos.verificarValor(entero, num))
                    System.out.println("El numero "+num+" si se encuentra en el arreglo");
                else
                    System.out.println("El numero "+num+" no se encuentra en el arreglo");
                break;
            case 4:
                System.out.println("El menor numero del arreglo se encuentra en la posicion "+Arreglos.posicionMenor(entero) );
                break;
            case 5:
                System.out.println("El mayor valor del arreglo es "+Arreglos.mayorValor(entero));
                break;
            case 6:
                System.out.println("El promedio de valores del arreglo es "+Arreglos.promedioArray(entero));
                break;
            case 7:
                switch (Arreglos.promedioMitades(entero)) {
                    case 1:
                        System.out.println("La primera mitad del arreglo tiene mayor promedio");
                        break;
                    case 2:
                        System.out.println("La segunda mitad del arreglo tiene mayor promedio");
                        break;
                    default:
                        System.out.println("Los promedio de ambas mitades son iguales");
                        break;
            }
                break;

        }
    }
    
    
    public static int menu(){
        //Muestra un menu con distintas opciones y devuelve lo que el usuario eligio
        int opcion;
        System.out.println("1. Contar cuántos de los números almacenados son pares");
        System.out.println("2. Realizar la sumatoria de los valores del arreglo");
        System.out.println("3. Verificar si un número dado se encuentra en él");
        System.out.println("4. Indicar la posición del menor valor almacenado");
        System.out.println("5. Indicar el mayor valor almacenado");
        System.out.println("6. Calcular el promedio de los valores del arreglo");
        System.out.println("7. Calcular el promedio de la primera mitad del arreglo por un lado y de la segunda mitad del arreglo por otro. Luego mostrar un cartel indicando cuál de las dos mitades del arreglo tiene el mayor promedio");
        opcion = TecladoIn.readLineInt();
        return opcion;
    }
}
