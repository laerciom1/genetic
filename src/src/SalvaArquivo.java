/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;

/**
 *
 * @author CH1CO
 */
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
        catch(IOException ex){
            // Possiveis erros aqui
        }
        finally {
            if(writer != null){
                try{
                    writer.close();
                } 
                catch (IOException x){
                       //   
                }
            }
        }
    }
}
