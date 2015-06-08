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
    //Atributos do layout
    JScrollPane scrollPane;
    JTextArea tArea;
    
    public TelaEListaGenes(EDAmostra amostra){
        //Setando atributos da UI
        super("Lista de Genes");
        geraLista(amostra); //Esse método gera a String que será exibida nesta tela;
        initTelaEListaGenes();
        this.setVisible(true);
    }
    
    private void initTelaEListaGenes(){
        this.setLayout(null);
        this.setPreferredSize(new java.awt.Dimension(1280, 720));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        Box box = Box.createHorizontalBox();
        tArea.setEditable(false);
        box.add(scrollPane = new JScrollPane(tArea));
        box.setBounds(10, 10, 1245, 630);
        add(box);
    }
    
    private void geraLista(EDAmostra amostra){ //Esse método gera a String que será exibida nesta tela;
        String resultado = new String();
        for(EDGene g:amostra.getAllGenes()){
            resultado += g.print();
        }
        tArea = new JTextArea(resultado);
    }
}