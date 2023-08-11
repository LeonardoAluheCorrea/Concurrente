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
        int cantMiembros = 20;
        salon = new Salon(cantMiembros);
        admin = new Thread(new Administrador(almacen));//Craeamos e iniciamos el admin
        admin.start();
        persona = new Thread[cantMiembros];
        for (int i = 0; i < cantMiembros; i++){//Creamos e iniciamos las personas
            persona[i] = new Thread(new Persona (String.valueOf(i),salon, almacen));
            persona[i].start();
        }
    }
}
