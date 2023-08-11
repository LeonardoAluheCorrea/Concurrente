/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOLOCKS;

/**
 *
 * @author Leo
 */
public class Main {
    public static void main(String[]args){
        Thread [] embotellador;
        Almacen reparto, maduracion;
        reparto = new Almacen();
        maduracion = new Almacen();
        Caja vino, agua;
        vino = new Caja(true, 2);
        agua = new Caja(false, 0);
        Fabrica fabrica = new Fabrica(vino, agua);
        Thread empaquetador = new Thread(new Empaquetador(reparto, maduracion, fabrica));
        Thread camion = new Thread(new Camion(reparto));
        embotellador = new Thread[2];
        for (int i = 0; i < 2; i++){
            embotellador[i] = new Thread(new Embotellador(fabrica,i));
            embotellador[i].start();
        }
        camion.start();
        empaquetador.start();
    }
}
