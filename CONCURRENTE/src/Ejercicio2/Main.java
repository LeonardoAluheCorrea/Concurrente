/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Leo
 */
public class Main {
    public static void main(String []args){
        Thread[] personas;
        GestorSala gestor;
        Thread ter;
        gestor = new GestorSala();
        ter = new Thread(new Termometro(gestor));
        
        personas = new Thread[60];
        //Creamos los hilos no jubilados
        for (int i = 0; i < 40; i++){
            personas[i] = new Thread(new Persona (false, gestor, i));
        }
        //Creamos los hilos jubilados
        for (int i = 40; i < 60; i++){
            personas[i] = new Thread(new Persona(true, gestor, i));
        }
        for (int i = 0; i < 60; i++){
            personas[i].start();
        }
        ter.start();
    }
}
