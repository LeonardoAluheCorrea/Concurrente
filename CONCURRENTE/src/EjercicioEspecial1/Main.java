/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioEspecial1;

/**
 *
 * @author Leo
 */
public class Main {
    
    public static void main (String[]args){
        Actividad[] actividad;
        Thread[] persona;
        Thread guardia;
        Salon salon;
        salon = new Salon();//Creamos el salon
        actividad = new Actividad[3];
        //Creamos las 3 actividades
        actividad[0] = new Actividad("Acro telas", salon);
        actividad[1] = new Actividad ("Lyra acrobatica", salon);
        actividad[2] = new Actividad ("Yoga en aro", salon);
        salon.setActividad(actividad);//Añadimos las actividades al salon
        persona = new Thread[12];
        for (int i = 0; i < 12; i++){//Creamos 12 personas
            persona[i] = new Thread(new Persona(String.valueOf(i),salon));         
        }
        //Creamos e iniciamos el guardia
        guardia = new Thread(new Guardia(salon));
        guardia.start();
        for (int i = 0; i < 12; i++){//Iniciamos todas las personas
            persona[i].start();
        }
    }
    
}
