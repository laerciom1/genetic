/*
 * Classe entidade que representará a matriz de distancias
 */
package src;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Locale;
public class EDMatrizDistancia {
    double[][] matriz;//Matriz de double;
    EDAmostra genes;                //Atributos que servirao
    EDAVarianciaID[] variancias;    //para recuperar os dados
    EDDistancias distancias;        //que já foram lidos anteriormente
    boolean init = false;           /* Booleano para indicar se a matriz
                                     * já foi iniciada
                                     */

    public EDMatrizDistancia(EDAmostra amostra) {
        this.variancias = amostra.getAssinatura().getAssinatura();
        this.genes = amostra;
        this.matriz = new double[genes.getGene(0).getList().size()][genes.getGene(0).getList().size()];
        this.distancias = new EDDistancias(((genes.getGene(0).getList().size()*genes.getGene(0).getList().size())-genes.getGene(0).getList().size())/2);//Formula de uma PA
    }
    
    public void initMatriz(){
        int index = -1; /* Variavel indice no vetor de distancias
                         * usado posteriormente para se obter o rank de distancias
                         */
                            
        for(int i = 0; i < genes.getGene(0).getList().size(); i++){         // genes.getGene(0).getList().size() retorna quantas posições 
            for(int j = i+1; j < genes.getGene(0).getList().size(); j++){   // um gene possui, o que corresponde ao numero de individuos
                for (EDAVarianciaID variancia : variancias) {   // Variancia possui o ID dos genes que formam a assinatura
                                                                // ou seja, os relevantes para o calculo das distancias
                    double ei = genes.getGene(variancia.getId()).getCromo(i); // Para cada gene, calcula-se a distancia entre todos
                    double ej = genes.getGene(variancia.getId()).getCromo(j); // os individuos em relacao àquele gene.
                    matriz[i][j] += (ei - ej)*(ei - ej); //O que é guardado na matriz é o somatório
                                                         //do quadrado dessa distancia (para a distancia Euclidiada)
                }
                matriz[i][j] = Math.sqrt(matriz[i][j]); //Raiz do somatorio (para a distancia Euclidiana)
                distancias.add(++index, i, j, matriz[i][j]); //Adicionando a distancia encontrada no vetor de distancias
            }
        }
        distancias.heapSort(); /* Apos todas as distancias serem alocadas no vetor,
                                * o heapsort é aplicado para que se tenha o rank.
                                * Optamos pelo heapsort devido a natureza dos dados serem
                                * bastante aleatória.
                                */
    }
    
    public String printMatriz(){ //Método que gera e retorna a matriz representada em texto
        if(!init){
            initMatriz();
        }
        String resultado = new String();
        for(int i = 0; i < genes.getGene(0).getList().size(); i++){
            for(int j = 0; j < genes.getGene(0).getList().size(); j++){
                if(i == j || i > j){
                    resultado += "1.000000 \t";
                }
                else{
                    resultado += Double.valueOf(String.format(Locale.US, "%.2f", matriz[i][j])).toString();
                    resultado += "\t";
                }
            }
            resultado += "\n";
        }
        
        return resultado;
    }
    
    public String printListaD(){ //Método que retorna o rank ddas distancias em texto
        if(!init){
            initMatriz();
        }
        String resultado = new String();
        for(EDADistancias ed: distancias.getDistancias()){
            resultado += ed.print();
        }
        return resultado;
    }
}
