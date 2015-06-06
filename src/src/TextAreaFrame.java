import java.awt.event.ActionListener;  
import java.awt.event.ActionEvent;  
import javax.swing.Box;  
import javax.swing.JFrame;  
import javax.swing.JTextArea;  
import javax.swing.JButton;  
import javax.swing.JScrollPane;  
  
  
  
  
public class TextAreaFrame extends JFrame {  
  
    private JTextArea textArea1;  
    private JTextArea textArea2;  
    private JButton copyJButton;  
      
    public TextAreaFrame(){  
          
        super("TextArea Demo");  
        Box box = Box.createHorizontalBox();  
        String demo = "This is a demo string to\n"+   
        "illustrte copuing text\nfrom one textarea to \n"+  
        "another textarea using an\nexternal event\n";  
          
        textArea1 = new JTextArea(demo,10,15);  
        box.add(new JScrollPane(textArea1));  
          
        copyJButton = new JButton("Copy>>>");  
        box.add(copyJButton);  
        textArea2 = new JTextArea(10,15);  
        textArea2.setEditable(false);  
        box.add(new JScrollPane(textArea2));  
          
        add(box);  
    }  
  
}     