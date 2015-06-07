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
    private BufferedReader breader;
    private FileReader freader;
    private File file;
    private static EDAmostra amostra;
    private static boolean leu;
        
    public SeletorArquivo(){
        JFileChooser fc = new JFileChooser();
        int opcao = fc.showOpenDialog(this);
        if (opcao == JFileChooser.APPROVE_OPTION) {
            this.file = fc.getSelectedFile();
            try { this.freader = new FileReader(file); } catch (FileNotFoundException ex) { Logger.getLogger(SeletorArquivo.class.getName()).log(Level.SEVERE, null, ex); }
            this.breader = new BufferedReader(freader);
            }
    }
    
    public EDAmostra lerAmostras(int tamanho) throws IOException{
        double[] v;
        Variance variance = new Variance();
        if(!leu){
            amostra = new EDAmostra(tamanho);
            String data;
            while((data = breader.readLine()) != null){
                EDGene g = new EDGene();
                String[] resultado = data.split("\t");
                g.setName(resultado[0]);
                for(int i = 1; i < resultado.length; i++){
                    float f = Float.parseFloat(resultado[i]);
                    g.add(f);
                }
                amostra.add(g);
                v = g.toVector();
                amostra.getAssinatura().add(variance.evaluate(v), amostra.getAllGenes().indexOf(g));
            }
            leu = !leu;
        }
        else{
            amostra.getAssinatura().setAssinatura(tamanho);
            for(EDGene g:amostra.getAllGenes()){
                v = g.toVector();
                amostra.getAssinatura().add(variance.evaluate(v), amostra.getAllGenes().indexOf(g));
            }
        }
        return amostra;
    }
    public static EDAmostra getAmostra(){
        return amostra;
    }
}