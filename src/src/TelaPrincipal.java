package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public final class TelaPrincipal extends JFrame{  
    JPanel corpo = new JPanel();
    JLabel busao = new JLabel();
    JMenuBar menuBar = new JMenuBar();
    JMenu menuAbrir = new JMenu("Abrir");  
    JMenu menuRodar = new JMenu ("Rodar");
    JMenu menuAlterar = new JMenu ("Alterar");
    JMenu menuExibir = new JMenu ("Exibir");
    JMenu menuSalvar = new JMenu ("Salvar");
    
    JMenuItem menuAmostras = new JMenuItem("Amostras");  
    JMenuItem menuGAmostras = new JMenuItem("Grupo de Amostras"); 
    
    JMenuItem menuAgrupamento = new JMenuItem("Agrupamento"); 
    JMenuItem menuValidacao = new JMenuItem("Validação Cruzada"); 
    
    JMenuItem menuCCorte = new JMenuItem("Criterio de Corte");
    
    JMenuItem menuEListaGenes = new JMenuItem("Lista de Genes");
    JMenuItem menuEDendograma = new JMenuItem("Dendograma");
    
    JMenuItem menuSListaGenes = new JMenuItem("Lista de Genes");
    JMenuItem menuSMatriz = new JMenuItem("Matriz de Distância");
    JMenuItem menuSDendograma = new JMenuItem("Dendograma");
    
    public TelaPrincipal(){
        super();  
        this.setLayout(null);
        this.setPreferredSize(new java.awt.Dimension(800, 600));
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Genetic");
        this.setLocationRelativeTo(null);  
        initTelaPrincipal();
        menuAmostras.addActionListener((ActionEvent e) -> { try {
            SeletorArquivo.getInstance().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } );
        menuGAmostras.addActionListener( (ActionEvent e) -> { } );
        menuAgrupamento.addActionListener( (ActionEvent e) -> { } );
        menuValidacao.addActionListener( (ActionEvent e) -> { } );
        menuCCorte.addActionListener((ActionEvent e) -> { } );
        menuEListaGenes.addActionListener( (ActionEvent e) -> { } );
        menuEDendograma.addActionListener( (ActionEvent e) -> { } ); 
        menuSalvar.addActionListener( (ActionEvent e) -> { } );
        this.setVisible(true);
    }
    
    public void initTelaPrincipal() {
         this.setJMenuBar(menuBar);  
         this.add(busao);
         busao.setIcon(new javax.swing.ImageIcon(getClass().getClassLoader().getResource("img/genetic.jpg")));
         busao.setBounds(0, -50, 800, 600);
         menuAbrir.add(menuAmostras);
         menuAbrir.add(menuGAmostras);
         menuRodar.add(menuAgrupamento);
         menuRodar.add(menuValidacao);
         menuAlterar.add(menuCCorte);
         menuExibir.add(menuEListaGenes);
         menuExibir.add(menuEDendograma);
         menuSalvar.add(menuSListaGenes);
         menuSalvar.add(menuSMatriz);
         menuSalvar.add(menuSDendograma);
         menuBar.add(menuAbrir);  
         menuBar.add(menuRodar);
         menuBar.add(menuAlterar);
         menuBar.add(menuExibir);
         menuBar.add(menuSalvar);        
    }
    
    public static void main(String[] args){
        new TelaPrincipal();
    }
}


