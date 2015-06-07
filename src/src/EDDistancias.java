/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;

/**
 *
 * @author CH1CO
 */
public class EDDistancias {
    private ArrayList<EDADistancias> distancias;
    
    public EDDistancias(int tamanho){
        distancias = new ArrayList<EDADistancias>(tamanho);
        for(EDADistancias e: distancias){
            e = new EDADistancias(0,0,0);
        }
    }
    
    public ArrayList<EDADistancias> getAssinatura(){
        return distancias;
    }
    
    public void add(int id1, int id2, double distancia) {
        EDADistancias  e = new EDADistancias(id1,id2,distancia);
        distancias.add(e);
        heapSort();
    }
    
    public void setDistancias(int tamanho){
        this.distancias = new ArrayList<EDADistancias>(tamanho);
        for(EDADistancias e: distancias){
            e = new EDADistancias(0,0,0);
        }
    }
    
    //Código adaptado de http://pt.wikipedia.org/wiki/Heapsort#C.C3.B3digo_em_Java
    public void heapSort()
       {
         buildMaxHeap();
         int n = distancias.size();
 
         for (int i = distancias.size() - 1; i > 0; i--)
         {
            swap(i , 0);
            maxHeapify(0, --n);
         }
       }
       private void buildMaxHeap()
       {
          for (int i = distancias.size()/2 - 1; i >= 0; i--)
             maxHeapify(i , distancias.size() );
       }
       private void maxHeapify(int pos, int n)
       {
          int maxi;
          int l = 2 * pos;
          int right = 2 * pos + 1;
          if ( (l < n) && (distancias.get(l).getDistancia() > distancias.get(pos).getDistancia()) )
          {
             maxi = l;
          }
          else
          {
             maxi = pos;
          }
          if (right < n && distancias.get(right).getDistancia() > distancias.get(maxi).getDistancia())
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
          EDADistancias aux = distancias.get(j);
          distancias.get(j).setId1(distancias.get(aposJ).getId1());
          distancias.get(j).setId2(distancias.get(aposJ).getId2());
          distancias.get(j).setDistancia(distancias.get(aposJ).getDistancia());
          distancias.get(aposJ).setDistancia(aux.getId1());
          distancias.get(aposJ).setDistancia(aux.getId2());
          distancias.get(aposJ).setDistancia(aux.getDistancia());
       }
}