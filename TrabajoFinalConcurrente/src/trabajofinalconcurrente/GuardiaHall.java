/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajofinalconcurrente;

/**
 *
 * @author Leo
 */
public class GuardiaHall implements Runnable{
    private Hall hall;

    public GuardiaHall(Hall hall) {
        this.hall = hall;
    }
    
    @Override
    public void run() {
        while (true) {
            hall.manejarPuestos();
        }
    }

}
