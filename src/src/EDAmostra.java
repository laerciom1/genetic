/*
 * Classe que representa um conjunto de amostras.
 * O ArrayList guarda os valores do gene para cada individuo da amostra.
 * A assinatura é iniciada ao se fazer a leitura do arquivo, e guarda os top50 genes mais
 * variáveis da amostra.
 * A variancia é calulada usando a biblioteca Apache Commons Math 3.5.
 */
package src;

import java.util.ArrayList;
import java.util.Locale;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

public class EDAmostra {
    private EDAssinatura assinatura; //Assinatura
    ArrayList<EDGene> genes = new ArrayList<>(); //ArrayLista com todos os Genes
    
    
    public EDAmostra(int tamanho){
        assinatura = new EDAssinatura(tamanho);
    }
    
    public EDGene getGene(int id){
        return genes.get(id);
    }
    
    public ArrayList<EDGene> getAllGenes(){
        return genes;
    }
    
    public void add(EDGene gene){
        this.genes.add(gene);
    }
    
    public void printAll(){
        for(EDGene g: genes){
            System.out.print("" + genes.indexOf(g) + " ");
            g.print();
        }
    }
    
    public EDAssinatura getAssinatura(){
        return assinatura;
    }
    
    public String printAssinatura(){
        EDAVarianciaID[] variancias = assinatura.getAssinatura();
        String resultado = new String();
        for(int i = 0; i < variancias.length; i++){
            resultado += "Gene " + (variancias[i].getId()) + "\t->  Variancia:  " + Double.valueOf(String.format(Locale.US, "%.2f", variancias[i].getVariancia())).toString() + ",\n";
        }
        return resultado;
    }
}