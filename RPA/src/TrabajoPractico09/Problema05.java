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
public class Problema05 {
    public static void main(String[]args){
        int n,numero,mayor;
        mayor=0;
        System.out.println("Ingresar cuantos numeros desea evaluar");
        n=TecladoIn.readLineInt();
        for(int i=0;i<n;i++){
            System.out.println("Ingrese el numero");
            numero=TecladoIn.readLineInt();
            if(i==0){
               mayor=numero;   
            }
            else{
                if(numero>mayor){
                    mayor=numero;
                }
            }
        }
        System.out.println("El numero mayor es: "+mayor);
    }
}
