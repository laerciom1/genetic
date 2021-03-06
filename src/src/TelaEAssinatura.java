/*
 * Tela que exibe a assinatura gerada;
 * Vale ressaltat que o método que está sendo
 * usado para o calculo dos genes representativos
 * é o método da variância
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

public class TelaEAssinatura extends JFrame{
    //Atributos do layout
    JMenuBar menuBar = new JMenuBar();
    JMenu menuSalvar = new JMenu("Arquivo"); 
    JMenuItem menuSSalvar = new JMenuItem("Salvar");
    JScrollPane scrollPane;
    JTextArea tArea;
    
    public TelaEAssinatura(EDAmostra amostra){
        //Setando atributos da UI
        super("Assinatura"); 
        geraLista(amostra); //Esse método gera a String que será exibida nesta tela;
        initTelaEAssinatura();
        
        //Configurando o botão salvar
        menuSSalvar.addActionListener((ActionEvent e) -> {
            try {
                new SalvaArquivo(tArea.getText());
            }
            catch (IOException ex) {
                Logger.getLogger(TelaEAssinatura.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.setVisible(true);
    }
    
    private void initTelaEAssinatura(){
        this.setLayout(null);
        this.setPreferredSize(new java.awt.Dimension(1280, 720));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setJMenuBar(menuBar);
        Box box = Box.createHorizontalBox();
        tArea.setEditable(false);
        box.add(scrollPane = new JScrollPane(tArea));
        menuSalvar.add(menuSSalvar);
        menuBar.add(menuSalvar);
        box.setBounds(10, 10, 1245, 630);
        add(box);
    }
    
    private void geraLista(EDAmostra amostra){ //Esse método gera a String que será exibida nesta tela;
        String resultado = new String();
        resultado = amostra.printAssinatura();
        tArea = new JTextArea(resultado);
    }
}