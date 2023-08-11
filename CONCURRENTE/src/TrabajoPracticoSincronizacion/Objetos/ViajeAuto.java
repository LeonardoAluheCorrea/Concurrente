/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoSincronizacion.Objetos;

/**
 *
 * @author Leo
 */
public class ViajeAuto implements Runnable{
    private Auto vehiculo;
    private double distancia;
    private SurtidorNafta estacion;

    public ViajeAuto(Auto vehiculo, SurtidorNafta estacion, double distancia) {
        this.vehiculo = vehiculo;
        this.estacion = estacion;
        this.distancia = distancia;
    }

    public void run(){
        try{
            vehiculo.recorrerDistancia(distancia);
            System.out.println("El auto: " + vehiculo.getModelo() + "  esta yendo a la estacion de servicio");
            //Tardamos unos segundos en recorrer la distancia hasta la estacion de servicio
            Thread.sleep((long)distancia * 1000);
            System.out.println("El auto: " + vehiculo.getModelo() + " ha llegado a la estacion de servicio, espera su turno");
            //Realizamos el proceso de carga
            estacion.usarSurtidor(vehiculo);
        }catch(InterruptedException e){}
    }
    
}
