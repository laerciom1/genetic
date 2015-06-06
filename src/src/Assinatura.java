/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author CH1CO
 */
public class Assinatura {
    private EstruturaAuxiliar[] variancias;
    
    public Assinatura(){
        variancias = new EstruturaAuxiliar[50];
        for(int i = 0; i < 50; i++){
            variancias[i] = new EstruturaAuxiliar();
            variancias[i].setVariancia(0);
        }
    }
    
    public EstruturaAuxiliar[] getAssinatura(){
        return variancias;
    }
    
    public void add(double variancia, int id) {
        if(variancia > variancias[0].getVariancia()){
            variancias[0].setVariancia(variancia);
            variancias[0].setId(id);
            heapSort();
            /*System.out.println("Insenrindo" + variancia + ":");
            for(int i = 0; i < 10; i++){
                System.out.print(" " + variancias[i].getVariancia() + ":" +  variancias[i].getId());
            }
            System.out.println("\n");*/
        }
    }
    
    //Código adaptado de http://pt.wikipedia.org/wiki/Heapsort#C.C3.B3digo_em_Java
    public void heapSort()
       {
         buildMaxHeap();
         int n = variancias.length;
 
         for (int i = variancias.length - 1; i > 0; i--)
         {
            swap(i , 0);
            maxHeapify(0, --n);
         }
       }
       private void buildMaxHeap()
       {
          for (int i = variancias.length/2 - 1; i >= 0; i--)
             maxHeapify(i , variancias.length );
       }
       private void maxHeapify(int pos, int n)
       {
          int maxi;
          int l = 2 * pos;
          int right = 2 * pos + 1;
          if ( (l < n) && (variancias[l].getVariancia() > variancias[pos].getVariancia()) )
          {
             maxi = l;
          }
          else
          {
             maxi = pos;
          }
          if (right < n && variancias[right].getVariancia() > variancias[maxi].getVariancia())
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
          EstruturaAuxiliar aux = variancias[j];
          variancias[j] = variancias[aposJ];
          variancias[aposJ] = aux;
       }
}
