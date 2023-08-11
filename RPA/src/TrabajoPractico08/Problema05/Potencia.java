/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico08.Problema05;
import Utiles.TecladoIn;
import Utiles.FuncionesMatematicas;
       
        
/**
 *
 * @author Leo
 */
public class Potencia {
    public static void main(String[]args){
        double exponente, numero;
        System.out.println("Ingrese el exponente");
        exponente=TecladoIn.readLineDouble();
                
        System.out.println("Ingrese el numero");
        numero=TecladoIn.readLineDouble();
        System.out.println("El resultado es: "+FuncionesMatematicas.Potencia(numero, exponente));
    }
    
}
