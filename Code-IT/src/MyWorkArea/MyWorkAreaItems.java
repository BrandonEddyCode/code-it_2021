package MyWorkArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
//import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MyWorkAreaItems extends JPanel {


    ImageIcon image = new ImageIcon("res/Expanding_Button.png");
    JButton button = new JButton (image);
    JPanel work;
    boolean isExpanded = true;
    JPanel a = new JPanel();
    

    MyWorkAreaItems (String nameTab) { // expanding tabs for My Work page
        a = new JPanel();
        JTextArea font = new JTextArea(nameTab);
        button.addActionListener(e -> MyWorkAreaAction()); // when button is clicked it expands
        a.add(button);
        a.add(font);
        a.setPreferredSize(new Dimension(2000,50));
        a.setVisible(true);
        a.setOpaque(true);
        a.setBackground(Color.white);
        this.setBackground(Color.black);
        font.setFont(new Font("Helvetica",Font.BOLD, 15));
        a.setFocusable(false); 
        add(a);
    }

    void MyWorkAreaAction () {
        if (isExpanded) {
            isExpanded = false;
            a.setPreferredSize(new Dimension(2000,10000));
            a.revalidate();
            a.repaint();
        } 
        
        else {
            isExpanded = true;
            a.setPreferredSize(new Dimension(2000,50));
            a.revalidate();
            a.repaint();
        }
    }


}
