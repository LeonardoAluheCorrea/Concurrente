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
public class Problema01 {
    
  
    
    public static void menu(){
            //Presenta un menu con opciones para el usuario y retorna la elegida por el
            System.out.println("1. Mostrar las posiciones pares del arreglo");
            System.out.println("2. Mostrar el arreglo invertido");
            System.out.println("3. Mostrar las ocurrencias de un caracter dado");
            System.out.println("Para salir ingresar cualquier otro numero ");
        }
    
    public static void main (String[]args){
        //Verifica que un arreglo este hecho de solo caracteres y utiliza modulos para realizar otras operaciones con arreglos
        char[]letra;
        char caracter;
        int tamaño, opcion;       
        System.out.println("Ingrese cuantos caracteres tendra el arreglo");
        tamaño = TecladoIn.readLineInt();
        letra = new char[tamaño];
        for (int i = 0; i < letra.length; i++){
            System.out.println("Ingrese un caracter");
            letra[i] = TecladoIn.readNonwhiteChar();
            while (!Character.isLetter(letra[i])){
                System.out.println("Lo que ha ingresado no es un caracter. Reingrese un caracter");
                letra[i] = TecladoIn.readNonwhiteChar();
            }
        }
        do{
            menu();
            opcion = TecladoIn.readLineInt();
            switch (opcion){
                case 1:
                    Arreglos.paresArrays(letra);
                    break;
                case 2:
                    Arreglos.invertir(letra);
                    break;
                case 3: 
                    System.out.println("Ingrese el caracter cuyas ocurrencias desea contar");
                    caracter = TecladoIn.readNonwhiteChar();
                    System.out.println("Las ocurrencias de "+caracter+" son "+Arreglos.ocurrencias(letra,caracter));
                    break;
            }        
        }
        while (opcion < 4 || opcion > 0);
    }                        
}
