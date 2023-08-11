/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParcialTema3;

/**
 *
 * @author Leo
 */
public class main {
    public static void main(String[]args){
        Thread t1, t2, f;
        Thread[] socio;
        Television tele = new Television();
        t1 = new Thread(new Traductor(tele));
        t2 = new Thread(new Traductor(tele));
        f = new Thread(new Filmador(tele, 10)); //10 es la cantidad de episodios que se filmaran
        socio = new Thread[3];
        for (int i = 0; i < 3; i++){
            socio[i] = new Thread(new Socio(tele, i, i%2)); //Los alojados en posiciones pares preferiran idioma ingles, los impares idioma español
            socio[i].start();
        }
        t1.start();
        t2.start();
        f.start();
    }
}
