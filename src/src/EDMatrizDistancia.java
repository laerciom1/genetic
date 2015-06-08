/*
 * Classe entidade que representará a matriz de distancias
 */
package src;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Locale;
public class EDMatrizDistancia {
    double[][] matriz;
    EDAmostra genes;
    EDAVarianciaID[] variancias;
    EDDistancias distancias;

    public EDMatrizDistancia(EDAmostra amostra) {
        this.variancias = amostra.assinatura.getAssinatura();
        this.matriz = new double[variancias.length][variancias.length];
        this.genes = amostra;
        this.distancias = new EDDistancias(((genes.getGene(0).getList().size()*genes.getGene(0).getList().size())-genes.getGene(0).getList().size())/2);//Formula de uma PA
    }
    
    public void initMatriz(){
        int index = -1;
        for(int i = 0; i < genes.getGene(0).getList().size(); i++){
            for(int j = i+1; j < genes.getGene(0).getList().size(); j++){
                for (EDAVarianciaID variancia : variancias) {
                    double ei = genes.getGene(variancia.getId()).getCromo(i);
                    double ej = genes.getGene(variancia.getId()).getCromo(j);
                    matriz[i][j] += (ei - ej)*(ei - ej);
                }
                matriz[i][j] = Math.sqrt(matriz[i][j]);
                //System.out.println("A " + i + " " + j + " " + matriz[i][j]);
                distancias.add(++index, i, j, matriz[i][j]);
            }
        }
        distancias.heapSort();
    }
    
    public void printMatriz(){
        for(int i = 0; i < genes.getGene(0).getList().size(); i++){
            for(int j = 0; j < genes.getGene(0).getList().size(); j++){
                if(i == j || i > j){
                    System.out.print("1.00000 \t");
                }
                else{
                    System.out.print(Double.valueOf(String.format(Locale.US, "%.2f", matriz[i][j])) + "\t");
                }
            }
            System.out.print("\n");
        }
        for(EDADistancias ed: distancias.getDistancias()){
            ed.print();
        }
    }
}
