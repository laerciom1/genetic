/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author CH1CO
 */
public class SeletorArquivo extends JFileChooser{
    private static SeletorArquivo chooser;
    File file;
    FileFilter filter = new FileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getAbsolutePath().endsWith(".txt");//To change body of generated methods, choose Tools | Templates.
        }
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "Text documents (*.txt)";
        }
    };
    
    private SeletorArquivo() throws IOException{
        JFileChooser fc = new JFileChooser();
        int opcao = fc.showOpenDialog(this);
        if (opcao == JFileChooser.APPROVE_OPTION) {
            if(filter.accept(fc.getSelectedFile())){
                this.file = fc.getSelectedFile();
                LeitorArquivo leitor = new LeitorArquivo(file);
                leitor.ler();
            }
            else{
                TelaTipoDoArquivo.getInstance();
            }
        }
    }
    
    public static SeletorArquivo getInstance() throws IOException{
        if(chooser == null){
            chooser = new SeletorArquivo();
        }
        return chooser;
    }
    
    public File getSelectedFile(){
        return file;
    }
}