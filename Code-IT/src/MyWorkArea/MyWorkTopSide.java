package MyWorkArea;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;


class MyWorkTopSide extends JPanel {
    JLabel myWorkTitleText = new JLabel();          // Title for page
    JTextArea topLabel = new JTextArea("My Work");
    
    // left side title
    MyWorkTopSide(){
        this.setBackground(Color.GREEN);
        this.setPreferredSize(new Dimension(100,100));
        this.setLayout(new BorderLayout(5,5));
        welcomeTextSettings();
    }
    
    void welcomeTextSettings(){
        myWorkTitleText.setPreferredSize(new Dimension(250,250));
        myWorkTitleText.setFont(new Font("Helvetica",Font.PLAIN, 15));
        myWorkTitleText.setOpaque(true);
        myWorkTitleText.setBackground(Color.black); 
        this.add(topLabel,BorderLayout.WEST);
        this.add(myWorkTitleText);
        
    }
    


}