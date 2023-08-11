/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JefeEmpleadosModificado;

/**
 *
 * @author Admin
 */
public class TestSaludo{
    
    public static void main(String argv[]) throws InterruptedException{
        int cantEmpleados = 5;
        String[] nombresEmpleados = {"Pablo", "Luis", "Andrea","Pedro", "Paula"};
        Saludo hola = new Saludo();
        Thread[] elPersonal = new Thread[cantEmpleados + 1];
        elPersonal[0] = new Thread(new Personal(hola, "JEFE", cantEmpleados));
        for (int i = 0; i < cantEmpleados; i++) elPersonal[i + 1] = new Thread(new Personal(hola, nombresEmpleados[i]));
        for (int i = 0; i <= cantEmpleados; i++) elPersonal[i].start();
        for (int i = 0; i <= cantEmpleados; i++) elPersonal[i].join();
        System.out.println("LISTO, ahora que todos han saludado - a trabajar");
    }
}