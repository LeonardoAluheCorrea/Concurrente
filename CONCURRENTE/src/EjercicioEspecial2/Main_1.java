/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioEspecial2;

/**
 *
 * @author Leo
 */
public class Main {
    public static void main(String[]args){
        Thread[] persona;
        Salon salon;
        Thread admin;
        Almacen almacen = new Almacen();
        salon = new Salon(7);
        admin = new Thread(new Administrador(almacen));//Craeamos e iniciamos el admin
        admin.start();
        persona = new Thread[7];
        for (int i = 0; i < 7; i++){//Creamos e iniciamos las personas
            persona[i] = new Thread(new Persona (String.valueOf(i),salon, almacen));
            persona[i].start();
        }
    }
}
