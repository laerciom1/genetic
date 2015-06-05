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
public class Amostra {
    ArrayList<Gene> genes = new ArrayList<Gene>();
   
    public Gene getGene(int id){
        return genes.get(id);
    }
    
    public void add(Gene gene){
        this.genes.add(gene);
    }
    
    public void printAll(){
        for(Gene g: genes){
            System.out.print("" + genes.indexOf(g) + " ");
            g.print();
        }
    }
}