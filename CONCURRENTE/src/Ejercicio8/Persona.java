/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio8;

/**
 *
 * @author Leo
 */
public class Persona implements Runnable{
    private int id;
    private SalaEspera sala;

    public Persona(int id, SalaEspera sala) {
        this.id = id;
        this.sala = sala;
    }
    
    @Override
    public void run() {
        //La persona llega al centro de hemeroterapia
        System.out.println(id + " llega al centro de hemeroterapia");
        if (!sala.entrarSala(id)){
            //Si el metodo nos devuelve un falso significa que todavia no se realizo la extraccion de sangre
            //La persona se dirije a tomar una revista
            System.out.println(id + " va a buscar una revista, si no hay entonces mira la tele hasta que haya una disponible");
            sala.esperarRevista();
            System.out.println(id + " toma una revista");
            sala.esperarExtraccion(id);
        }
        //Si el metodo nos devuelve un verdadero significa ya se extrajo la sangre, la persona se va
        System.out.println(id + " ya dono su sangre, se retira");
    }
    
}
