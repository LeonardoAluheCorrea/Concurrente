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
public class ControlMontaniaRusa implements Runnable{
    private MontaniaRusa montania;

    public ControlMontaniaRusa(MontaniaRusa montania) {
        this.montania = montania;
    }
    
    @Override
    public void run() {
        int n = montania.getCantRecorridos();
        for (int i = 0; i < n; i++){ //Hara la cantidad de recorridos que se definieron para la montaña
            montania.hacerRecorrido();
        }
        System.out.println("La montaña rusa a hecho todos sus recorridos, por lo tanto cerrara");
        montania.cerrar();
    }
    
}
