/*
 * Classe entidade que representará a matriz de distancias
 */
package src;

import static java.lang.Math.abs;
import java.util.ArrayList;

public class MatrizDistancia {
    double[][] matriz;
    ArrayList<Gene> genes;
    EstruturaAuxiliar[] variancias;

    public MatrizDistancia(Amostra amostra) {
        this.matriz = new double[50][50];
        this.genes = amostra.getGenes();
        this.variancias = amostra.assinatura.getAssinatura();
    }
    
    public void initMatriz(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(i!=j && i < j){
                    for(int k = 0; k < 50; k++){
                        double ei = genes.get(variancias[k].getId()).getCromo(i);
                        double ej = genes.get(variancias[k].getId()).getCromo(j);
                        matriz[j][i] += abs(ei - ej);
                    }
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
