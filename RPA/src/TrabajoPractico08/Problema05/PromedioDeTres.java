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
public class PromedioDeTres {
    public static void main(String[]args){
        double numero1,numero2,numero3;
        System.out.println("Ingrese 3 valores");
        numero1=TecladoIn.readLineDouble();
        numero2=TecladoIn.readLineDouble();
        numero3=TecladoIn.readLineDouble();
        System.out.println("El resultado es: "+FuncionesMatematicas.PromedioEntreTres(numero1, numero2, numero3));
    }
    
}
