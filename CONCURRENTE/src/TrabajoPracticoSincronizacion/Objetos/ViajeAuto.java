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
            //Tardamos unos segundos en recorrer la distancia hata la estacion de servicio
            Thread.sleep((long)distancia*1000);
            System.out.println("El auto: " + vehiculo.getModelo() + " ha llegado a la estacion de servicio");
            while(!estacion.tieneDisponibilidad()){
                //Al llegar esperamos a que el surtidor este libre
                Thread.sleep(1000);
            }
            //Realizamos el proceso de carga
            estacion.usarSurtidor();
            System.out.println("El auto: " + vehiculo.getModelo() + " esta llenando el tanque");
            Thread.sleep(5000);
            vehiculo.llenarTanque();
            System.out.println("El auto: " + vehiculo.getModelo() + " ha llenado el tanque, libera el surtidor y se va");
            estacion.liberarSurtidor();
        }catch(InterruptedException e){}
    }
    
}
