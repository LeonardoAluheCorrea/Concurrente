/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioEspecial2;

/**
 *
 * @author Leo
 */
public class Administrador implements Runnable {
    
    private Almacen almacen;

    public Administrador(Almacen almacen) {
        this.almacen = almacen;
    }
    
    @Override
    public void run() {
        while (true){
            almacen.reponerIngredientes();
        }
    }
    
}
