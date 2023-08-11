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
public class Main2 {
    public static void main(String []args){
        Thread[] persona;
        Thread control;
        MontaniaRusa m = new MontaniaRusa(5, 2); //5: capacidad   2: cantidad de recorridos
        control = new Thread(new ControlMontaniaRusa(m));
        control.start();
        persona = new Thread[20]; //20 personas 
        for (int i = 0; i < 20; i++){
            persona[i] = new Thread(new Persona(m));
            persona[i].start();
        }
    }
}
