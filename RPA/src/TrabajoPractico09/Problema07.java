/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico09;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema07 {
    public static int ultimaCifraInt(int numero){
        int ultCifra;
        ultCifra=numero%10;
        return ultCifra;
    }
    public static double primerCifraInt(int numero){
        int cifras=0;
        double priCifra;
        while(numero!=0){
            numero=numero/10;
            cifras++;
        }
        priCifra=(int)numero/(Math.pow(10,cifras-1));
        return priCifra;
    }
    public static int contadorCifras(int numero){
        int cifras=0;
        while(numero!=0){
            numero=numero/10;
            cifras++;
        }
        return cifras;
    }
    
    
    public static void main(String[]args){
        int numero,inverso,resto,faltante;
        char continuar;
        do{
        System.out.println("Ingrese un numero entero");
        numero=TecladoIn.readLineInt();
        inverso=0;
        faltante=numero;
        while(faltante!=0){
            resto=faltante%10;
            inverso=inverso*10+resto;
            faltante=faltante/10;
        }
        if(inverso==numero){
            System.out.println("El numero es capicua");
    }
        else{
            System.out.println("El numero no es capicua");
        }
        System.out.println("Desea ingresar otro numero? s/n");
        continuar=TecladoIn.readNonwhiteChar();
        }
        while(continuar=='s');
    }
    
}
