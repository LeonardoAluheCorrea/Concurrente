/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author Leo
 */
public class Heap {
    private final int TAMANIO;
    private Comparable[] heap;
    private int ultimo; 
    
    public Heap(int tamanio){
        this.TAMANIO = tamanio;
        heap = new Comparable[TAMANIO];
        ultimo = 0;
    }
    public boolean insertar(Comparable elemento){
        boolean exito;
        exito = false;
        if (ultimo + 1 < TAMANIO){
            heap[ultimo + 1] = elemento;
            ultimo++;
            hacerSubir(ultimo);
            exito = true;
        }
        return exito;
    }
    public Comparable recuperarCima(){
        Comparable cima;
        cima = null;
        if (ultimo != 0){
            cima = heap[1];
        }
        return cima;
    }
    private void hacerSubir(int posHijo){
        int posPadre;
        posPadre = (int)posHijo/2;
        while(posHijo > 1 && heap[posHijo].compareTo(heap[posPadre]) > 0){
            Comparable temp;
            temp = heap[posHijo];
            heap[posHijo] = heap[posPadre];
            heap[posPadre] = temp;
            posHijo = posPadre;
            posPadre = (int)posHijo/2;
        }
    }
    private void hacerBajar(int posPadre){
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;
        while(!salir){
            posH = posPadre * 2;
            if (posH <= this.ultimo){
                //temp tiene al menos un hijo (izq) y lo considera menor
                if (posH < this.ultimo){
                    //hijoMenor tiene hermano derecho
                    if (this.heap[posH + 1].compareTo(this.heap[posH]) > 0){
                        //el hijo derecho es el mayor de los dos
                        posH++;
                    }
                }
                //compara al hijo mayor con el padre
                if (this.heap[posH].compareTo(temp) > 0){
                    //el hijo es mayor que el padre, los intercambia
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                }else{
                    //el padre es menor que sus hijos, esta bien ubicado
                    salir = true;
                }
            }else{
                //el temp es hoja, esta bien ubicado
                salir = true;
            }
        }
    }
    public boolean eliminarCima(){
        boolean exito;
        if (ultimo == 0){
            exito = false;
        }
        else{
            heap[1] = heap[ultimo];
            heap[ultimo] = null;
            ultimo--;
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }
    public boolean esVacio(){
        return ultimo == 0;
    }
    @Override
    public Heap clone(){
        Heap clon;
        clon = new Heap(TAMANIO);
        clon.ultimo = this.ultimo;
        for (int i = 1; i <= this.ultimo; i++){
            clon.heap[i] = this.heap[i];
        }
        return clon;
    }
    @Override
    public String toString(){
        String res;
        res = "";
        if (ultimo == 0){
            res = "arbol vacio";
        }
        else{
            for (int i = 1; i <= ultimo; i++){
                if (2*i > ultimo){
                    res = res + heap[i] + ": HI:  HD:" + "\n";
                }
                else{
                    if (2*i + 1 <= ultimo){
                        res = res + heap[i] + ": HI: " + heap[2*i] + " HD: " + heap[2*i + 1] + "\n";
                    }
                    else{
                        res = res + heap[i] + ": HI: " + heap[2*i] + " HD: " + "\n"; 
                    }
                }
            }
        }
        return res;
    }
}
