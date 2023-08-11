/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio02;

/**
 *
 * @author casa
 */
public class mainEjercicio02 {
    public static void main(String[] args) {
        Recipiente r = new Recipiente(3);
        Generador g = new Generador(3,r);
        g.start();
    }
}
