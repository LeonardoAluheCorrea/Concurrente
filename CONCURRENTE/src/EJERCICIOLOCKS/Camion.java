/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOLOCKS;

/**
 *
 * @author Leo
 */
public class Camion implements Runnable{
    private Almacen almacenReparto;

    public Camion(Almacen almacenReparto) {
        this.almacenReparto = almacenReparto;
    }

    @Override
    public void run() {
        while (true){
            almacenReparto.vaciarAlmacen();
        }
    }
    
}
