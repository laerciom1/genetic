/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import java.util.Locale;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

/**
 *
 * @author CH1CO
 */
public class Amostra {
    public Assinatura assinatura;
    ArrayList<Gene> genes = new ArrayList<>();
    
    public Amostra(){
        assinatura = new Assinatura();
    }
    
    public Gene getGene(int id){
        return genes.get(id);
    }
    
    public ArrayList<Gene> getGenes(){
        return genes;
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
    
    public Assinatura getAssinatura(){
        return assinatura;
    }
    
    public String printAssinatura(){
        EstruturaAuxiliar[] variancias = assinatura.getAssinatura();
        String resultado = new String();
        for(int i = 0; i < variancias.length; i++){
            resultado += "Gene " + variancias[i].getId() + "\t->  Variancia:  " + Double.valueOf(String.format(Locale.US, "%.2f", variancias[i].getVariancia())).toString() + ",\n";
        }
        return resultado;
    }
}