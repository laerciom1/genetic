/*
 * Classe entidade que representará a matriz de distancias
 */
package src;

import static java.lang.Math.abs;
import java.util.ArrayList;
public class EDMatrizDistancia {
    double[][] matriz;
    ArrayList<EDGene> genes;
    EDAVarianciaID[] variancias;
    EDDistancias distancias;

    public EDMatrizDistancia(EDAmostra amostra) {
        this.variancias = amostra.assinatura.getAssinatura();
        this.matriz = new double[variancias.length][variancias.length];
        this.genes = amostra.getAllGenes();
        this.distancias = new EDDistancias(((genes.get(0).getList().size())*genes.get(0).getList().size())/2);//Formula de uma PA
    }
    
    public void initMatriz(){
        for(int i = 0; i < genes.get(0).getList().size(); i++){
            for(int j = 0; j < genes.get(0).getList().size(); j++){
                if(i!=j && i < j){
                    for(int k = 0; k < variancias.length; k++){
                        double ei = genes.get(variancias[k].getId()).getCromo(i);
                        double ej = genes.get(variancias[k].getId()).getCromo(j);
                        matriz[j][i] += Math.sqrt((ei - ej)*(ei - ej));
                    }
                    distancias.add(i+1, j+2, matriz[j][i]);
                }
            }
        }
    }
    
    public void printMatriz(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.print("\t" + matriz[i][j] + "\t|\t");
            }
            System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    
}
