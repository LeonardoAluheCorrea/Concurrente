/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJERCICIOLOCKS;

/**
 *
 * @author Leo
 */
public class Empaquetador implements Runnable{
    private Almacen almacenReparto;
    private Almacen almacenMaduracion;
    private Fabrica fabrica;

    public Empaquetador(Almacen almacenReparto, Almacen almacenMaduracion, Fabrica fabrica) {
        this.almacenReparto = almacenReparto;
        this.almacenMaduracion = almacenMaduracion;
        this.fabrica = fabrica;
    }

 
    @Override
    public void run() {
        while (true) {
            Caja cajaLlena;
            cajaLlena = fabrica.esperarCajaLlena();//Esperamos que una caja se llene y la obtenemos cuando lo hace
            if (cajaLlena.esVino()) { //Si la caja es de vino
                almacenMaduracion.aniadirCaja(cajaLlena); //Añadimos la caja al almacen de maduracion
                System.out.println("Se añadio la caja de vino al almacen de maduracion");
                cajaLlena.madurarVino(almacenReparto, almacenMaduracion);//Comienza el proceso de maduracion del vino
                cajaLlena.cajaLista(); //Liberamos el lock de la caja
                fabrica.reemplazarCajaVino(); //Colocamos una nueva caja para los embotelladores
            } 
            else { // Si la caja es de agua
                almacenReparto.aniadirCaja(cajaLlena); //Añadimos la caja al almacen de reparto
                System.out.println("Se añadio la caja de agua al almacen de reparto");
                cajaLlena.cajaLista(); //Liberamos el lock de la caja
                fabrica.reemplazarCajaAgua();//Colocamos una nueva caja para los embotelladores
            }
        }
    }

}
