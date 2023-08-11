/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoObligatorio;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Trabajo {
    
     public static String cadenaPares(String cadena) {
         //Es modulo devuelve una cadena con las palabras que se encuentran en las posiciones pares, eliminaria, por ejemplo la primera y la tercera palabra
         //cadena: Es la variable a partir de la cual formaremos una nueva cadena compuesta unicamente por las palabras en posiciones pares
        int contPal = 0;
        String palabra = "", cadenaPares = "";       
        cadena = cadena + " ";
        for (int i = 0; i < cadena.length(); i++){            
        if(Character.isLetter(cadena.charAt(i)))
            palabra = palabra + cadena.charAt(i);        
        else{
            contPal++; 
            if(contPal % 2 == 0){
                cadenaPares = cadenaPares + palabra + " ";
            }
            else
                palabra = "";
        }
        }          
    return cadenaPares;     
}

    
    public static double promLongPalabra(String cadena){
        //Este modulo calcula la longitud promedio de las palabras de una cadena de caracteres
        double promedio;
        double acuLongitud = 0, contPalabras = 0;
        for(int i = 0; i < cadena.length(); i++){
            if(Character.isLetter(cadena.charAt(i)))
                acuLongitud++;
            else
                contPalabras++;
        }
        promedio = acuLongitud/(contPalabras+1);
        return promedio;
    }
    
    public static String eliminarPalabra(String cadena, String palabra){
        //Este modulo elimina las ocurrencias de una palabra dentro de una cadena de caracteres
        //cadena: Es la cadena que reduciremos eliminando las ocurrencias de cierta palabra introducida por el usuario
        //palabra: Es la palabra que debemos eliminar dentro de "cadena"
        String cadenaSinPal;
        palabra = " " + palabra + " ";
        cadena = " " + cadena + " ";
        cadenaSinPal = cadena.replaceAll(palabra," ");
        cadenaSinPal.trim();
        return cadenaSinPal;
    }
    
    
    public static int palabraMenores(String cadena, int longitud){
        //Este modulo recibe una cadena de caracteres y cuenta la cantidad de palabras menores a cierta longitud
        //cadena: Es la cadena de caracteres a analizar
        //longitud: Es la longitud limite de las palabras, debemos contar las palabras con longitud menor a esta variable
        int longPalabra = 0, cantPalabras = 0;
        String palabra = "";
        for(int i = 0; i < cadena.length(); i++){
           if(Character.isLetter(cadena.charAt(i))){
               palabra = palabra + cadena.charAt(i);
           }
           else{
               if(palabra.length() < longitud){
                   cantPalabras++;
               }
               palabra = "";
           }          
        }
        return cantPalabras;
    }
    
    
    public static String palabraLarga(String cadena){
        //Este modulo busca la palabra mas larga en una cadena de caracteres
        //cadena: Es la cadena cuya palabra mas larga debemos encontrar
        String  palMayor = "", palabra = "";
        cadena = cadena + " ";
        for(int i = 0; i < cadena.length(); i++){
            if(Character.isLetter(cadena.charAt(i))){
                palabra = palabra + cadena.charAt(i);
            }
            else{
                if(palabra.length() > palMayor.length()){
                    palMayor = palabra;
                }                
                palabra = "";
            }
        }        
        return palMayor;
    }
    
    public static boolean letrasBlanks(String cadena){
        //Este modulo recibe una cadena de caracteres y determina si esta compuesta unicamente por letras y espacios en blanco
        //cadena: Es la cadena de caracteres que analizaremos
        boolean v = true;
        for(int i = 0; i < cadena.length(); i++){
            v = (Character.isLetter(cadena.charAt(i))) || (cadena.charAt(i) == ' ' );
            if(v == false)                
            i = cadena.length();
        }
        return v;
    }
    
    
    public static int palabraRepetida(String cadena, String palabra){
        //Modulo que recibe 2 cadenas de caracteres y cuenta cuantas veces aparece una palabra dentro de la otra cadena
        //cadena: Es la cadena de caracteres en la cual nos fijaremos cuantas veces se repite "palabra"
        //palabra: Es la cadena de caracteres que buscaremos dentro de "cadena"
        int contador = 0;
        palabra = " " + palabra + " ";
        cadena = " " + cadena + " ";
        while (cadena.indexOf(palabra) != -1) {
             cadena = cadena.substring(cadena.indexOf(palabra) + palabra.length(),cadena.length());
             contador++; 
             }
        return contador;
    }
    
    public static void menu(){
        //Este modulo es un menu con las opciones que debe elegir el usuario
        System.out.println("1: Leer una cadena y comprobar que esta compuesta por letras y espacios en blanco");
        System.out.println("2: Contar la cantidad de palabras de longitud menor a una longitud que usted designe");
        System.out.println("3: Buscar la palabra mas larga");
        System.out.println("4: Armar una nueva cadena compuesta únicamente por las palabras en las posiciones pares");
        System.out.println("5: Contar cuántas veces aparece cierta palabra ingresada por usted");
        System.out.println("6: Calcular la longitud promedio de las palabras");
        System.out.println("7: Generar una nueva cadena en la cuál se eliminaran todas las ocurrencias de una palabra que usted elija");
        System.out.println("8: Ingresar nueva cadena para analizar");
        System.out.println("9: Salir");
}
    
    
    public static void main(String[]args){
        //Este algoritmo lee una cadena de caracteres y luego le pregunta al usuario que desea realizar con ella
        int opcion, longitud;
        String cadena,palabra,cadena2;
        System.out.println("Ingrese una cadena de caracteres. Utilize solo letras y espacios en blanco");
        cadena = TecladoIn.readLine();
        cadena.toLowerCase();
        cadena.trim();
        do{
            System.out.println("Elija una opcion");
            //Usamos un modulo para presentar el menu de opciones
            menu();
            opcion = TecladoIn.readLineInt();
            switch(opcion){
                //Llamamos a los modulos corresondientes a las opciones de menu
                case 1:
                    System.out.println("Ingrese una nueva cadena");
                    cadena2 = TecladoIn.readLine();
                    cadena2.trim();
                    cadena2.toLowerCase();
                    if(letrasBlanks(cadena2))
                    System.out.println("La cadena posee solo letras y espacios en blanco");
                    else
                    System.out.println("La cadena posee caracteres que no son letras o espacios en blancos");                            
                    break;
                case 2:
                    System.out.println("Ingrese la longitud que desee");
                    longitud = TecladoIn.readLineInt();
                    System.out.println("La cantidad de palabras menores a "+longitud+" son "+palabraMenores(cadena,longitud));
                    break;
                case 3: 
                    System.out.println("La palabra mas larga es "+palabraLarga(cadena));
                    break;
                case 4:
                    System.out.println("La cadena compuesta por las palabras en las posiciones pares es la siguiente "+cadenaPares(cadena));
                    break;
                case 5:
                    System.out.println("Ingrese la palabra deseaada usando solo minusculas");
                    palabra = TecladoIn.readLineWord();
                    System.out.println("La palabra que ingreso se repite "+palabraRepetida(cadena,palabra)+" veces");
                    break;
                case 6: 
                    System.out.println("El largo promedio de las palabras es "+promLongPalabra(cadena));
                    break;
                case 7:
                    System.out.println("Ingrese la palabra deseada usando solo minusculas");
                    palabra = TecladoIn.readLine();
                    System.out.println("La cadena sin la palabra "+palabra+" es: "+eliminarPalabra(cadena,palabra));
                    break;
                case 8: 
                    System.out.println("Ingrese la nueva cadena");
                    cadena = TecladoIn.readLine();
                    cadena.trim();
                    cadena.toLowerCase();
            }
        }
        while(opcion != 9);
    }
}
