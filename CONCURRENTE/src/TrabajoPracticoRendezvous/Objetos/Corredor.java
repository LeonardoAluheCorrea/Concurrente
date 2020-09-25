/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajoPracticoRendezvous.Objetos;

/**
 *
 * @author Leo
 */
public class Corredor implements Runnable {
    private String nombre;
    private TestigoCarrera testigo;
    private int lado;
    private double tiempo;

    public Corredor(String nombre, TestigoCarrera testigo, int lado, double tiempo) {
        this.nombre = nombre;
        this.testigo = testigo;
        this.lado = lado;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        System.out.println(nombre + " espera el testigo");
        if (lado == 1){
            testigo.saleCorredor(nombre);
        }
        else{
            testigo.vuelveCorredor(nombre);
        }
        System.out.println(nombre + " finalizo, tiempo hasta ahora: " + (System.currentTimeMillis() - tiempo) / 1000 + " segundos");
    }
    
}
