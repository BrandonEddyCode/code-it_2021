package MyWorkArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

//import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyWorkAreaItems extends JPanel {

    ImageIcon image = new ImageIcon("res/Expanding_Button.jpg");

    MyWorkAreaItems (String nameTab) {
        JLabel a = new JLabel(nameTab);
        a.setIcon(image);
        a.setHorizontalTextPosition(JLabel.RIGHT); // set text RIGHT of imageIcon
        a.setPreferredSize(new Dimension(100,100));
        a.setVisible(true);
        a.setOpaque(true);
        a.setBackground(Color.lightGray);
        a.setFont(new Font("Helvetica",Font.PLAIN, 15));
        a.setFocusable(false); 
        this.add(a);
    }

}
