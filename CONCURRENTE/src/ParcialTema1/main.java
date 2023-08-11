/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialTema1;

/**
 *
 * @author Leo
 */
public class main {
    public static void main(String[]args) throws InterruptedException{
        Thread[] auto;
        Transbordador barco = new Transbordador();
        Thread cap = new Thread(new Capitan(barco));
        auto = new Thread[20];
        cap.start();
        for (int i = 0; i < 20; i++){
            auto[i] = new Thread(new Auto(barco));
            Thread.sleep(1000);
            auto[i].start();
        }

    }
}
