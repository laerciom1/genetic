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
    
    
    public EDAmostra(int tamanho){ /* É preciso definir o tamanho da assinatura
                                    * aqui, esse vetor será preenchido durante
                                    * a leitura dos dados. Como não se trata de 
                                    * uma estrutura dinâmica, deve-se saber o
                                    * tamanho da assinatura previamente
                                    */
        assinatura = new EDAssinatura(tamanho);
    }
    
    public EDGene getGene(int id){//Retorna um gene ESPECIFICO
        return genes.get(id);
    }
    
    public ArrayList<EDGene> getAllGenes(){//Retorna A LISTA com todos os Genes
        return genes;
    }
    
    public void add(EDGene gene){//Adiciona um gene a lista de Genes
        this.genes.add(gene);
    }
    
    public EDAssinatura getAssinatura(){
        return assinatura;
    }
    
    public String printAssinatura(){// Método que gera e retorna a assinatura representada em texto
        EDAVarianciaID[] variancias = assinatura.getAssinatura();
        String resultado = new String();
        for (EDAVarianciaID variancia : variancias) {
            resultado += "Gene " + (variancia.getId()) + "\tVariancia: " + Double.valueOf(String.format(Locale.US, "%.2f", variancia.getVariancia())).toString() + ",\n";
        }
        return resultado;
    }
}