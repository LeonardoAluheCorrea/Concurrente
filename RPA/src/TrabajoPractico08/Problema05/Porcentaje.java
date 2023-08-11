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
public class Porcentaje {
    public static void main(String[]args){
        double porcentaje,numero;
        System.out.println("Ingrese los 2 valores");
        porcentaje=TecladoIn.readLineDouble();
        numero=TecladoIn.readLineDouble();
        System.out.println("El resultado es: "+FuncionesMatematicas.Porcentaje(porcentaje, numero));
    }
    
}
