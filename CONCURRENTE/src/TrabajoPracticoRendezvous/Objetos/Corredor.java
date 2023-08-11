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
    private int equipo;
    private double tiempo;

    public Corredor(String nombre, TestigoCarrera testigo, int lado, double tiempo) {
        this.nombre = nombre;
        this.testigo = testigo;
        this.equipo = lado;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        testigo.recibeTestigo();
        System.out.println(nombre + " recibio el testigo, sale");
        testigo.corre();
        System.out.println(nombre + " finalizo, tiempo hasta ahora del equipo " + equipo + ": " + (System.currentTimeMillis() - tiempo) / 1000 + " segundos");
        testigo.entregaTestigo();
    }
    
}
