/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoSincronizacion;

import TrabajoPracticoSincronizacion.Objetos.Auto;
import TrabajoPracticoSincronizacion.Objetos.SurtidorNafta;
import TrabajoPracticoSincronizacion.Objetos.ViajeAuto;

/**
 *
 * @author Leo
 */
public class Ejercicio4 {
    public static void main(String[]args){
        Auto auto1, auto2, auto3, auto4, auto5;
        SurtidorNafta estacion;
        ViajeAuto viaje1, viaje2, viaje3, viaje4, viaje5;
        Thread t1, t2, t3, t4, t5;
        auto1 = new Auto("A",100);
        auto2 = new Auto("B",200);
        auto3 = new Auto("C",150);
        auto4 = new Auto("D",90);
        auto5 = new Auto("E",80);
        estacion = new SurtidorNafta();
        viaje1 = new ViajeAuto(auto1, estacion, 5);
        viaje2 = new ViajeAuto(auto2, estacion, 3);
        viaje3 = new ViajeAuto(auto3, estacion, 6);
        viaje4 = new ViajeAuto(auto4, estacion, 9);
        viaje5 = new ViajeAuto(auto5, estacion, 2);
        t1 = new Thread(viaje1);
        t2 = new Thread(viaje2);
        t3 = new Thread(viaje3);
        t4 = new Thread(viaje4);
        t5 = new Thread(viaje5);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
