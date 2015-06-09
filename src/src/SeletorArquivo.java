/*
 * Classe usada para selecionar o arquivo de entrada.
 * Aqui o arquivo também será lido e as classes entidades
 * serão inicializadas a partir dos dados lidos
 */
package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

public class SeletorArquivo extends JFileChooser{
    //Atributos para o seletor
    private BufferedReader breader;
    private FileReader freader;
    private File file;
    /* Essa variável definirá se é a primeira leitura ou não,
     * pois caso aconteça uma mudança no tamanho da assinatura
     * ele não deve lê o arquivo novamente, apenas usa dos dados
     * que já foram lidos para gerar uma nova assinatura
     */
    private static boolean leu;
    
    //ED que será retornada contendo todos os dados lidos e obtidos
    private static EDAmostra amostra;
        
    public SeletorArquivo(){
        //Configurações do seletor
        JFileChooser fc = new JFileChooser();
        int opcao = fc.showOpenDialog(this);
        if (opcao == JFileChooser.APPROVE_OPTION) {
            this.file = fc.getSelectedFile();
            try { this.freader = new FileReader(file); } catch (FileNotFoundException ex) { Logger.getLogger(SeletorArquivo.class.getName()).log(Level.SEVERE, null, ex); }
            this.breader = new BufferedReader(freader);
            }
    }
    
    public EDAmostra lerAmostras(int tamanho) throws IOException{
        double[] v; //Vetor usado como parametro para o método que acha a variancia
        Variance variance = new Variance(); //Uso da biblioteca Apache Commons Math 3.5
        if(!leu){ //Primeira leitura
            amostra = new EDAmostra(tamanho);
            String data;
            while((data = breader.readLine()) != null){ //Lendo todas as linhas do arquivo (cada linha é um gene)
                EDGene g = new EDGene();
                String[] resultado = data.split("\t");
                g.setName(resultado[0]);
                for(int i = 1; i < resultado.length; i++){
                    float f = Float.parseFloat(resultado[i]);
                    g.add(f);   /* Adicionando os valores de expressividade para cada individuo
                                 * Cada individuo é representado por um indice no array
                                 * Esse indice é único para cada individuo,
                                 * independente do gene que está se olhando
                                 */
                }
                amostra.add(g);//Adicionando o gene a amostra;
                v = g.toVector();
                amostra.getAssinatura().add(variance.evaluate(v), amostra.getAllGenes().indexOf(g)); //Adicionando (ou não) o gene a assinatura;
            }
            leu = !leu;/* Após a primeira leitura,
                        * o booleano é setado para true para sinalizar que já houve a primeira leitura;
                        */
        }
        else{ //Redefinição do tamanho da assinatura;
            amostra.getAssinatura().setAssinatura(tamanho);//Setando o novo tamanho para a assinatura
            for(EDGene g:amostra.getAllGenes()){                   
                v = g.toVector();                                 
                amostra.getAssinatura().add(variance.evaluate(v),   
                        amostra.getAllGenes().indexOf(g));          
                /* Pegando a variancia de todos os genes para gerar a nova assinatura
                 * Aqui há um impasse, pois poderia ser melhor já guardar a variância do gene dentro
                 * da ED que o representa. Mas isso geraria uma demanda maior de espaço na memória
                 * Logo, é preciso se pensar no custo benefício disso.
                 * Acreditamos que a redefinição do tamanho da assinatura não é algo recorrente,
                 * então optamos por buscar essas variâncias novamente sempre que o tamanho da assinatura
                 * é redefinido;
                 */
            }
        }
        return amostra; //Retorna a amostra pronta, com os dados inicializados;
    }
}