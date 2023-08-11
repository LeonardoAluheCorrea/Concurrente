/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorreaFai2581recu;

/**
 *
 * @author Leo
 */
public class Main2 {
    public static void main(String []args){
        Rio r = new Rio();
        Thread[] lobo = new Thread[10];
        Thread[] cordero = new Thread[10];
        for (int i = 0; i < 10; i++){
            lobo[i] = new Thread(new Lobo(r));
            lobo[i].start();
        }
        for (int i = 0; i < 10; i++){
            cordero[i] = new Thread(new Cordero(r));
            cordero[i].start();
        }
    }
}
