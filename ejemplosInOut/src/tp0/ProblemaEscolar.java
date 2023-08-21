package tp0;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;

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
        Double[] mediaAlumnos = new Double[CANT_ALUMNOS];
        Double[] mediaAsignaturas = new Double[CANT_ASIGNATURAS];
        double mediaClase;
        String[] alumnos = new String[CANT_ALUMNOS];
        leerNotas(notas,alumnos);
        mediaAlumnos = calcularMediaAlumnos(notas);
        mediaClase = calcularMediaClase(mediaAlumnos);
        mediaAsignaturas = calcularMediaAsignaturas(notas);
    }
    
    public static void ordenarAlumnosPorMedia(String[]alumno, Double[] nota){
        //Ordena los alumnos de forma descendiente de acuerdo a sus notas medias
        /* Se utiliza el metodo de ordenamiento burbuja por su sencillez de implementacion 
           y buen rendimiento en bajas cantidades de datos
        */
        for (int i = 0;i < CANT_ALUMNOS; i++){
            for (int j = 0; j < CANT_ALUMNOS; j++){
                if (nota[j] > nota[j+1]){
                    intercambiar(nota, j, j+1);
                    intercambiar(alumno, j, j+1);
                }
            }
        }
    }
    
    public static void ordenarAlumnosPorMediaSeleccion(String[]alumno, Double[] nota){
        //Ordena los alumnos de forma descendiente de acuerdo a sus notas medias
        /* Se utiliza el metodo de ordenamiento por seleccion 
           ya que tambien es eficiente para cantidades pequeñas*/
        int max;
        for (int i = 0; i < CANT_ALUMNOS; i++){
            max = i;
            for (int j = i+1; i < CANT_ASIGNATURAS; j++){
                if (nota[j] > nota[max])
                    max = j;
            }
            intercambiar(nota,i, max);
            intercambiar(alumno,i, max);
        }
    }
 
    
    public static void intercambiar(Object [] v, int n, int k){
        Object aux = v[n];
        v[n] = v[k];
        v[k] = aux;
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
    
    public static double calcularMediaClase(Double[] mediaAlumno){
        double media = 0;
        for (int i = 0; i < CANT_ALUMNOS; i++){
                media = media + mediaAlumno[i];
        }
        media = media / CANT_ALUMNOS;
        return media;
    }
    
    public static Double[] calcularMediaAsignaturas(int[][] notas){
        //Recorremos la matriz de notas por columnas y calculamos el promedio de notas de la asignatura
        Double[] media = new Double[CANT_ASIGNATURAS];
        for (int i = 0; i < CANT_ALUMNOS; i++){
            for (int j = 0; j < CANT_ASIGNATURAS; j++){
                media[i] = media[i] + notas[j][i];
            }
        }
        return media;
    }
    
    public static Double[] calcularMediaAlumnos(int[][] notas){
        //Recorremos la matriz de notas por filas y calculamos el promedio de notas del alumno
        Double[] media = new Double[CANT_ALUMNOS];
        for (int i = 0; i < CANT_ALUMNOS; i++){
            for (int j = 0; j < CANT_ASIGNATURAS; j++){
                media[i] = media[i] + notas[i][j];
            }
        }
        return media;
    }
    
    
}
