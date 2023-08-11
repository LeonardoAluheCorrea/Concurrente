/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioEspecial1;

/**
 *
 * @author Leo
 */
public class Persona implements Runnable {

    private String nombre;
    private Salon salon;

    public Persona(String nombre, Salon salon) {
        this.nombre = nombre;
        this.salon = salon;
    }

    @Override
    public void run() {
        salon.entrar();
        System.out.println(nombre + " entro al salon");
        for (int i = 0; i < 2; i++){//Turnos
            Actividad realizada = null;
            System.out.println(nombre + " comienza el turno " + (i+1));
            for (int j = 0; j < 2; j++){//2 actividades por turno
                salon.hacerTurno(nombre,realizada);
            }           
            System.out.println(nombre + " termina el turno " + (i+1));
        }
        salon.salir();
        System.out.println(nombre + " dejo el salon");
    }
}
