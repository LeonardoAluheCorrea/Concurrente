/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parcial2Tema4;

/**
 *
 * @author Leo
 */
public class Main1 {
    public static void main(String[]args){
        Thread t1, t2, t3;
        Costurera taller = new Costurera(10,10); //primer para metro es maxMangas y segundo es maxCuerpos
        t1 = new Thread(new Empleado(taller,1));
        t2 = new Thread(new Empleado(taller,2));
        t3 = new Thread(new Empleado(taller,3));
        t1.start();
        t2.start();
        t3.start();
    }
}
