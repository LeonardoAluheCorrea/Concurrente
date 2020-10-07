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
public class Hamster implements Runnable {
    private ObjetoHamster plato;
    private ObjetoHamster rueda;
    private ObjetoHamster hamaca;
    private String nombre;

    public Hamster(ObjetoHamster plato, ObjetoHamster rueda, ObjetoHamster hamaca, String nombre) {
        this.plato = plato;
        this.rueda = rueda;
        this.hamaca = hamaca;
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        int opcion;
        opcion = (int) (Math.random() * 3 + 1);
        switch (opcion) {
            case 1:
                System.out.println(nombre + " se dirije hacia la rueda. Si esta ocupada espera");
                rueda.usar(5);
                System.out.println(nombre + " termino de usar la rueda.");
                break;
            case 2:
                System.out.println(nombre + " se dirije hacia el plato. Si esta ocupado espera");
                plato.usar(7);
                System.out.println(nombre + " termino de usar el plato");
                break;
            case 3:
                System.out.println(nombre + " se dirije hacia la hamaca. Si esta ocupada espera");
                hamaca.usar(10);
                System.out.println(nombre+ " termino de usar la hamaca");
                break;
        }
    }
    
}
