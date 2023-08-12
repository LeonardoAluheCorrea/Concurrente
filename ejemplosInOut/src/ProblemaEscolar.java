
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leo
 */
public class ProblemaEscolar {
    static final int CANT_ALUMNOS = 7;
    static final int CANT_ASIGNATURAS = 5;
    
    
    public static void main(String[]args){
        int[][] notas = new int[CANT_ALUMNOS][CANT_ASIGNATURAS];
        int[] mediaAlumnos = new int[CANT_ALUMNOS];
        int[] mediaAsignaturas = new int[CANT_ASIGNATURAS];
        double mediaClase;
        String[] alumnos = new String[CANT_ALUMNOS];
        leerNotas(notas,alumnos);
        mediaAlumnos = calcularMediaAlumnos(notas);
        mediaClase = calcularMediaClase(notas);
        mediaAsignaturas = calcularMediaAsignaturas(notas);
    }
    
    public static void leerNotas(int[][] notas, String[]alumnos) {
        FileReader lector = null;
        BufferedReader bufferLector = null;
        Scanner s = null;
        try {
            String archivo = "C:\\Users\\Leo\\Documents\\NetBeansProjects\\Universidad\\ejemplosInOut\\src\\Alumnos.txt";
            lector = new FileReader(archivo);
            bufferLector = new BufferedReader(lector);
            s = new Scanner(bufferLector);
            int i = 0, j = 0;
            s.nextLine();
            for (i = 0; i < 7; i++) {
                //Avanzamos hasta encontrar notas
                while (!s.hasNextInt()) {
                    alumnos[i] = s.next();
                }
                //Cargamos las notas de alumno al arreglo
                for (j = 0; j < 5; j++) {
                    notas[i][j] = s.nextInt();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProblemaEscolar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                lector.close();
                bufferLector.close();
                s.close();
            } catch (IOException ex) {
                Logger.getLogger(ProblemaEscolar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static double calcularMediaClase(int[][] notas){
        double media = 0;
        for (int i = 0; i < CANT_ALUMNOS; i++){
            for (int j = 0; j < CANT_ASIGNATURAS; j++){
                media = media + notas[i][j];
            }
        }
        media = media / (CANT_ALUMNOS*CANT_ASIGNATURAS);
        return media;
    }
    
    public static int[] calcularMediaAsignaturas(int[][] notas){
        int[] media = new int[CANT_ASIGNATURAS];
        for (int i = 0; i < CANT_ALUMNOS; i++){
            for (int j = 0; j < CANT_ASIGNATURAS; j++){
                media[i] = media[i] + notas[j][i];
            }
        }
        return media;
    }
    
    public static int[] calcularMediaAlumnos(int[][] notas){
        int[] media = new int[CANT_ALUMNOS];
        for (int i = 0; i < CANT_ALUMNOS; i++){
            for (int j = 0; j < CANT_ASIGNATURAS; j++){
                media[i] = media[i] + notas[i][j];
            }
        }
        return media;
    }
    
    
}
