/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPractico4;
import Utiles.TecladoIn;
/**
 *
 * @author Leo
 */
public class Problema06 {
    public static void main(String[]args){
        //Este algoritmo convierte kilometro a metros y centimetro
        //Declaramos las varibles
        double kilometros, centimetros, metros;
        System.out.println("Ingrese kilometros:");
        kilometros=TecladoIn.readLineDouble();
        metros=kilometros*1000;
        centimetros=metros*100;
        System.out.println("Son "+metros+" metros y "+centimetros+" centimetros");
                
                
    
}}
