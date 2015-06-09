/*
 * Classe responsavel por salvar os arquivos com
 * as respostas geradas
 */
package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

public class SalvaArquivo extends JFileChooser{
    File file;
    FileWriter fw;
    public SalvaArquivo (String texto) throws IOException{
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(SalvaArquivo.this) != JFileChooser.APPROVE_OPTION){
            return;
        }
        
        File arquivo = fc.getSelectedFile();
        FileWriter writer = null;
        try {
            writer = new FileWriter(arquivo);
            writer.write(texto);
        } 
        catch(IOException ex){}
        finally {
            if(writer != null){
                try{writer.close();} 
                catch (IOException x){}
            }
        }
    }
}
