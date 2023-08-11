/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.TdaEspecificos;
import TDAEspecificos.GrafoEtiquetado;
/**
 *
 * @author Leo
 */
public class testGrafoEtiquetado {
    public static void main(String[]args){
        GrafoEtiquetado grafoA;
        grafoA = new GrafoEtiquetado();
        System.out.println("Insertamos arco en grafo vacio. Debe dar false --> " + grafoA.insertarArco(2,2,3));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Insertamos A en el grafo. Debe dar true --> " + grafoA.insertarVertice("A"));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Insertamos B en el grafo. Debe dar true --> " + grafoA.insertarVertice("B"));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Insertamos C en el grafo. Debe dar true --> " + grafoA.insertarVertice("C"));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Insertamos arco A-A. Debe dar true --> " + grafoA.insertarArco("A","A",1));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Insertamos arco B-B. Debe dar true --> " + grafoA.insertarArco("B","B",1));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Insertamos arco A-B. Debe dar true --> " + grafoA.insertarArco("A","B",1));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Insertamos arco A-C. Debe dar true --> " + grafoA.insertarArco("A","C",1));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Insertarmos arco C-B. Debe dar true --> " + grafoA.insertarArco("C","B",1));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Insertamos arco con origen inexistente. Debe dar false --> " + grafoA.insertarArco(3,"B", 1));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Insertamos arco con destino inexistente. Debe dar false --> " + grafoA.insertarArco("A",3,1));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Insertamos arco con destino y origen inexistente. Debe dar false --> " + grafoA.insertarArco(3,3,1));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        grafoA.insertarVertice("D");
        grafoA.insertarVertice("Q");
        grafoA.insertarVertice("E");
        grafoA.insertarArco("E", "A",1);
        grafoA.insertarArco("E", "Q",1);
        grafoA.insertarArco("Q", "D",1);
        grafoA.insertarArco("D", "C",1);
        grafoA.eliminarArco("A", "A");
        grafoA.eliminarArco("B", "B");
        System.out.println("Probamos encontrar la longitud del camino mas corto entre 2 nodos");
        System.out.println("\n");
        System.out.println(grafoA.caminoMasRapido("A","Q").toString());
        System.out.println("\n");
        System.out.println("Comenzamos prueba de eliminacion");
        System.out.println("Eliminamos arco A-A. Debe dar true --> " + grafoA.eliminarArco("A","A"));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Eliminamos arco B-B. Debe dar true --> " + grafoA.eliminarArco("B","B"));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Eliminamos arco A-B. Debe dar true --> " + grafoA.eliminarArco("A", "B"));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Eliminamos arco inexistente (A-B). Debe dar false --> " + grafoA.eliminarArco("A","B"));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("Eliminamos vertice A. Debe dar true --> " + grafoA.eliminarVertice("A"));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Eliminamos vertice C (inicio). Debe dar true --> " + grafoA.eliminarVertice("C"));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Eliminamos vertice inexistente. Debe dar false --> " + grafoA.eliminarVertice(2));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        grafoA.eliminarVertice("B");
        System.out.println("Eliminamos arco en grafo vacio. Debe dar false --> " + grafoA.eliminarArco(2,2));
        System.out.println("Grafo actual --> " + grafoA.toString());
        System.out.println("\n");
        System.out.println("Eliminamos vertice en grafo vacio. Debe dar false --> " + grafoA.eliminarArco(2,2));
        System.out.println("Grafo actual --> " + grafoA.toString());
    }
}
