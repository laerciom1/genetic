/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author CH1CO
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Box;

public class TelaEListaGenes extends JFrame{
    JMenuBar menuBar = new JMenuBar();
    JMenu menuSalvar = new JMenu("Salvar"); 
    JScrollPane scrollPane;
    JTextArea tArea;
    
    
    public TelaEListaGenes(Amostra amostra){
        super("Lista de Genes");
        this.setLayout(null);
        this.setPreferredSize(new java.awt.Dimension(1280, 720));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setJMenuBar(menuBar);
        menuSalvar.addActionListener( (ActionEvent e) -> { new TelaEListaGenes(amostra); } );
        initTelaEListaGenes(amostra);
        this.setVisible(true);
    }
    
    private void initTelaEListaGenes(Amostra amostra){
        String resultado = new String();
        for(Gene g:amostra.getGenes()){
            resultado += g.print();
        }
        Box box = Box.createHorizontalBox();
        tArea = new JTextArea(resultado);
        tArea.setEditable(false);
        box.add(scrollPane = new JScrollPane(tArea));
        menuBar.add(menuSalvar);
        box.setBounds(10, 10, 1245, 630);
        add(box);
    }
    
}
