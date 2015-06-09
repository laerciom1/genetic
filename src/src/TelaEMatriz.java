/*
 * Tela que exibe a matriz de distancias geradas.
 * Vale ressaltar que esta sendo usada a distancia Euclidiana
 * para o calculo dessa distancia;
 */
package src;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class TelaEMatriz extends JFrame{
    JMenuBar menuBar = new JMenuBar();
    JMenu menuSalvar = new JMenu("Arquivo"); 
    JMenuItem menuSSalvar = new JMenuItem("Salvar");
    JScrollPane scrollPane;
    JTextArea tArea;
    public TelaEMatriz(EDMatrizDistancia md){
        super("Matriz de Distancias"); 
        geraLista(md); //Esse método gera a String que será exibida nesta tela;
        initTelaEMatriz();
        
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
    
    private void initTelaEMatriz(){
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
    
    private void geraLista(EDMatrizDistancia md){ //Esse método gera a String que será exibida nesta tela;
        String resultado = new String();
        resultado = md.printMatriz();
        tArea = new JTextArea(resultado);
    }
}
