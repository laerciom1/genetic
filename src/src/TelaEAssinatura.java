/*
 * Tela que exibe a assinatura gerada;
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
    JMenuBar menuBar = new JMenuBar();
    JMenu menuSalvar = new JMenu("Arquivo"); 
    JMenuItem menuSSalvar = new JMenuItem("Salvar");
    JScrollPane scrollPane;
    JTextArea tArea;
    
    public TelaEAssinatura(EDAmostra amostra){
        super("Assinatura");
        this.setLayout(null);
        this.setPreferredSize(new java.awt.Dimension(1280, 720));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setJMenuBar(menuBar);
        initTelaEAssinatura(amostra);
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
    
    private void initTelaEAssinatura(EDAmostra amostra){
        String resultado = new String();
        resultado = amostra.printAssinatura();
        Box box = Box.createHorizontalBox();
        tArea = new JTextArea(resultado);
        tArea.setEditable(false);
        box.add(scrollPane = new JScrollPane(tArea));
        menuSalvar.add(menuSSalvar);
        menuBar.add(menuSalvar);
        box.setBounds(10, 10, 1245, 630);
        add(box);
    }
}