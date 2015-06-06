/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.apache.commons.math3.stat.descriptive.moment.Variance;

/**
 *
 * @author CH1CO
 */
public class SeletorArquivo extends JFileChooser{
    private static SeletorArquivo chooser;
    private BufferedReader breader;
    private FileReader freader;
    private File file;
    private static Amostra amostra;
    FileFilter filter = new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getAbsolutePath().endsWith(".txt");
        }
        public String getDescription() {
            return "Documentos de texto (*.txt)";
        }
    };
    
    public SeletorArquivo() throws IOException, FileNotFoundException{
        JFileChooser fc = new JFileChooser();
        int opcao = fc.showOpenDialog(this);
        if (opcao == JFileChooser.APPROVE_OPTION) {
            if(filter.accept(fc.getSelectedFile())){
                this.file = fc.getSelectedFile();
                this.freader = new FileReader(file);
                this.breader = new BufferedReader(freader);
                ler();
            }
            else{
                TelaTipoDoArquivo.getInstance();
            }
        }
    }
    
    public void ler() throws IOException{
        amostra = new Amostra();
        String data;
        double[] v;
        Variance variance = new Variance();
        while((data = breader.readLine()) != null){
            Gene g = new Gene();
            String[] resultado = data.split("\t");
            g.setName(resultado[0]);
            for(int i = 1; i < resultado.length; i++){
                float f = Float.parseFloat(resultado[i]);
                g.add(f);
            }
            amostra.add(g);
            v = g.toVector();
            amostra.assinatura.add(variance.evaluate(v), amostra.getGenes().indexOf(g));
        }
    }
    
    public static Amostra getAmostra(){
        return amostra;
    }
    
    public File getSelectedFile(){
        return file;
    }
}