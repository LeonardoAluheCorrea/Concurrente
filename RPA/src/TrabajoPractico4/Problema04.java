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
public class Problema04 {
    public static void main(String[]args){
    // Algoritmo que calcula el edulcorante necesario para cieta cantidad de tazas de cafe
System.out.println("Este algoritmo lo ayudara a calcular el edulcorante necesario para cierta cantidad de tazas de cafe");
int tazas,gotasTotal,cantidadGotasPorTaza;
    cantidadGotasPorTaza=8;
            System.out.println("Ingrese la cantidad de tazas:");
            tazas=TecladoIn.readLineInt();
             gotasTotal=tazas*cantidadGotasPorTaza;
             System.out.print("necesitara:");
             System.out.println(gotasTotal);
             
             
    }}
