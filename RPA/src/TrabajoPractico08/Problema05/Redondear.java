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
public class Redondear {
    public static void main(String[]args){
        double numero;
        System.out.println("Ingrese un numero con coma");
        numero=TecladoIn.readLineDouble();
        System.out.println("El numero redondeado es: "+FuncionesMatematicas.Redondear(numero));
    }
    
}
