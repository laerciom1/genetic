/*
 * Estrutura de dado para armazer todas as distancias entre todos os individuos
 */
package src;

import java.util.ArrayList;

public class EDDistancias {
    private EDADistancias[] distancias; /* Vetor que armazena as distancias.
                                         * O rmazenamento pode ser feito
                                         * em vetor, pois dado quantos individuos
                                         * possui a amostra, é possivel saber
                                         * quantas distancias serão produzidas
                                         * atrave´s da formula:
                                         *            (id*id)-id/2;
                                         * Onde id é o numero de individuos
                                         */
    
    public EDDistancias(int tamanho){ // Inicializando o velor
        distancias = new EDADistancias[tamanho];
        for(int i = 0; i < tamanho; i++){
            distancias[i] = new EDADistancias(0,0,0);
        }
    }
    
    public EDADistancias[] getDistancias(){
        return distancias;
    }
    
    public void add(int index, int id1, int id2, double distancia) {
        distancias[index] = new EDADistancias(id1,id2,distancia);
    }
    
    //Heapsort - Código adaptado de http://pt.wikipedia.org/wiki/Heapsort#C.C3.B3digo_em_Java
    public void heapSort()
       {
         buildMaxHeap();
         int n = distancias.length;
 
         for (int i = distancias.length - 1; i > 0; i--)
         {
            swap(i , 0);
            maxHeapify(0, --n);
         }
       }
       private void buildMaxHeap()
       {
          for (int i = distancias.length/2 - 1; i >= 0; i--)
             maxHeapify(i , distancias.length );
       }
       private void maxHeapify(int pos, int n)
       {
          int maxi;
          int l = 2 * pos;
          int right = 2 * pos + 1;
          if ( (l < n) && (distancias[l].getDistancia() > distancias[pos].getDistancia()) )
          {
             maxi = l;
          }
          else
          {
             maxi = pos;
          }
          if (right < n && distancias[right].getDistancia() > distancias[maxi].getDistancia())
          {
             maxi = right;
          }
          if (maxi != pos)
          {
             swap(pos, maxi);
             maxHeapify(maxi, n);
          }
       }
 
       public void swap (int j, int aposJ )
       {
          EDADistancias aux = distancias[j];
          distancias[j] = distancias[aposJ];
          distancias[aposJ] = aux;
       }
}