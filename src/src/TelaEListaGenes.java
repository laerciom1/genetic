/*
 * Tela que exibe a lista de genes.
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Box;
import javax.swing.JMenuItem;

public class TelaEListaGenes extends JFrame{
    JScrollPane scrollPane;
    JTextArea tArea;
    
    
    public TelaEListaGenes(EDAmostra amostra){
        super("Lista de Genes");
        this.setLayout(null);
        this.setPreferredSize(new java.awt.Dimension(1280, 720));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        initTelaEListaGenes(amostra);
        this.setVisible(true);
    }
    
    private void initTelaEListaGenes(EDAmostra amostra){
        String resultado = new String();
        for(EDGene g:amostra.getAllGenes()){
            resultado += g.print();
        }
        Box box = Box.createHorizontalBox();
        tArea = new JTextArea(resultado);
        tArea.setEditable(false);
        box.add(scrollPane = new JScrollPane(tArea));
        box.setBounds(10, 10, 1245, 630);
        add(box);
    }
}