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
public class Main2 {
    public static void main(String []args){
        Comedor com;
        Thread c;
        Thread[] perro;
        com = new Comedor(4); //El parametro es la cantidad de platos
        c = new Thread(new Cuidador(com));
        int cantPerros = 6; //Cantidad de perros
        perro = new Thread[cantPerros]; 
        c.start();
        for (int i = 0; i < cantPerros; i++){
            perro[i] = new Thread(new Perro(com));
            perro[i].start();
        }
    }
}
